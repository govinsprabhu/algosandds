package algorithms.problems.AlgorithmDesignAndAnalysis.twoSumProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by GPrabhu on 11/30/2014.
 */
public class TwoSumProblem {
    private static  ArrayList<Long> key;
    public static void main(String[] args) {
        HashMap<Long,Boolean> hashMap=new HashMap<>();
        key=new ArrayList<Long>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("algo1-programming_prob-2sum.txt"));
            String txt=null;
            int i=0;
          while((txt=bufferedReader.readLine())!=null){
              hashMap.put((long) Integer.parseInt(txt),true);
              key.add((long) Integer.parseInt(txt));
          }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        twoSum(hashMap,key);

    }

    private static void twoSum(HashMap<Long, Boolean> hashMap,ArrayList key) {

        int k=0;
        for(int sum=-10000;sum<=10000;sum++){
            for(int j=0;j<key.size();j++){
                long diff= (long) key.get(j);
               if(hashMap.containsKey(sum-(long)key.get(j))){
                k++;

               }
            }

        }
        System.out.println("OUTPUT "+k);
    }
}
