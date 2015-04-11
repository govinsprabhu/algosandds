package datastructure.stack;

import java.util.Stack;

/**
 * Created by GPrabhu on 2/18/2015.
 */
public class TestStack {
    public static void main(String[] args) {
        Stack stack =new Stack();
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }


}
