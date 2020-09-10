package pers.vv.study.nio;

import pers.vv.study.common.Utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @author guoshixiong
 */
public class SocketOperator {

    public static final int PORT = 8001;

    private static final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        new Thread(new Server(), "server").start();

        new Thread(new Client(), "client-1").start();
//        new Thread(new Client(), "client-2").start();
//        new Thread(new Client(), "client-3").start();
    }

    private static class Client implements Runnable {

        @Override
        public void run() {
            try {
                latch.await();
                process();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void process() throws IOException, InterruptedException {
            SocketChannel socket = SocketChannel.open();
            socket.connect(new InetSocketAddress("127.0.0.1", PORT));
            socket.configureBlocking(true);
            for (int i = 0; i < 10; i++) {
                String dateStr = LocalDateTime.now().toString();
                ByteBuffer buff = ByteBuffer.wrap(dateStr.getBytes());
                socket.write(buff);
                Utils.sleep(1000);
            }
//            ByteBuffer b = ByteBuffer.allocate(1024);
//            socket.read(b);
//            System.out.println(Arrays.toString(b.array()));
        }

    }

    private static class Server implements Runnable {

        private final int BUFFER_SIZE = 1024;

        //nioSocket是通过缓冲流进行读写操作的，这里先初始化好读写的缓冲流！
        private final ByteBuffer read = ByteBuffer.allocate(BUFFER_SIZE);
        private final ByteBuffer write = ByteBuffer.allocate(BUFFER_SIZE);

        @Override
        public void run() {
            try {
                start();
                System.out.println("server stop");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void start() throws IOException, InterruptedException {
            //使用静态open方法，生成一个ServerSocketChannel对象
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置其为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定接收请求的端口
            serverSocketChannel.bind(new InetSocketAddress(PORT));

            //获取一个selector对象
            Selector selector = Selector.open();

            //注册selector，第二个参数设置了其操作类型
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            latch.countDown();
            //循环接收请求
            while (!Thread.currentThread().isInterrupted()) {
                // 如果参数是0或没有参数的话就一直阻塞直到接收到请求
                if (selector.select() != 0) {
                    //selectedKeys方法获取SelectionKey的集合
                    //SelectionKey保存了请求的channel和selector信息
                    Set<SelectionKey> keys = selector.selectedKeys();
                    System.out.println("keys.length is " + keys.size());
                    Iterator<SelectionKey> iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        //获取后移除这个已经处理的请求！
                        iterator.remove();
                        //如果该key所在的channel或者selector关闭了，这里就会返回true
                        if (key.isAcceptable()) {//如果是接收请求操作
                            accept(key);
                        } else if (key.isReadable()) {//如果是读取操作
                            read(key);
                        } else if (key.isWritable()) {//如果是写操作
                            write(key);
                        }
                    }
                } else {
                    Utils.sleep(1000);
                }
            }
            serverSocketChannel.close();
        }

        private void accept(SelectionKey key) throws IOException {
            //这里的socket还没有注册客户端的channel，所以channel方法是获取ServerSocketChannel的
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            //而ServerSocketChannel的accept方法才是获取连接的channel的！
            SocketChannel socketChannel = serverSocketChannel.accept();
            //获取selector用的就是selector()方法
            Selector selector = key.selector();
            //也给其设置非阻塞模式
            socketChannel.configureBlocking(false);
            //注册服务器端的socket！本地分拣员能为客户端的channel服务了！
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("connect successfully");
        }

        private void write(SelectionKey key) throws IOException {
            write.flip();

            // selector已经注册了客户端的channel
            // channel（）方法获取到的是发送请求的SocketChannel对象
            SocketChannel channel = (SocketChannel) key.channel();
            channel.write(write);
//            channel.register(key.selector(), SelectionKey.OP_READ);
        }

        private void read(SelectionKey key) throws IOException {
            read.clear();

            SocketChannel channel = (SocketChannel) key.channel();
            int num;
            if ((num = channel.read(read)) == -1) {
                System.out.println("未读到信息");
            } else {
//                channel.register(key.selector(), SelectionKey.OP_WRITE);
                String getStr = new String(read.array(), 0, num);
                System.out.println(getStr);
            }
        }

    }

}
