package pers.vv.study.netty.http.custom;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import static io.netty.util.internal.ObjectUtil.checkPositiveOrZero;

public class SimpleChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final int maxContentLength;

    public SimpleChannelInitializer() {
        this(16 * 1024);
    }

    public SimpleChannelInitializer(int maxHttpContentLength) {
        checkPositiveOrZero(maxHttpContentLength, "maxHttpContentLength");
        this.maxContentLength = maxHttpContentLength;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(maxContentLength));
        pipeline.addLast(new SimpleChannelHandler());
    }
}
