package algorithms.problems.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GPrabhu on 3/18/2015.
 */
public class CountAndPrintDecoding {
    public static Map< Integer,Character> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 'a', j = 1; i <= 'z'; i++, j++) {
            map.put(j,(char) i);
        }

        String word = "12312";
        printAllDecoding(new int[] {1,2,3,1,2}, 0,new char[5],0);
        //System.out.println(printNumberOfDecoding(new int[]{1, 2, 3, 2, 1}, 5));
    }

    private static void printAllDecoding(int a[], int index, char[] tmpArray, int currentPosition ){
        if(index >= a.length){
            print(tmpArray,currentPosition);
            return;
        }
        if(map.containsKey(a[index])){
            tmpArray[currentPosition] = map.get(a[index]);
            printAllDecoding(a, index + 1, tmpArray, currentPosition + 1);
        }
        if((index+1 < a.length) &&  (map.containsKey(a[index]*10 + a[index+1]))){
            tmpArray[currentPosition] = map.get(a[index] * 10 + a[index+1]);
            printAllDecoding(a,index+2,tmpArray,currentPosition+1);
        }

    }

    private static void print(char[] tmpArray, int currentPosition) {
        for(int i= 0; i< currentPosition; i++){
            System.out.print(tmpArray[i]);
        }
        System.out.println();
    }

    private static int printNumberOfDecoding(int[] a, int length) {
        if (length == 0 || length == 1)
            return 1;

        int count = 0;
        if (a[length - 1] > 0) {
            count += printNumberOfDecoding(a, length - 1);
        }
        if (a[length - 2] < 2 || (a[length - 2] == 2 && a[length - 1] < 7)) {
            count += printNumberOfDecoding(a, length - 2);
        }
        return count;
    }
}
