package algorithms.problems.crakingthecoding.recursion;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by GPrabhu on 2/15/2015.
 */
public class Permutation {
    public static void main(String[] args) {
        System.out.println(getPerms("abc"));
    }
    public static ArrayList<String> getPerms(String s) {
         ArrayList<String> permutations = new ArrayList<String>();
         if (s == null) { // error case
             return null;
             } else if (s.length() == 0) { // base case
             permutations.add("");
             return permutations;
             }
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(1,2);
         char first = s.charAt(0); // get the first character
         String remainder = s.substring(1); // remove the first character
         ArrayList<String> words = getPerms(remainder);
         for (String word : words) {
             for (int j = 0; j <= word.length(); j++) {
                permutations.add(insertCharAt(word, first, j));
                 }
            }
         return permutations;
         }

             public static String insertCharAt(String word, char c, int i) {
         String start = word.substring(0, i);
         String end = word.substring(i);
         return start + c + end;
         }
}

