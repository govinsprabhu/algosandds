package algorithms.problems.array;

public class FindMaximumOnesInMatrix {

    public static void main(String args[]) {
        int[][] a = {{0, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 1}
        };
        System.out.println(printMaximumNum(a, 4, 4));
    }

    private static int printMaximumNum(int[][] a, int m, int n) {
        int i = 0;
        int j = 0;
        int MAX = 0;
        while (i < n && j < m) {
            if ((j == 0 || a[i][j - 1] == 0) && a[i][j] == 1) {
                if (m - j > MAX) {
                    MAX = m - j;
                }
                i++;

            } else if (j == m - 1 && a[i][j] == 0) {

                i++;
            } else if (a[i][j] == 0) {
                j++;
            } else if (a[i][j] == 1) {
                j--;
            }

        }
        return MAX;
    }

}
