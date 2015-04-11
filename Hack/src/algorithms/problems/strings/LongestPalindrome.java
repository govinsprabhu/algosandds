package algorithms.problems.strings;

/**
 * Created by GPrabhu on 3/12/2015.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String sample = "WhatIsThereAerehTsIamIssImaI";
        printLargestPalindrome(sample);
    }

    private static void printLargestPalindrome(String sample) {
        int max = -1;
        int startIndex=-1;
        for (int i = 1; i < sample.length()-1; i++) {
            int small = i - 1;
            int large = i;
            while (small >= 0 && large < sample.length() && sample.charAt(small)==sample.charAt(large) ) {
                if ( large - small + 1 > max) {
                    max = large - small + 1;
                    startIndex=small;
                }
                large++;
                small--;
            }
            small = i - 1;
            large = i+1;
            while (sample.charAt(small)==sample.charAt(large) &&small >= 0 && large < sample.length()) {
                if (large - small + 1 > max) {
                    max = large - small + 1;
                    startIndex=small;
                }
                large++;
                small--;
            }
        }
        if(startIndex==-1){
            System.out.println("no palindrome found for String : "+sample);
            return;
        }

        System.out.println(sample.substring(startIndex,(startIndex+max)));
    }
}
