package pers.vv.study.spring.boot.webflux.flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pers.vv.study.spring.boot.webflux.User;
import pers.vv.study.spring.boot.webflux.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private final UserService userService;

    @Autowired
    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    @NonNull
    public Mono<ServerResponse> list(ServerRequest serverRequest) {
        Flux<User> allUser = userService.list();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allUser, User.class);
    }

    @NonNull
    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        Mono<User> user = userService.getById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(user, User.class);
    }

    @NonNull
    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<User> user = serverRequest.bodyToMono(User.class);
        userService.save(user);
        return ServerResponse.ok().build();
    }

}