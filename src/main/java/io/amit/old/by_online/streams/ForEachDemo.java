package io.amit.old.by_online.streams;

import java.util.HashMap;
import java.util.Map;

public class ForEachDemo {
    public static void main(String[] args) {
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(1,"a");
        map2.put(2,"b");
        map2.put(3,"c");
        map2.put(4,"d");

        map2.forEach((key,value)->{
            System.out.println("key: "+key+" value: "+value);
        });

        map2.entrySet().stream().forEach(obj -> System.out.println(obj));
    }
}
