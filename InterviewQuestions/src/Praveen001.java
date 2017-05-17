/**
 * Created by praveen on 10-05-2017.
 * Question: Determine if a string has all unique characters
 * Constraints: Only ASCII letters
 */


public class Praveen001 {

    /* Time - O(n), Space - O(128) i.e., constant */
    boolean hasUniqueChars(String str){
        if (str.length() > 128)
            return false;
        if (str.length() == 0 )
            return true;

        boolean[] charSet = new boolean[128];

        for (int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if(charSet[val]){
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    public void runTests(){
        System.out.println("hasUniqueChars");
        String s = "abfdrjh";
        System.out.println(s + " " + hasUniqueChars(s));
        s = "Praveen";
        System.out.println(s + " " + hasUniqueChars(s));
        s = "AaBbCcDdHWwh";
        System.out.println(s + " " + hasUniqueChars(s));
        s = "asdfghjkls";
        System.out.println(s + " " + hasUniqueChars(s));
        s = "";
        System.out.println(s + " " + hasUniqueChars(s));
        s = "UNOVATE";
        System.out.println(s + " " + hasUniqueChars(s));
        System.out.println();

    }

}
