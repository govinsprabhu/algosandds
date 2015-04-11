package algorithms.problems.dynamicprograming;

/**
 * Created by GPrabhu on 3/15/2015.
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] value = {10, 40, 30, 50};
        int[] weight = {5, 4, 6, 3};
        int w = 10;
        printMaximumValueBelowGivenWeight(value, weight, w);
    }

    private static void printMaximumValueBelowGivenWeight(int[] value, int[] weight, int maxWeight) {
        int[][] k = new int[value.length + 1][maxWeight + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                if (weight[i - 1] <= w) {
                    k[i][w] = Math.max(value[i - 1] + k[i - 1][w - weight[i - 1]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i][w - 1];
                }
            }
        }

        System.out.println(k[value.length][maxWeight]);
    }
}
