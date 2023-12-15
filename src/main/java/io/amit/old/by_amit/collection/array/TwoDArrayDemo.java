package io.amit.old.by_amit.collection.array;

import java.util.*;

public class TwoDArrayDemo <container extends Map<Integer, List<Integer>>>{

    public static void simpleExample() {
        int[][] arr = new int[10][20];
        arr[0][0] = 1;

        System.out.println("arr[0][0] = " + arr[0][0]);
    }

    public static void goodExample() {

        int rows = 4;
        int columns = 2;

        int[][] array = new int[rows][columns];

        ///////////////////////////

        System.out.println("a row count************ " + array.length);
        System.out.println("a column count********* " + array[0].length);
        /////////////////////////////

        array[0][0] = 2;
        array[0][1] = 8;
        array[1][0] = 5;
        array[1][1] = 12;
        array[2][0] = 12;
        array[2][1] = 16;
        array[3][0] = 0;
        array[3][1] = 1;


        rows = array.length;
        columns = array[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int data = array[i][j];
                add(i, data, map);
            }
        }
        //first created one map with row number as key and list of of row data as value.
        //ex: map = {0, [2,8]}
        System.out.println("map is "+map);
        //process map is similar to above map but value we have counted from min to max.
        //ex: processMap = {0, [2,3,4,5,6,7,8]}
        Map<Integer, List<Integer>> processMap = process(map);
        System.out.println("process map is "+processMap);
        //than we compare each row data with other data and find the row which values match with other row
        //than we add both row and save in a set
        //than map.size-set.size
        Integer uniqueBus = getUniqueData(processMap);
        System.out.println("uniqueBus is "+uniqueBus);
    }

    public static void add(Integer key, Integer num, Map<Integer, List<Integer>> map) {
        if (map.containsKey(key)) {
            List<Integer> list = map.get(key);
            list.add(num);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(num);
            map.put(key, list);
        }
    }

    public static Map<Integer, List<Integer>> process(Map<Integer, List<Integer>> map) {
        int a = -1;
        int b = -1;
        int diff = -1;
        int min = -1;
        Set<Integer> keys = map.keySet();

        for (int key : keys) {
            List<Integer> nums = new ArrayList<>();
            List<Integer> values = map.get(key);
            a = values.get(0);
            b = values.get(1);
            if (a > b) {
                min = b;
                diff = a - b;
                for (int i = 0; i <= diff; i++) {
                    nums.add(min + i);
                }
                map.put(key, nums);
            } else {
                min = a;
                diff = b - a;
                for (int i = 0; i <= diff; i++) {
                    nums.add(min + i);
                }
                map.put(key, nums);
            }

        }
        return map;

    }

    public static Integer getUniqueData(Map<Integer, List<Integer>> map) {
        Set<Integer> matchedSet = new HashSet<>();
        int nonunique = 0;
        Set<Integer> totalRoute = map.keySet();
        for (int route : map.keySet()) {
            List<Integer> path = map.get(route);
            for (int subRoute : totalRoute) {
                if (route != subRoute) {
                    List<Integer> subPath = map.get(subRoute);
                    if (path.stream().noneMatch(subPath::contains)) {
                        nonunique++;
                    } else {
                        matchedSet.add(route+subRoute);
                    }
                }
            }
        }
        return totalRoute.size()-matchedSet.size();

    }


    public static void main(String[] args) {
        goodExample();
    }
}
