package pers.vv.study.java.reactor.project;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTest {

    @Test
    void test1() {
        CompletableFuture<List<String>> ids = ifhIds();
        CompletableFuture<List<String>> result = ids.thenComposeAsync(l -> {
            Stream<CompletableFuture<String>> zip =
                    l.stream().map(i -> {
                        CompletableFuture<String> nameTask = ifhName(i);
                        CompletableFuture<Integer> statTask = ifhStat(i);
                        return nameTask.thenCombineAsync(statTask, (name, stat) -> "Name " + name + " has stats " + stat);
                    });
            List<CompletableFuture<String>> combinationList = zip.collect(Collectors.toList());
            CompletableFuture<String>[] combinationArray = combinationList.toArray(new CompletableFuture[combinationList.size()]);
            CompletableFuture<Void> allDone = CompletableFuture.allOf(combinationArray);
            return allDone.thenApply(v -> combinationList.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList()));
        });
        List<String> results = result.join();
        String[] s = {
                "Name NameJoe has stats 103",
                "Name NameBart has stats 104",
                "Name NameHenry has stats 105",
                "Name NameNicole has stats 106",
                "Name NameABSLAJNFOAJNFOANFANSF has stats 121"
        };
    }

    private CompletableFuture<List<String>> ifhIds() {
        return new CompletableFuture<>();
    }

    private CompletableFuture<String> ifhName(String id) {
        return new CompletableFuture<>();
    }

    private CompletableFuture<Integer> ifhStat(String id) {
        return new CompletableFuture<>();
    }

    @Test
    void test2() {
        Flux<String> ids = ifhrIds();
        Flux<String> combinations = ids.flatMap(id -> {
            Mono<String> nameTask = ifhrName(id);
            Mono<Integer> statTask = ifhrStat(id);
            return nameTask.zipWith(statTask, (name, stat) -> "Name " + name + " has stats " + stat);
        });
        Mono<List<String>> result = combinations.collectList();
        List<String> results = result.block();
        String[] s = {
                "Name NameJoe has stats 103",
                "Name NameBart has stats 104",
                "Name NameHenry has stats 105",
                "Name NameNicole has stats 106",
                "Name NameABSLAJNFOAJNFOANFANSF has stats 121"
        };
    }

    private Flux<String> ifhrIds() {
        return Flux.empty();
    }

    private Mono<String> ifhrName(String id) {
        return Mono.empty();
    }

    private Mono<Integer> ifhrStat(String id) {
        return Mono.empty();
    }
}
