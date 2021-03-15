package pers.vv.study.spring.boot.webflux;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<Integer, User> map = new HashMap<>(10);

    @PostConstruct
    public void init() {
        map.put(1, new User(1, "admin"));
        map.put(2, new User(2, "admin2"));
        map.put(3, new User(3, "admin3"));
    }

    public Mono<User> getById(Integer id) {
        return Mono.justOrEmpty(map.get(id));
    }

    public Flux<User> list() {
        return Flux.fromIterable(map.values());
    }

    public void save(Mono<User> mono) {
        User user = mono.block();
        map.put(user.getId(), user);
    }

}
