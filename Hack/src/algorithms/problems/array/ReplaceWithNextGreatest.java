package algorithms.problems.array;

import datastructure.stack.Stack;

/**
 * Created by GPrabhu on 2/28/2015.
 */
public class ReplaceWithNextGreatest {
    public static void main(String arg[]) {
        int[] a = {2, 5, 3, 7, 1, 8, 6, 4, 9, 0};
        printNextGreatest(a);
    }

    private static void printNextGreatest(int[] a) {
        Stack stack = new Stack();
        stack.push(a[0]);

        for (int i = 1; i < a.length; i++) {
            if (!stack.isEmpty()) {

                while (a[i] > stack.peek()) {
                    System.out.println(stack.pop() + "--> " + a[i]);
                    if (stack.isEmpty()) {
                        break;
                    }
                }
                stack.push(a[i]);
            }
        }
        while (!stack.isEmpty())
        System.out.println(stack.pop()+"-->"+"-1");
    }
}
