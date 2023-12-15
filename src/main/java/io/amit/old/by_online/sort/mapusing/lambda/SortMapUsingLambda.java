package io.amit.old.by_online.sort.mapusing.lambda;

import java.util.*;

public class SortMapUsingLambda {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("two",2);
        map.put("eight",8);
        map.put("four",4);
        map.put("ten",10);


        List<Map.Entry<String,Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries,(o1,o2)->o1.getKey().compareTo(o2.getKey()));

        for(Map.Entry<String,Integer> entry:entries){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

}
