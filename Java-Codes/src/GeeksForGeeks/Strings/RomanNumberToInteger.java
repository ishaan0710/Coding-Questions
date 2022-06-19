package GeeksForGeeks.Strings;

//https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1

import java.util.*;

/**
 * Given a string in roman no format (s)  your task is to convert it to an integer . Various symbols and their values are given below.
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 */

class RomanNumberToInteger {

    Map<Character, Integer> romanValue = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToDecimal(String str) {
        int number = 0;
        for (int i=0; i<str.length() - 1; i++) {
            if (romanValue.get(str.charAt(i)) >= romanValue.get(str.charAt(i+1))) {
                number += romanValue.get(str.charAt(i));
            } else {
                number -= romanValue.get(str.charAt(i));
            }
        }
        number += romanValue.get(str.charAt(str.length()-1));
        return number;
    }

    public static void main(String[] args) {
        RomanNumberToInteger romanNumberToInteger = new RomanNumberToInteger();
        System.out.println(romanNumberToInteger.romanToDecimal("IX"));
    }
}
