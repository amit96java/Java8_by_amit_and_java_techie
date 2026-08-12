package io.amit.old.questions;

/**
 * Question: 11)
 * print lucky string (delloite)
 *     divide the string until it is not devidable
 *     Example: fourhead
 *     four || head
 *     fo || ur || he || ad
 *
 */
public class Q11 {

    public static void main(String[] args) {
        String str =  "fourhead";
        splitString(str);
    }

    public static void splitString(String str) {
        // If length is odd or 1, stop
        if (str.length() <= 1 ) {
            return;
        }

        int mid = str.length() / 2;

        String left = str.substring(0, mid);
        String right = str.substring(mid);

        // Print current split
        System.out.println(left + " , " + right);

        // Recursively split further
        splitString(left);
        splitString(right);
    }



}




