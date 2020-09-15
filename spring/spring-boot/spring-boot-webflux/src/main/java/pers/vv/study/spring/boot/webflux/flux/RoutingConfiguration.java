package pers.vv.study.spring.boot.webflux.flux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        String prefix = "/api/flux/user";
        return route(GET(prefix + "/list").and(accept(MediaType.APPLICATION_JSON)), userHandler::list)
                .andRoute(GET(prefix + "/get/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::getById)
                .andRoute(POST(prefix + "/save").and(accept(MediaType.APPLICATION_JSON)), userHandler::save);
    }

}
