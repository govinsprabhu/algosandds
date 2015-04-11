package algorithms.problems.crakingthecoding.sorting.binarysearch;

import java.util.HashMap;

/**
 * Created by GPrabhu on 2/26/2015.
 */
public class MedianOfTwoSortedArray {
    public static void main(String args[]){
        int[] a1={1,5,7,10,13};
        int[] a2={11,15,23,30,45};
        HashMap<Integer,Boolean> isAlready=new HashMap<>();

        System.out.println("Median is "+getMedian(a1,a2,0,a1.length-1,a1.length));
    }

    private static int getMedian(int[] a1,int[] a2,int left,int right,int n){

        if(left>right){
            return getMedian(a2,a1,0,n-1,n);
        }
        int i,j;
        i=(left+right)/2;
        j=n-i-1;
        if(a1[i]>a2[j]&&(j==0||a1[i]>=a2[j+1])){
            if(i==0||(a2[j]>a1[i-1])){
                return (a1[i]+a2[j])/2;
            }
            return (a1[i]+a2[i-1])/2;
        }
        else if(a1[i]<a2[j]&&j!=n-1&&a1[i]<a2[j+1]){
            return getMedian(a1,a2,i+1,right,n);
        }
        else{
            return getMedian(a1,a2,left,i-1,n);
        }
    }

}
