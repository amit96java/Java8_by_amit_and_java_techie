package io.amit.old.by_online.consumer_predicate_supplier.predicate;

import java.util.function.Predicate;

public class PredicateDemoByLambdaExpression {

    public static void main(String[] args) {
//        Predicate<Integer> predicate = (t) -> {
//            if (t % 2 == 0) return true;
//            else return false;
//        };

        System.out.println(testEvenOrOdd(7));
    }

    public static boolean testEvenOrOdd(Integer num){
        Predicate<Integer> predicate = (t) -> {
            if (t % 2 == 0) return true;
            else return false;
        };
        return predicate.test(num);
    }

//    public static boolean testGreater(Integer num1,Integer num2){
//        Predicate<Integer> predicate = (t1,t2) -> {
//            if(t1.compareTo((t2)) return true;
//            else return false;
//        };
//    }
}
