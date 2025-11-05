package io.amit;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
       Thread t1 = new ReadPdf();
       Thread t2 = new ReadText();

       t1.start();
       t2.start();

        t1.join();
        t2.join();
       Thread.sleep(4000);


    }
}

class ReadPdf extends Thread{
    @Override
    public void run() {
        System.out.printf("Thread "+Thread.currentThread().getName()+" : "+"read pdf");
    }
}

class ReadText extends Thread {
    public void run() {
        System.out.printf("Thread "+Thread.currentThread().getName()+" : "+"read text");
    }
}


