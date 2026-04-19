package io.amit.handson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        String str =  "fourhead";
        splitString(str);
    }

    public static void splitString(String str) {
        if(str.length() <= 1) {
            return;
        }
        int mid = str.length()/2;

        String left = str.substring(0, mid);
        String right = str.substring(mid, str.length());

        System.out.println(left+"::"+right);
        splitString(left);
        splitString(right);
    }



}




