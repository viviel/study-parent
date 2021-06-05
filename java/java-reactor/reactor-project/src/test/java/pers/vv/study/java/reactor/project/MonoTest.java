package pers.vv.study.java.reactor.project;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    void test1() {
        Mono.just("vv").subscribe(System.out::println);
    }

    @Test
    void test2() {
        String r = Mono.just("vv").block();
    }

    @Test
    void test3() {
        Mono.just("hello world").flatMap(e -> Mono.usingWhen(
                Mono.just(e.split(" ")),
                r -> {
                    System.out.println("resourceClosure");
                    Utils.sleep(1000);
                    return Mono.just("i");
                },
                r -> {
                    System.out.println("asyncComplete");
                    return Mono.just("j");
                },
                (r, ex) -> {
                    System.out.println("asyncError");
                    return Mono.just("k");
                },
                r -> {
                    System.out.println("asyncCancel");
                    return Mono.just("l");
                }
        )).subscribe(x -> {
            System.out.println("done");
            System.out.println(x);
        });
    }
}
