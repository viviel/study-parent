package pers.vv.study.netty.http.example1;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.handler.codec.http2.CleartextHttp2ServerUpgradeHandler;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2ServerUpgradeCodec;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;

import static io.netty.util.internal.ObjectUtil.checkPositiveOrZero;

public class Http2ServerInitializer extends ChannelInitializer<SocketChannel> {

    private static final HttpServerUpgradeHandler.UpgradeCodecFactory upgradeCodecFactory = protocol -> {
        if (AsciiString.contentEquals(Http2CodecUtil.HTTP_UPGRADE_PROTOCOL_NAME, protocol)) {
            return new Http2ServerUpgradeCodec(new HelloWorldHttp2HandlerBuilder().build());
        } else {
            return null;
        }
    };

    private final int maxHttpContentLength;

    public Http2ServerInitializer() {
        this(16 * 1024);
    }

    Http2ServerInitializer(int maxHttpContentLength) {
        checkPositiveOrZero(maxHttpContentLength, "maxHttpContentLength");
        this.maxHttpContentLength = maxHttpContentLength;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        configureClearText(ch);
    }

    /**
     * Configure the pipeline for a cleartext upgrade from HTTP to HTTP/2.0
     */
    private void configureClearText(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
        p.addLast(getCleartextHttp2ServerUpgradeHandler());
        p.addLast(getSimpleChannelInboundHandler());
        p.addLast(new UserEventLogger());
    }

    private CleartextHttp2ServerUpgradeHandler getCleartextHttp2ServerUpgradeHandler() {
        HttpServerCodec sourceCodec = new HttpServerCodec();
        HttpServerUpgradeHandler upgradeHandler = new HttpServerUpgradeHandler(sourceCodec, upgradeCodecFactory);
        return new CleartextHttp2ServerUpgradeHandler(
                sourceCodec, upgradeHandler, new HelloWorldHttp2HandlerBuilder().build()
        );
    }

    private SimpleChannelInboundHandler<HttpMessage> getSimpleChannelInboundHandler() {
        String resp = "hello-test";
        return new SimpleChannelInboundHandler<HttpMessage>() {
            @Override
            protected void channelRead0(ChannelHandlerContext ctx, HttpMessage msg) throws Exception {
                // If this handler is hit then no upgrade has been attempted and the client is just talking HTTP.
                System.err.println("Directly talking: " + msg.protocolVersion() + " (no upgrade was attempted)");
                ChannelPipeline pipeline = ctx.pipeline();
                ChannelHandlerContext thisCtx = pipeline.context(this);
                pipeline.addAfter(thisCtx.name(), null, new HelloWorldHttp1Handler(resp));
                pipeline.replace(this, null, new HttpObjectAggregator(maxHttpContentLength));
                ctx.fireChannelRead(ReferenceCountUtil.retain(msg));
            }
        };
    }

    /**
     * Class that logs any User Events triggered on this channel.
     */
    private static class UserEventLogger extends ChannelInboundHandlerAdapter {
        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
            System.out.println("User Event Triggered: " + evt);
            ctx.fireUserEventTriggered(evt);
        }
    }
}