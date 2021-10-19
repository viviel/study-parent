package pers.vv.study.netty.http.custom;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class SimpleChannelHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof FullHttpRequest) {
            readFullHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            readWebSocketFrame(ctx, (WebSocketFrame) msg);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    private void readFullHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (needUpgradeWS(req)) {
            upgradeWS(ctx, req);
        } else {
            handleHttpRequest(ctx, req);
        }
    }

    private boolean needUpgradeWS(FullHttpRequest req) {
        HttpHeaders headers = req.headers();
        String upgrade = headers.get("Upgrade");
        return Objects.equals(upgrade, "websocket");
    }

    private void upgradeWS(ChannelHandlerContext ctx, FullHttpRequest req) {
        final Channel channel = ctx.channel();
        WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory(
                getWebSocketLocation(req), null, true
        );
        WebSocketServerHandshaker handShaker = factory.newHandshaker(req);
        if (handShaker != null) {
            handShaker.handshake(channel, req);
        } else {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        }
    }

    private String getWebSocketLocation(HttpRequest req) {
        String protocol = "ws://";
        if (false) {
            protocol = "wss://";
        }
        return protocol + req.headers().get(HttpHeaderNames.HOST) + req.uri();
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (HttpUtil.is100ContinueExpected(req)) {
            ctx.write(new DefaultFullHttpResponse(HTTP_1_1, CONTINUE, ctx.alloc().buffer(0)));
        }
        String msg = "hello test";
        ByteBuf content = ctx.alloc().buffer();
        content.writeBytes(msg.getBytes(StandardCharsets.UTF_8));

        FullHttpResponse resp = new DefaultFullHttpResponse(HTTP_1_1, OK, content);
        HttpHeaders headers = resp.headers();
        headers.set(CONTENT_TYPE, "text/plain; charset=UTF-8");
        headers.setInt(CONTENT_LENGTH, resp.content().readableBytes());

        if (!HttpUtil.isKeepAlive(req)) {
            ctx.write(resp).addListener(ChannelFutureListener.CLOSE);
        } else {
            headers.set(CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            ctx.write(resp);
        }
    }

    private void readWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        if (frame instanceof CloseWebSocketFrame) {
            ctx.channel().writeAndFlush(frame).addListener(ChannelFutureListener.CLOSE);
        } else if (frame instanceof PingWebSocketFrame) {
            ctx.write(new PongWebSocketFrame(frame.content().retain()));
        } else if (frame instanceof TextWebSocketFrame) {
            String msg = ((TextWebSocketFrame) frame).text();
            System.out.println(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
