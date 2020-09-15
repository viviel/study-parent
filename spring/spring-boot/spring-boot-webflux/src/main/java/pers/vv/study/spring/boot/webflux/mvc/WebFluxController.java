package pers.vv.study.spring.boot.webflux.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.vv.study.spring.boot.webflux.User;
import pers.vv.study.spring.boot.webflux.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/mvc/user")
public class WebFluxController {

    private final UserService userService;

    @Autowired
    public WebFluxController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public Flux<User> getAllUser() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/save")
    public Mono<ResponseEntity<String>> save(@RequestBody User user) {
        userService.save(Mono.just(user));
        return Mono.just(new ResponseEntity<>("添加成功", HttpStatus.CREATED));
    }

}
