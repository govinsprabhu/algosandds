package algorithms.problems.array;

/**
 * Created by GPrabhu on 3/24/2015.
 */
public class KthSmallestElementAfterMerginTwoSortedArray {
    public static void main(String[] args) {
        int[] a1= {1,3,7,11,24};
        int[] a2= {2,4,6,12,13};
        System.out.println(printKthSmallest(a1,a2,0,a1.length-1,4));

    }

    private static int printKthSmallest(int[] a1, int[] a2, int l, int h, int k) {
        if(l> h){
            return printKthSmallest(a2,a1,0,a1.length-1,k);
        }
        int i = l+k/2 -1;
        int j = k - i -2+l;
        if(a1[i] > a2[j] && (j == a1.length-1 || a1[i] <= a2[j] )){
            return a1[i];
        }
        if(a1[i] > a2[j] && j <= a1.length-1 && a1[i] > a2[j+1] ){
            printKthSmallest(a1,a2,l,i-1,k);
        }
        printKthSmallest(a1,a2,i,h,k);
        return -1;

    }
}
