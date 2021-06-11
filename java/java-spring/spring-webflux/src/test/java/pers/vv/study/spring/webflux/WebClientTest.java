package pers.vv.study.spring.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import pers.vv.study.common.Utils;
import reactor.core.publisher.Mono;

public class WebClientTest {

    @Test
    void test1() {
        System.out.println("step 1");
        Mono<String> mono = WebClient.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 8))
                .build()
                .get()
                .uri("http://jz.union-wifi.com:8003/room/getAllRooms")
                .retrieve()
                .bodyToMono(String.class);
        mono.subscribe(System.out::println);
        System.out.println("step 2");
        Utils.block();
    }
}
