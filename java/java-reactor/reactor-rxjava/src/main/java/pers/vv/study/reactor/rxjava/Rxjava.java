package pers.vv.study.reactor.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Rxjava {

    public static void main(String[] args) throws InterruptedException {
        Rxjava rxjava = new Rxjava();
        rxjava.helloWorld();
        rxjava.backgroundComputation();
    }

    private void helloWorld() {
        Flowable.just("Hello world").subscribe(System.out::println);
    }

    private void backgroundComputation() throws InterruptedException {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000); // <--- wait for the flow to finish
    }

}
