package io.amit.old.questions;

import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.function.LongConsumer;

public class Q10 {
    public static void sleep(int millsec) {
        try {
            Thread.sleep(millsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepSec(int sec) {
        sleep(sec * 1000);
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }


    public static void main(String[] args) {
        //this example will block producer to wait until queue is free.
        System.setProperty("reactor.bufferSize.small", "6");
        int maxBufferSize = 50;
        Flux<Integer> flux = Flux.create(fluxSink -> {
                    for (int i = 1; i <= 76 && !fluxSink.isCancelled(); i++) {
//                        System.out.println("downstream request :: "+fluxSink.requestedFromDownstream());
                        if(fluxSink.requestedFromDownstream() <= maxBufferSize && fluxSink.requestedFromDownstream() != 0) {
                            System.out.println("Thread with publisher "+Thread.currentThread().getName());
                            System.out.println("downstream request :: "+fluxSink.requestedFromDownstream());
                            fluxSink.next(i);
                            System.out.println("Pushed : "+i);
                            sleep(10);
                        } else {
//                            System.out.println("else :: "+i);
                            i = i-1;
                        }

                    }
                    fluxSink.complete();
                });

        flux
                .doOnRequest(num -> System.out.println("requestt ::::: "+num) )
                .limitRate(maxBufferSize, 25)
//                .publishOn(Schedulers.boundedElastic())
                .publishOn(Schedulers.newParallel("p-Thread", 3))
                .doOnNext(i -> {
                    sleep(1000);
                }).subscribe(subscriber());

        sleepSec(60);
    }

}
