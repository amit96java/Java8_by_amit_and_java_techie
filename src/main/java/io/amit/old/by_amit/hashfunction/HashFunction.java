package io.amit.old.by_amit.hashfunction;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class HashFunction {
//avlaival algo are MD2 , MD5 , SHA-1 , SHA-224, SHA-256 , SHA-384 , SHA-512
    public static String getHash(byte[] inputBytes, String algorithm) {
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestBytes);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return hashValue;
    }

    /**
     * ALSO WE CAN GENERATE HASH VALUE OF IMAGE FILE LIKE (.PNG) USING MD5
     * @param args
     */
    public static void main(String[] args) {
        String someString = "This is my pc";
        System.out.println("value is "+getHash(someString.getBytes(), "SHA-1"));
    }
}
