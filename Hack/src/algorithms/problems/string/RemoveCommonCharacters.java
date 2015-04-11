package algorithms.problems.string;

/**
 * Created by GPrabhu on 3/15/2015.
 */
public class RemoveCommonCharacters {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "mask";
        printRemoveCommonCharacters(s1, s2);
    }

    private static void printRemoveCommonCharacters(String s1, String s2) {
        char[] c= s1.toCharArray();
        int[] count = new int[256];
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)]++;
        }
        int cLength=0;
        for(int i=0 ;i <c.length;i++){
            if(count[s1.charAt(i)]==0){

                c[cLength++]=s1.charAt(i);
            }
        }

        for(int i=0; i < cLength;i++)
        System.out.print(c[i]);
    }
}
