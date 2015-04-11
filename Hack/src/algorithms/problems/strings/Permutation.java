package algorithms.problems.strings;

/**
 * Created by GPrabhu on 3/18/2015.
 */
public class Permutation {
    public static void main(String[] args) {
        String word = "abc";
        printPermutation(word.toCharArray(), 0,word.length()-1);
    }

    private static void printPermutation(char[] word, int i, int length) {

        if(i == length){
            print(word);
            return;
        }
        for(int j = i ; j <= length ;j++){
            swap(word,i,j);
            printPermutation(word,i+1,length);
            swap(word,i,j);
        }
    }
    private static void print(char[] a){
        for(int i =0; i < a.length; i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }

    private static void swap(char[] a, int i, int j){
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

