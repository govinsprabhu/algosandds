package algorithms.problems.heap;

public class heap {
    public static  int n;
    public static void main(String args[]){
        int[] a={7,5,6,8,1,3,9};
        heapSort(a);
        System.out.println("output");
        for(int i=0; i<=a.length-1;i++){
            System.out.println(a[i]);
        }

    }
    public static void heapSort(int[] tree){

        buildHeap(tree);
 /*       for(int i=0; i<=tree.length-1;i++){
            System.out.println(tree[i]);
        }
 */       System.out.println("Max heap");
        for(int i=n;i>=0;i--){
            swap(i,0,tree);
            n--;
            System.out.println(tree[i]);
            heapify(0,tree);

        }
    }
    public static void swap(int i, int j, int[] a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private static void buildHeap(int[] tree){
        n=tree.length-1;
        for(int i=n/2;i>=0;i--){
            heapify(i,tree);
        }
    }

    private static void heapify(int i, int[] tree){
        int left=2*i;
        int right=2*i+1;
        int large=i;

        if(left<=n&&tree[i]<tree[left]){
            large=2*i;
        }
        if(right<=n&& tree[right]>tree[large]){
            large=2*i+1;
        }
        if(i!=large){
            swap(i,large,tree);
            heapify(large,tree);
        }
    }


}
