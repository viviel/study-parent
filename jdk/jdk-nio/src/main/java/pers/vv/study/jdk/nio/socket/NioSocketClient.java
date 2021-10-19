package pers.vv.study.jdk.nio.socket;

import pers.vv.study.common.Utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;

public class NioSocketClient implements Runnable {

    public static void main(String[] args) throws IOException, InterruptedException {
        NioSocketClient o = new NioSocketClient();
        o.process();
    }

    @Override
    public void run() {
        try {
            process();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void process() throws IOException, InterruptedException {
        SocketChannel socket = SocketChannel.open();
        socket.connect(new InetSocketAddress("127.0.0.1", NioSocketServer.PORT));
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
        socket.close();
    }
}
