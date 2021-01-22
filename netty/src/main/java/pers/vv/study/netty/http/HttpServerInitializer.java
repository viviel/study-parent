package pers.vv.study.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerExpectContinueHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("loggingHandler", new LoggingHandler(LogLevel.INFO));
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
//        pipeline.addLast("httpServerExpectContinueHandler", new HttpServerExpectContinueHandler());
        pipeline.addLast("httpHandler", new HttpHandler());
    }
}
