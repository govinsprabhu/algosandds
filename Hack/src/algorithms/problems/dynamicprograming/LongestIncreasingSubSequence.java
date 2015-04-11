package algorithms.problems.dynamicprograming;

/**
 * Created by GPrabhu on 3/23/2015.
 */
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60};
        printLongestIncreasingSubSequence(a);
    }

    private static void printLongestIncreasingSubSequence(int[] a) {
        int[] count = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            count[i] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && count[i] < count[j] + 1) {
                    count[i] = count[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        System.out.println(max);
    }
}
