package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class TreeAllNodesKDistanceFromTarget {
    public static void main(String[] args) {
        TreeNode treeNode= TreeUtils.constructTree();
        printAllNodesFromKDistance(treeNode,1,2);

    }

    private static int  printAllNodesFromKDistance(TreeNode root,int target, int k) {
        if(root==null){
            return -1;
        }
        if(root.getData()==target){
            printAllNodesDown(root,k);
            return 0;
        }
        int left=printAllNodesFromKDistance(root.getLeftNode(),target,k);
        if(left!=-1){
            if(left+1==k){
                System.out.println(root.getData());
            }
            else {
                printAllNodesDown(root.getRightNode(),k-left-2);
            }
            return 1+left;
        }
        int right=printAllNodesFromKDistance(root.getRightNode(),target,k);
        if(right!=-1){
            if(right+1==k){
                System.out.println(root.getData());
            }
            else {
                printAllNodesDown(root.getLeftNode(),k-right-2);
            }
            return 1+right;
        }
        return -1;
    }

    private static void printAllNodesDown(TreeNode root,int k) {
        if(root==null){
            return;
        }
        if(k==0){
            System.out.println(root.getData());
        }
        printAllNodesDown(root.getLeftNode(),k-1);
        printAllNodesDown(root.getRightNode(),k-1);
    }

}
