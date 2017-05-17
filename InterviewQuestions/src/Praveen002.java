/**
 * Created by praveen on 10-05-2017.
 * Question: Given two string, decide if one is a permutation of the other
 * Constraints:
 *  1. Case sensitive ("God" is not same as "god")
 *  2. White spaces are significant
 *  3. (Applies to 2nd method) Letters are only ASCII
 */

import sun.plugin.javascript.navig.Array;

import java.util.*;

public class Praveen002 {

    String sort(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    /* Time - O(nlogn), for sorting, Space - O(n) */
    boolean isPermutation(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        return sort(str1).equals(sort(str2));
    }

    /* Time - O(n), Space - O(n) */
    boolean isPermutation2(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        int[] letterCount = new int[128]; //If ASCII
        char[] charArray = str1.toCharArray();
        for (char ch : charArray){
            letterCount[ch]++;
        }

        for (int i=0; i<str2.length(); i++){
            char ch = str2.charAt(i);
            letterCount[ch]--;
            if(letterCount[ch] < 0)
                return false;
        }
        return true;
    }

    void test(String s1, String s2){
        System.out.print("Method 1 - ");
        System.out.println("\"" + s1 + "\" and" + "\"" + s2 + "\"" + isPermutation(s1, s2));
        System.out.print("Method 2 - ");
        System.out.println("\"" + s1 + "\" and" + "\"" + s2 + "\"" + isPermutation2(s1, s2));
    }

    public void runTests(){
        String s1, s2;
        System.out.println("isPermutation");
        s1 = "taco";
        s2 = "coat";
        test(s1, s2);
        s1 = "test      ing";
        s2 = "t e s t i n g";
        test(s1, s2);
        s1 = "bring";
        s2 = "ngrib";
        test(s1, s2);
        s1 = "Hello";
        s2 = "ollhe";
        test(s1, s2);

    }
}
