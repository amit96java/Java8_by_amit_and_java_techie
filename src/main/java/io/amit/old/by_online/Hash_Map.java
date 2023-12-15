package io.amit.old.by_online;

import java.util.HashMap;
import java.util.Map;

public class Hash_Map {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
//        map.put(1,"C");

        map.values().stream().peek(System.out::print).forEach(System.out::print);

        map.keySet().stream().peek(System.out::print).forEach(System.out::print);
    }
}
