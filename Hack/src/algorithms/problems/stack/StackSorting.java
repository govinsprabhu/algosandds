package algorithms.problems.stack;

import java.util.Stack;

/**
 * Created by GPrabhu on 3/17/2015.
 */
public class StackSorting {
    public static void main(String[] args) {
        Stack<Integer> stack =new Stack();
        stack.push(7);
        stack.push(6);
        stack.push(3);
        stack.push(4);
        Stack stack1 = (Stack) stack.clone();
        while (!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }
        System.out.println("--------------------");
        reverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void reverse(Stack stack) {
        if(stack.isEmpty()){
            return;
        }
        int top = (int) stack.pop();
        reverse(stack);
        insert(stack,top);
    }

    private static void insert(Stack stack, int top) {
        if(stack.isEmpty()){
            stack.push(top);
            return;
        }
        int item = (int) stack.pop();
        int small = Math.min(top,item);
        int large = Math.max(top,item);
        insert(stack,small);
        stack.push(large);
    }
}
