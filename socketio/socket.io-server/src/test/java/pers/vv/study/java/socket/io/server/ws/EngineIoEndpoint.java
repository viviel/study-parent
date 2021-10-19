package pers.vv.study.java.socket.io.server.ws;

import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoWebSocket;
import io.socket.parseqs.ParseQS;
import pers.vv.study.java.socket.io.server.EngineIOTest;

import javax.websocket.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class EngineIoEndpoint extends Endpoint {

    private Session mSession;
    private Map<String, String> mQuery;
    private EngineIoWebSocket mEngineIoWebSocket;

    private final EngineIoServer engineIOServer = EngineIOTest.ENGINE_IO_SERVER; // The engine.io server instance

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        mSession = session;
        mQuery = ParseQS.decode(session.getQueryString());

        mEngineIoWebSocket = new EngineIoWebSocketImpl();

        /*
         * These cannot be converted to lambda because of runtime type inference
         * by server.
         */
        mSession.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                mEngineIoWebSocket.emit("message", message);
            }
        });
        mSession.addMessageHandler(new MessageHandler.Whole<byte[]>() {
            @Override
            public void onMessage(byte[] message) {
                mEngineIoWebSocket.emit("message", (Object) message);
            }
        });

        engineIOServer.handleWebSocket(mEngineIoWebSocket);
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        super.onClose(session, closeReason);

        mEngineIoWebSocket.emit("close");
        mSession = null;
    }

    @Override
    public void onError(Session session, Throwable thr) {
        super.onError(session, thr);

        mEngineIoWebSocket.emit("error", "unknown error", thr.getMessage());
    }

    private class EngineIoWebSocketImpl extends EngineIoWebSocket {

        private final RemoteEndpoint.Basic mBasic;

        EngineIoWebSocketImpl() {
            mBasic = mSession.getBasicRemote();
        }

        @Override
        public Map<String, String> getQuery() {
            return mQuery;
        }

        @Override
        public Map<String, List<String>> getConnectionHeaders() {
            return Collections.emptyMap();
        }

        @Override
        public void write(String message) throws IOException {
            mBasic.sendText(message);
        }

        @Override
        public void write(byte[] message) throws IOException {
            mBasic.sendBinary(ByteBuffer.wrap(message));
        }

        @Override
        public void close() {
            try {
                mSession.close();
            } catch (IOException ignore) {
            }
        }
    }
}