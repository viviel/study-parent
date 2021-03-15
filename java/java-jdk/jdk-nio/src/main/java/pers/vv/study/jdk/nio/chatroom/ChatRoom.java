package pers.vv.study.jdk.nio.chatroom;

import pers.vv.study.common.Utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ChatRoom {

    private volatile boolean running = true;

    private final int BUFFER_SIZE = 1024;

    private final ByteBuffer read = ByteBuffer.allocate(BUFFER_SIZE);
    private final ByteBuffer write = ByteBuffer.allocate(BUFFER_SIZE);

    public static void main(String[] args) {
        try {
            new ChatRoom().start();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() throws ExecutionException, InterruptedException {
        Future<?> f = Utils.cachedThreadPool().submit(() -> {
            try {
                start0();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        f.get();
        System.out.println("stopped");
    }

    private void start0() throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8888));

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (running) {
            if (selector.select() != 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                System.out.println("keys.length is " + keys.size());
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        accept(key);
                    } else if (key.isReadable()) {
                        read(key);
                    } else if (key.isWritable()) {
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
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        Selector selector = key.selector();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("connect successfully");
    }

    private void write(SelectionKey key) throws IOException {
        write.flip();
        SocketChannel channel = (SocketChannel) key.channel();
        channel.write(write);
    }

    private void read(SelectionKey key) throws IOException {
        read.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        int num;
        if ((num = channel.read(read)) == -1) {
            System.out.println("未读到信息");
        } else {
            String getStr = new String(read.array(), 0, num);
            System.out.println(getStr);
        }
    }

    public void stop() {
        running = false;
    }

}
