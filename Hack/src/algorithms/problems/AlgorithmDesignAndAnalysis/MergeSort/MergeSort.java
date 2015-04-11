package algorithms.problems.AlgorithmDesignAndAnalysis.MergeSort;

/**
 * Created by GPrabhu on 10/22/2014.
 */
public class MergeSort {
    static int a[] = {8, 3, 5, 2, 7, 3};

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        mergeSort.runDivideArray(0, 5);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private int[] runDivideArray(int i, int j) {
        int m = (i + j) / 2;
        int d[] = new int[10];
        if (m != 0) {
            int b[] = runDivideArray(i, m);
            int c[] = runDivideArray(m + 1, j);
            d = sortArray(i, m, j, b, c);
        }
        return d;
    }

    private int[] sortArray(int i, int m, int j, int b[], int c[]) {
        int d[] = new int[10];
        for (int k = i; k <= m; k++) {
            if (b[i] <= c[j]) {
                d[k] = b[i];
                i++;
            } else {
                d[k] = c[j];
                j++;
            }
        }
        return d;

    }
}
