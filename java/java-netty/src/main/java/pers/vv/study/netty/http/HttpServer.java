package pers.vv.study.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import pers.vv.study.netty.http.custom.SimpleChannelInitializer;

public final class HttpServer {

    private final int port;

    HttpServer(final int port) {
        this.port = port;
    }

    void run() throws Exception {
        // Configure the server.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
//                    .childHandler(new Http2ServerInitializer());
                    .childHandler(new SimpleChannelInitializer());
            Channel ch = b.bind(port).sync().channel();
            ch.closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
