package algorithms.problems.dynamicprograming;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GPrabhu on 3/15/2015.
 */
public class LongestCommonSubsequance {
    public static void main(String[] args) {

        Queue queue = new LinkedList<>();
        //queue.offer()
        printLCA("abcbdab", "bdcaba");
    }

    private static void printLCA(String name1, String name2) {
        int[][] dpTable = new int[name1.length() + 1][name2.length() + 1];
        for (int i = 1; i <= name1.length(); i++) {
            for (int j = 1; j <= name2.length(); j++) {
              if (name1.charAt(i-1) == name2.charAt(j-1)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1]+1;
                } else {
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
                }
            }
        }
        System.out.println(dpTable[name1.length()][name2.length()]);
    }
}
