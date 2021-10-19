package pers.vv.study.netty.http.example2;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import pers.vv.study.netty.http.example1.HelloWorldHttp1Handler;

import static io.netty.util.internal.ObjectUtil.checkPositiveOrZero;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    HttpServerInitializer() {
        this(16 * 1024);
    }

    HttpServerInitializer(int maxHttpContentLength) {
        checkPositiveOrZero(maxHttpContentLength, "maxHttpContentLength");
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HelloWorldHttp1Handler("vv"));
    }
}
