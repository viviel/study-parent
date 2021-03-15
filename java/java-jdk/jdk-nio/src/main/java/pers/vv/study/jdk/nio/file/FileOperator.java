package pers.vv.study.jdk.nio.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author guoshixiong
 */
public class FileOperator {

    public static void main(String[] args) {
        new FileOperator().write("good");
    }

    public void read() {
        try {
            doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doRead() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer);
    }

    public void write(String msg) {
        try {
            doWrite(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String msg) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/vv/Desktop/test.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(2);

        for (char c : msg.toCharArray()) {
            buffer.putChar(c);
        }
        buffer.flip();

        channel.write(buffer);
    }

}
