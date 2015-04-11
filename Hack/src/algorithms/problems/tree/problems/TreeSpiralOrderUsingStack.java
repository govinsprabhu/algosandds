package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by GPrabhu on 3/15/2015.
 */
public class TreeSpiralOrderUsingStack {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructTree();
        //printSpiralOrder(treeNode);
        int[] a ={1,2,3,4,5,6,7};
        int n= a.length;
        for(int i=0; i< n/2; i++ ){
            int tmp =a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = tmp;
        }
        Arrays.asList(a).forEach(x-> System.out.println(x));
        for (int i :a){
            System.out.println(i);
        }
    }

    private static void printSpiralOrder(TreeNode treeNode) {
        Stack stack1 =new Stack();
        Stack stack2 =new Stack();
        stack1.push(treeNode);
        while (!stack1.isEmpty() ||!stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode treeNode1 = (TreeNode) stack1.pop();
                System.out.println(treeNode1.getData());
                if (treeNode1.getRightNode() != null) {
                    stack2.push(treeNode1.getRightNode());
                }
                if (treeNode1.getLeftNode() != null) {
                    stack2.push(treeNode1.getLeftNode());
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode treeNode1 = (TreeNode) stack2.pop();
                System.out.println(treeNode1.getData());

                if (treeNode1.getLeftNode() != null) {
                    stack1.push(treeNode1.getLeftNode());
                }
                if (treeNode1.getRightNode() != null) {
                    stack1.push(treeNode1.getRightNode());
                }
            }
        }
    }
}
