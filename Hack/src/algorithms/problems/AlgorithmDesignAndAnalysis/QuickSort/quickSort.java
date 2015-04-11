package algorithms.problems.AlgorithmDesignAndAnalysis.QuickSort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by GPrabhu on 11/2/2014.
 */
class QuickSortAlgorithm {
    static long comparison = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader("QuickSort.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n =10000;
        int[] A = new int[n];
        String str = bfr.readLine();
        int i = 0;
        while (str != null) {
            A[i] = Integer.parseInt(str);
            i++;
            str = bfr.readLine();
        }

        quickSort(A, 0, A.length - 1);

        System.out.println(comparison);

    }

    private static int[] quickSort(int[] a, int l, int r) {
        if (l < r) {
            add(r - l);
            int p = Partition(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
        return a;
    }

    private static void add(int i) {
        comparison+=i;

    }

    private static int Partition(int[] a, int l, int r) {


        int p = a[l];
        int i = l + 1;

        for (int j = l + 1; j <= r; j++) {
            if (a[j] < p) {
                Swap(a, j, i);
                i++;
            }
        }
        Swap(a, l, i - 1);
        return (i - 1);
    }


    private static void Swap(int[] a, int i, int j) {

        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private int median(int[] a, int l, int r) {
        int m = (l + r) / 2;
        if (m > l && m < r || m < l && m > r)
            return m;
        else if (l > m && l < r || l < m && l > r)
            return l;
        else
            return r;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }


}
