package algorithms.problems.array;

/**
 * Created by GPrabhu on 2/28/2015.
 */
public class FindGreatestInAnArray {
    public static void main(String args[]) {
        int[] a = {6,7,8,9,10,1,2,3,4,5,6};
        System.out.println(printGreatest(a, 0, a.length - 1));


    }

    private static int printGreatest(int[] a, int l, int h) {
        if(l==h){
            return a[l];
        }
        if(l+1==h&&(a[l]>a[h])){
            return a[l];
        }
        if(l+1==h&&(a[l]<a[h])){
            return a[h];
        }
        int m = (l + h) / 2;
        if (a[m] >= a[m - 1] && a[m] > a[m + 1]) {
            return a[m];
        }
        if ((m == 0 || a[m] > a[m - 1]) && a[m] < a[m + 1]) {
            return printGreatest(a, m + 1, h);
        }
        return printGreatest(a, l, m - 1);
    }

}
