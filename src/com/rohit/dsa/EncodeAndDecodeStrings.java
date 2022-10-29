package com.rohit.dsa;

import java.util.List;
import java.util.ArrayList;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("Hel#lo");
        strList.add("Rohit");
        String encodedStr = encode(strList);
        List<String> decodedList = decode(encodedStr);
        System.out.println("Before Encoding - " + strList);
        System.out.println("After Encoding - " + encodedStr); //5#Hello5#Rohit
        System.out.println("After Decoding - " + decodedList);
    }

    public static String encode(List<String> strList) {
        StringBuilder encodedStr = new StringBuilder();
        if (strList != null) {
            for (String s : strList) {
                encodedStr.append(s.length() + "#" + s);
            }
        }
        return encodedStr.toString();
    }

    public static List<String> decode(String encodedStr) {
        List<String> decodedStr = new ArrayList<>();
        int i = 0;
        while(i < encodedStr.length()) {
            int len = Integer.parseInt(encodedStr.substring(i, i+1)); // Get the length of the individual string
            decodedStr.add(encodedStr.substring(i+2, len+i+2)); // extract the word using the length fetched above
            i = len +i+2; // Increase i accordingly
        }
        return decodedStr;
    }
}
