package algorithms.problems.array;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class MaximumPathInTwoArray {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 7, 8,};
        int[] a2 = {2, 3, 7, 10, 12};
        MaximumPathInTwoArray[] maximumPathInTwoArrays = new MaximumPathInTwoArray[3];

        System.out.println(printMaximumPath(a1, a2));
    }

    private static int printMaximumPath(int[] a1, int[] a2) {

        int i = 0;
        int j = 0, sum1 = 0, sum2 = 0, result = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                sum1 += a1[i++];
            } else if (a1[i] > a2[j]) {
                sum2 += a2[j++];
            } else {
                result += Math.max(sum1, sum2);
                sum1 = sum2 = 0;
                while (i < a1.length && j < a2.length && a1[i] == a2[j]) {
                    result += a1[i];
                    i++;
                    j++;
                }
            }
        }

        while ( i<a1.length){
            sum1 += a1[i++];
        }

        while (j < a2.length) {
            sum2 += a2[j++];
        }
        result += Math.max(sum1, sum2);
        return result;
    }
}
