package algorithms.problems.AlgorithmDesignAndAnalysis.HeapSort;

public class HeapSortGsp {
    private static int N;
    public static void main(String[] args) {
        int a[]={10,6,8,3,9,5,4,7};
        heapSort(a);
        for(int elements:a){
            System.out.println(elements);
        }
    }

    private static void heapSort(int[] array) {
        heapify(array);
        for(int i=N-1;i>=0;i--)
        {
            exchange(array, 0,i);
            N--;
            maxHeap(array,0);
        }

    }

    private static void exchange(int[] array, int i, int i1) {
        int t=array[i];
        array[i]=array[i1];
        array[i1]=t;
    }

    private static void heapify(int[] array) {
        N=array.length;
        for(int i= (array.length-1)/2;i>=0;i--){
            maxHeap(array,i);
        }
    }

    private static void maxHeap(int[] array, int i) {
        int key=array[i];
        int left=2*i+1;
        int right=2*i+2;
        int maxIndex=i;
        if(left<N&&array[i]>array[left]){
            maxIndex=left;
        }
        if( right<N &&array[maxIndex]>array[right] ){
            maxIndex=right;
        }
        if(maxIndex!=i){
            exchange(array,i,maxIndex);
            maxHeap(array, maxIndex);
        }
    }
}
