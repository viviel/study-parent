package pers.vv.study.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test")
public class Controller {
    
    @GetMapping("/get")
    public String get(LocalDateTime time) {
        return time.toString();
    }
    
}
