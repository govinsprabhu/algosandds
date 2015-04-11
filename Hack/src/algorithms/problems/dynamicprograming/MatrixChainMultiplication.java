package algorithms.problems.dynamicprograming;

/**
 * Created by GPrabhu on 3/15/2015.
 */
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        printOptimalMultiplications(p);
    }

    private static void printOptimalMultiplications(int[] p) {
        int[][] m = new int[p.length+1][p.length+1];
        for (int i = 1; i <= p.length; i++) {
            m[i][i] = 0;
        }
        for (int level = 2; level <= p.length; level++) {
            for (int i = 1; i < p.length - level+1 ; i++) {
                int j = i + level-1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = (m[i][k] + m[k+1][j]) + p[i-1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }
        System.out.println(m[1][p.length-1]);
    }

}
