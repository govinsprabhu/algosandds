package algorithms.problems.dynamicprograming;

import java.util.Hashtable;

/**
 * Created by GPrabhu on 2/24/2015.
 */
public class FindWords {
//todo implement using dp !!
    public static boolean findWord(String word, Hashtable hashMap){

        if(word.length()==0)return true;
        for(int i=1;i<=word.length();i++){
            if(hashMap.containsKey(word.substring(0,i))&&findWord(word.substring(i,word.length()),hashMap)){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Hashtable<String,Boolean> hashMap= new Hashtable<>();
        String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};

        for(String word:dictionary){
            hashMap.put(word,true);
        }
        System.out.println(hashMap.containsKey("like"));
        System.out.println("like".substring(0,1));
        System.out.println(findWord("likesamsung", hashMap));
    }
}
