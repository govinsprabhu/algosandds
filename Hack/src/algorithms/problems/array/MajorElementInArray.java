package algorithms.problems.array;

import java.util.HashMap;

/**
 * Created by GPrabhu on 3/8/2015.
 */
public class MajorElementInArray {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,4,6,4,4,4};
        HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
        for(int i=0;i<a.length;i++){
            if(hashMap.containsKey(a[i])){
                int count=hashMap.get(a[i]);
                hashMap.put(a[i],++count);
            }else {
                hashMap.put(a[i],1);
            }

           }
        for(Integer key:hashMap.keySet()){
            System.out.println("key "+key+" Value :"+hashMap.get(key));
           if(hashMap.get(key)>=a.length/2){

               System.out.println("Major element: "+hashMap.get(key));
           }
        }
    }
}
