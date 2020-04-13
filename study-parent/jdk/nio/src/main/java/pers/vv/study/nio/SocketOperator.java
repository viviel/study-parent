package pers.vv.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author guoshixiong
 */
public class SocketOperator {

    private final int BUFFER_SIZE = 1024;

    //nioSocket是通过缓流进行读写操作的，这里先初始化好读写的缓冲流！
    private ByteBuffer read = ByteBuffer.allocate(BUFFER_SIZE);
    private ByteBuffer write = ByteBuffer.allocate(BUFFER_SIZE);

    //这是接收到的字符串
    private String getStr;

    public static void main(String[] args) {
    }

    private void start() throws IOException, InterruptedException {
        //使用静态open方法，生成一个ServerSocketChannel对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置其为非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //获取有个selector对象
        Selector selector = Selector.open();

        //注册selector，第二个参数设置了其操作类型
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //绑定接受请求的端口
        serverSocketChannel.bind(new InetSocketAddress(8001));

        //循环接受请求
        while (true) {
            //等待三秒，如果没有请求就select方法返回0，运行else中的需要一部运行的代码
            // 如果参数是0或没有参数的话就一直阻塞直到接收到请求
            if (selector.select(3000) != 0) {
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
                    //如果是接收请求操作
                    if (key.isAcceptable()) {
                        accept(key);
                        //如果是写操作
                    } else if (key.isWritable()) {//
                        write(key);
                        //如果是读取操作
                    } else if (key.isReadable()) {
                        read(key);
                    }
                }
            } else {
                System.out.println();
                Thread.sleep(800);
            }
        }
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
        /*
        clear方法中的内容，准备写入

        capacity = 1024 初始化时给的大小就是1024
        limit = capacity
        position = 0
        mark = -1

        write.clear();
        write.put(getStr.getBytes());

        flip方法中的内容，准备读取

        capacity = 1024
        limit = getStr.getBytes()
        position = 0
        mark = -1
        */
        write.flip();

        // selector已经注册了客户端的channel
        // channel（）方法获取到的是发送请求的SocketChannel对象
        SocketChannel channel = (SocketChannel) key.channel();
        channel.configureBlocking(false);
        channel.write(write);

        Selector selector = key.selector();
        //更换下一步的操作类型
        channel.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        read.clear();

        SocketChannel channel = (SocketChannel) key.channel();
        channel.configureBlocking(false);
        int num;
        if ((num = channel.read(read)) == -1) {
            System.out.println("未读到信息");
        } else {
            Selector selector = key.selector();
            channel.register(selector, SelectionKey.OP_WRITE);
            getStr = new String(read.array(), 0, num);
        }
    }

}
