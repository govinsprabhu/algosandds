package algorithms.problems.AlgorithmDesignAndAnalysis.medianUsingHashing;

/* Class HeapSort */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by GPrabhu on 11/30/2014.
 */

public class MedianUsingHashing {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Median.txt"));
        String line = null;
        ArrayList<Integer> number = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            number.add(Integer.parseInt(line));
        }
        PriorityQueue<Integer> highHeap = new PriorityQueue<>();
        PriorityQueue<Integer> lowHeap = new PriorityQueue<>();
        int sum=0;
        for (int a : number) {
            if (lowHeap.size() > 0) {
                if (a>(-lowHeap.peek())) {
                    highHeap.offer(a);

                } else {
                    lowHeap.offer(-a);
                }
            } else {
                lowHeap.offer(-a);
            }
            if (lowHeap.size() > highHeap.size() + 1) {
                highHeap.offer((-lowHeap.poll()));
            } else if (highHeap.size() > lowHeap.size()) {
                lowHeap.offer(-highHeap.poll());
            }
            sum+=-lowHeap.peek();
        }
        System.out.println("MEDIAN :"+sum%10000);
    }
}
