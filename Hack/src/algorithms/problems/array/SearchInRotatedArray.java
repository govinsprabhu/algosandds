package algorithms.problems.array;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class SearchInRotatedArray {


    public static void main(String args[]) {
        int[] a = {5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(searchInRotatedArray(a, 6, 0, a.length));

    }

    private static int searchInRotatedArray(int[] a, int k, int l, int h) {
        if (l > h)
            return -1;
        int m = (l + h) / 2;
        if (a[m] == k)
            return m;
        if (a[m] >= a[l]) {
            if (k > a[m]) {
                l = m + 1;
            } else if (k >= a[l]) {
                h = m - 1;
            } else {
                l = m + 1;
            }

        } else if (k < a[m]) {
            h = m - 1;
        } else if (a[m] < k) {
            l = m + 1;
        } else {
            h = m - 1;
        }
        return searchInRotatedArray(a, k, l, h);

    }
}
