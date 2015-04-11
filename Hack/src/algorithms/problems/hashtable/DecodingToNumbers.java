package algorithms.problems.hashtable;

import java.util.Hashtable;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class DecodingToNumbers {
    private Hashtable<Character, Integer> chatIntHashTable = new Hashtable<>();
    private Hashtable<Integer, Character> intCharHashTable = new Hashtable<>();
    public DecodingToNumbers() {

        for (int i = 0; i < 26; i++) {
            chatIntHashTable.put((char) ('A' + i), i + 1);
        }
        for (int i = 0; i < 26; i++) {
            intCharHashTable.put(i + 1, (char) ('A' + i));
        }
    }

    public static void main(String[] args) {
        DecodingToNumbers decodingToNumbers = new DecodingToNumbers();

        //System.out.println(mappingLettersToNumbers.printTheNumberGivenCharacters("AZ"));
        System.out.println(decodingToNumbers.printTheCharacterGivenTheNumbers(123));
        int[] a=new int[]{1,2,3,4};
        System.out.println(decodingToNumbers.printTheDecodingCount(a,4));
        String word = "hi";
   //     word.substring(3)
    }



    private int printTheDecodingCount(int[] number,int n) {
        if(n==0||n==1){
            return 1;
        }
        int count =0;
        if(number[n-1]>0)
        count=printTheDecodingCount(number,n-1);
        if(number[n-2]<2||(number[n-1]<7&&number[n-2]==2)){
            count+=printTheDecodingCount(number,n-2);
        }
        return count;
    }

    private StringBuffer printTheCharacterGivenTheNumbers(int number) {
        StringBuffer stringBuffer=new StringBuffer();
        while (number>0){
            int i=number%10;
            if(intCharHashTable.containsKey(i)){
                stringBuffer.append(intCharHashTable.get(i));
            }
            number/=10;
        }
        return stringBuffer;

    }

    private int printTheNumberGivenCharacters(String letters) {
        int sum = 0;
        int j = 1;
        int k = 1;
        for (int i = letters.length() - 1; i >= 0; i--) {
            char character = letters.charAt(i);
            if (chatIntHashTable.containsKey(character)) {
                int value = chatIntHashTable.get(character);
                sum += value * j;
                j = j * 26;
            }
        }
        return sum;
    }
}
