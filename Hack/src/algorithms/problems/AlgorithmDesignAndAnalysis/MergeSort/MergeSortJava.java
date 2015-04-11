package algorithms.problems.AlgorithmDesignAndAnalysis.MergeSort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MergeSortJava {
    static long value = 0;

    public static void main(String[] args) {
        BufferedReader reader = null;
        int[] array = new int[100000];
        try {
            reader = new BufferedReader(new FileReader("IntegerArray.txt"));
            String text = null;
            int i = 0;
            while ((text = reader.readLine()) != null) {
                array[i] = Integer.parseInt(text);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mergeSort(array, 0, array.length - 1);
        for (int a : array) {
            System.out.println(a);
        }

        int[] a = new int[12];
        if (a.length == 0) {
            System.out.println("yse");
        } else {
            System.out.println("no");
        }
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }

    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int aIndex = low;
        int bIndex = mid + 1;
        int index = 0;
        while (aIndex < mid + 1 && bIndex < high + 1) {
            if (array[aIndex] < array[bIndex]) {
                temp[index++] = array[aIndex++];
            } else {
                temp[index++] = array[bIndex++];
                value += mid - aIndex + 1;
            }
        }
        while (aIndex < mid + 1) {
            temp[index++] = array[aIndex++];
        }
        while (bIndex < high + 1) {
            temp[index++] = array[bIndex++];
        }
        index = 0;
        for (int i = low; i <= high; i++) {
            array[i] = temp[index++];
        }
    }

}
