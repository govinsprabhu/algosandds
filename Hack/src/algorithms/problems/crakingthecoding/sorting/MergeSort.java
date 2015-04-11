package algorithms.problems.crakingthecoding.sorting;

/**
 * Created by GPrabhu on 2/28/2015.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a={5,3,7,2,9,6,1,4};
        mergeSort(a,0,7);
        for(int i : a){
            System.out.println(a[i]);
        }

}

    private static void mergeSort(int[] a, int l, int h) {
        int m=(l+h)/2;
        mergeSort(a,l,m-1);
        mergeSort(a,m,l);
        merge(a,l,m,h);
    }

    private static void merge(int[] a, int l, int m, int h) {
        int i=l;
        int j=m;
        while (i<m&&j<=h){
            if(a[i]<a[j]){
                i++;
            }
            else if(a[j]<=a[i]){
                a[++i]=a[j++];
            }

        }
       while (j<=h){
            a[j]=a[i];
       }
    }


}
