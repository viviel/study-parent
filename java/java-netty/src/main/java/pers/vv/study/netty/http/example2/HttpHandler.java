package pers.vv.study.netty.http.example2;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;

public class HttpHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;

    /**
     * 路由
     * 对http，websocket单独处理
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }

    /**
     * 对http请求的处理
     */
    private void handleHttpRequest(ChannelHandlerContext ctx, final FullHttpRequest req) {
        if (req.uri().startsWith("/ws/join")) {//如果urL开头为/ws/join则升级为websocket
            WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                    getWebSocketLocation(req), null, true
            );
            handshaker = wsFactory.newHandshaker(req);
            if (handshaker != null) {
                handshaker.handshake(ctx.channel(), req);
            } else {
                WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
            }
        } else {
            HttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.INTERNAL_SERVER_ERROR);
            ctx.channel().writeAndFlush(resp).addListener(ChannelFutureListener.CLOSE);
        }
    }

    private String getWebSocketLocation(HttpRequest req) {
        String protocol = "ws://";
        if (false) {
            protocol = "wss://";
        }
        return protocol + req.headers().get(HttpHeaderNames.HOST) + req.uri();
    }

    /**
     * 对socket请求的处理
     */
    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
        } else if (frame instanceof PingWebSocketFrame) {
            ctx.write(new PongWebSocketFrame(frame.content().retain()));
        } else if (frame instanceof TextWebSocketFrame) {
            String json = ((TextWebSocketFrame) frame).text();
        }
    }
}
