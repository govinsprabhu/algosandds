package algorithms.problems.heap;

import algorithms.problems.heap.payload.HeapObject;

/**
 * Created by GPrabhu on 3/4/2015.
 */
public class MergeKSortedArray {
    public static void main(String[] args) {
        int[][] a = {{1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10},
                {0, 11, 41, 42,43}};
        int[] sorted = getSortedArray(a, 3);
        for (int i = 0; i < (a.length) * 5; i++) {
            System.out.println(sorted[i]);
        }
        char[] string={'a','b','c'};
        String newString=string.toString();
        newString.charAt(1);
        //System.out.println(newString);
    }

    private static int[] getSortedArray(int[][] a, int k) {
        HeapObject[] heapObjects = new HeapObject[3];
        heapObjects[0] = new HeapObject();
        heapObjects[1] = new HeapObject();
        heapObjects[2] = new HeapObject();
        //HeapObject[] heapObjects=
        for (int i = 0; i < k; i++) {
            heapObjects[i].data = a[i][0];
            heapObjects[i].i = i;
            heapObjects[i].j = 0;
        }


        Integer.min(5,6);

        buildMinHeap(heapObjects, 3);
        int[] temp = new int[(a[0].length) * 3];
        for (int m = 0; m < (a[0].length) * 3; m++) {
            HeapObject root = heapObjects[0];
            temp[m] = root.data;
            if (root.j < a[0].length-1) {
                heapObjects[0].data = a[root.i][root.j + 1];
                root.j += 1;

            } else {
                root.data = Integer.MAX_VALUE;
            }
            heapify(heapObjects, 0, k);
        }
        return temp;
    }

    private static void buildMinHeap(HeapObject[] heapObjects, int k) {
        for (int i = k / 2; i >= 0; i--) {
            heapify(heapObjects, i, k);
        }
    }

    private static void heapify(HeapObject[] heapObjects, int i, int k) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int large = i;
        if (left < k && heapObjects[left].data < heapObjects[i].data) {
            large = left;
        }
        if (right < k && heapObjects[right].data < heapObjects[large].data) {
            large = right;
        }
        if (large != i) {
            swap(heapObjects, i, large);
            heapify(heapObjects, large, k);
        }
    }

    private static void swap(HeapObject[] heapObjects, int i, int j) {
        HeapObject temp = heapObjects[i];
        heapObjects[i] = heapObjects[j];
        heapObjects[j] = temp;
    }
}
