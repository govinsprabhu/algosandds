package algorithms.problems.divideandconquer;

/**
 * Created by GPrabhu on 2/25/2015.
 */
public class KthSmallestIndex {

    public static void main(String args[]) {
        int[] a = {8, 4, 2, 7, 9, 5, 1, 6};
        System.out.println("th smallest element is " + smallest(a,5, 0, a.length - 1));

    }

    private static int smallest(int[] a, int k, int l, int h) {

        if (k > 0 && k <= h - l + 1) {
            int pivot = partition(a, l, h);
            if (pivot - l == k - 1)
                return a[pivot];
            if (pivot - l > k - 1)
                return smallest(a, k, l, pivot - 1);
            return smallest(a, k - pivot + l -1, pivot + 1, h);
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
