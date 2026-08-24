package io.amit.old.questions;


public class Q9 {

    public static void main(String[] args) {
        String[] str = new String[]{"abcde", "hello", "apple", "kite", "padle"};
        for(String s: str) {
            System.out.println("has unique character : "+hasUniqueCharacter(s));
        }
    }

    private static boolean hasUniqueCharacter(String str) {
        char[] charArray = str.toCharArray();
        boolean[] charAscii = new boolean[256];
        for (int i = 0; i< str.length(); i++) {
            if(charAscii[charArray[i]]) {
                return false;
            }

            charAscii[charArray[i]] = true;
        }
        return true;
    }




}
