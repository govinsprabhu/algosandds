package algorithms.problems.bitoperator;

/**
 * Created by GPrabhu on 3/8/2015.
 */
public class AddTwoNumbers{

    public static void main(String args[]){
        System.out.println(addTwoNumbers(19,20));
    }
    private static int addTwoNumbers(int a, int b){
        while(b>0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
}