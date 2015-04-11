package algorithms.problems.crakingthecoding.treesandgraph.createbalacedtree;

import datastructure.binaryTree.TreeNode;

/**
 * Created by GPrabhu on 12/13/2014.
 */
public class BalancedTree {
    public static void main(String[] args) {
        int a[] = {0,1, 2, 3, 4, 5, 6, 7, 8, 9};
        BalancedTree balancedTree = new BalancedTree();
        TreeNode treeNode=balancedTree.balance(a, 0, 9);
        treeNode.inOrderTraverse(treeNode);
    }

    private TreeNode balance(int a[], int start, int end) {
        TreeNode treeNode = null;
        if(start<=end) {
            int mid = (start + end) / 2;
         treeNode= new TreeNode(a[mid]);
            treeNode.setLeftNode(balance(a, start, mid - 1));
            treeNode.setRightNode(balance(a, mid + 1, end));
        }
        return treeNode;
    }
}
