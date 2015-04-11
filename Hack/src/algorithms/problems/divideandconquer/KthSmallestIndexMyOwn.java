package algorithms.problems.divideandconquer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GPrabhu on 3/19/2015.
 */
public class KthSmallestIndexMyOwn {
    public static void main(String args[]) {
        int[] a = {3,1,2,4,5,6,7,8};
        System.out.println("th smallest element is " + smallest(a,2, 0, a.length - 1));

        
    }

    private static int smallest(int[] a, int k, int l, int h) {

        if (l<h) {
            int pivot = partition(a, l, h);
            if (pivot == k - 1)
                return a[pivot];
            if (pivot > k - 1)
                return smallest(a, k, l, pivot - 1);
            return smallest(a, k, pivot + 1, h);
        }

        return -1;
    }

    private static int randomPartition(int[] a, int l, int h) {
        int index = (int) (Math.random() * (h - l+1));
        swap(index, h, a);
        return partition(a, l, h);
    }

    private static int partition(int[] a, int l, int h) {
        int i = l;
        int key = a[h];
        for (int j = l; j <= h - 1; j++) {
            if (a[j] <= key) {
                swap(i, j, a);
                i++;
            }
        }
        swap(i, h, a);
        return i;
    }

    private static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
