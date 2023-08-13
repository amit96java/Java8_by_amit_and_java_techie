package io.amit.by_amit.converttobase64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Converter {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String par="my name is amit ";
        byte[] res = par.getBytes("UTF-8");

        // Displaying converted string after conversion
        // into UTF-16
        System.out.println("Result : ");

        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i]);
        }
        String imageStr = Base64.getEncoder().encodeToString(res);
        System.out.println("base 64 is : "+imageStr);
    }
}
