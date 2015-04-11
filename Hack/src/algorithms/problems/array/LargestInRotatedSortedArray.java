package algorithms.problems.array;

/**
 * Created by GPrabhu on 3/17/2015.
 */
public class LargestInRotatedSortedArray {
    public static void main(String[] args) {
        int[] a= {3,3,3,3,3,3,3,0,3};
        System.out.println(printLargest(a,0,a.length-1));
    }

    private static int printLargest(int[] a, int l, int h) {
        if(l>h){
            return a[a.length-1];
        }
        /**with duplicates
         *
         */

        if(l == h){
            return a[l];
        }

        int m= l+(h-l)/2;
        if((m == h || a [m] > a[m+1])){
            return a[m];
        }
        if(a[m]< a[m-1] ){
            return a[m-1];
        }

        if((a[m] <= a[h]) &&( a[l] > a[m] ) ){
             return printLargest(a,l,m-1);

        }
        return printLargest(a,m+1,h);

    }
}
