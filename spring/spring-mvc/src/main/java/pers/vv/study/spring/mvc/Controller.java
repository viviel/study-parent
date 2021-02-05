package pers.vv.study.spring.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/date")
    public String date(LocalDateTime date) {
        return date.toString();
    }
}
