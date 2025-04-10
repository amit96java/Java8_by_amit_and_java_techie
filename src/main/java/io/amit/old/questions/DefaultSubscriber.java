package io.amit.old.questions;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {
    private String name = "";

    public DefaultSubscriber(String name) {
        this.name = name+ " - ";
    }

    public DefaultSubscriber() {

    }


    @Override
    public void onSubscribe(Subscription subscription) {
        long maxValue = Long.MAX_VALUE;
        subscription.request(maxValue);
    }

    @Override
    public void onNext(Object o) {
        System.out.println("Thread "+Thread.currentThread().getName()+" "+name + "Receiveddd : "+ o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + "ERROR : "+ throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + ": Completed");
    }

}

