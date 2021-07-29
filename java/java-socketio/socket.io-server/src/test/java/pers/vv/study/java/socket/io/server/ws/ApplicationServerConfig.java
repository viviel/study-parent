package pers.vv.study.java.socket.io.server.ws;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.HashSet;
import java.util.Set;

public final class ApplicationServerConfig implements ServerApplicationConfig {

    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> scanned) {
        ServerEndpointConfig endpointConfig = ServerEndpointConfig.Builder
                .create(EngineIoEndpoint.class, "/engine.io/")
                .build();
        HashSet<ServerEndpointConfig> result = new HashSet<>();
        result.add(endpointConfig);
        return result;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        return null;
    }
}
