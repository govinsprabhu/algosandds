package algorithms.problems.array;

import datastructure.queue.ListQueue;


public class MaximumInKWindow {
    public static void main(String args[]) {
        int[] array = {5, 4, 3, 7, 3, 5, 3, 6, 4, 1};
        printKWindowMax(array, 3);
    }

    private static void printKWindowMax(int a[], int k) {
        ListQueue queue = new ListQueue();
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty() && a[i] > a[((int) queue.back())]) {
                System.out.println("Pop Back " + a[((int) queue.pop_back())]);
            }
            queue.push_back(i);
        }
        for (int i = k; i < a.length; i++) {
            System.out.println(a[((int) queue.getFront())]);
            while (!queue.isEmpty() && queue.getFront() <= i - k) {
                System.out.println("Popfront  " + a[((int) queue.pop_front())]);
            }
            while (!queue.isEmpty() && a[i] > a[((int) queue.back())]) {
                System.out.println("Pop back " + a[((int) queue.pop_back())]);
            }
            queue.push_back(i);
        }
    }
}
