package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 2/26/2015.
 */
public class TreeConvertTosumTree {
    public static void main(String args[]){
        TreeNode root= TreeUtils.constructTree();
        int[] a=new int[5];
        sumTree(root);
        TreeUtils.inOrder(root);
    }

    private static int  sumTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        int data=root.getData();

        int left =sumTree(root.getLeftNode());
        int right=sumTree(root.getRightNode());
        root.setData(left+right);
        return left+right+data;
    }

}
