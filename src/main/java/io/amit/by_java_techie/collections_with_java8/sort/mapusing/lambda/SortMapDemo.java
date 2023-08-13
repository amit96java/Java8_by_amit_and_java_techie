package io.amit.by_java_techie.collections_with_java8.sort.mapusing.lambda;

import java.util.*;

public class SortMapDemo {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("two",2);
        map.put("eight",8);
        map.put("four",4);
        map.put("ten",10);


        List<Map.Entry<String,Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Map.Entry<String,Integer> entry:entries){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
