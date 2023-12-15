package io.amit.old.by_online.parallel_stream;

import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        long start = 0;
        long end = 0;
        start=System.currentTimeMillis();
        IntStream.range(0,100).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("plain stream took time "+(end-start));

        start=System.currentTimeMillis();
        IntStream.range(0,100).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("parallel stream took time "+(end-start));


        IntStream.range(0,10).forEach(x ->{
            System.out.println(" Thread: "+Thread.currentThread().getName()+" :"+x);
        });

        IntStream.range(0,10).parallel().forEach(x ->{
            System.out.println(" Thread: "+Thread.currentThread().getName()+" :"+x);
        });

    }
}
