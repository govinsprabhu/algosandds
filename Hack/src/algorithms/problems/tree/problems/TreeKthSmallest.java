package algorithms.problems.tree.problems;

import algorithms.problems.tree.payload.WrapperPayload;
import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 3/18/2015.
 */
public class TreeKthSmallest {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructBinarySearchTree();
        int k = 5;
        WrapperPayload wrapperPayload = new WrapperPayload();
        wrapperPayload.setKthNode(k);
        printKthSmallest(treeNode, wrapperPayload);
        System.out.println(wrapperPayload.getMaxValue());
    }

    private static void printKthSmallest(TreeNode treeNode, WrapperPayload wrapperPayload) {
        if (treeNode == null) {
            return;
        }
        printKthSmallest(treeNode.getLeftNode(), wrapperPayload);
        wrapperPayload.decrementCount();
        if (wrapperPayload.getKthNode() == 0) {
            wrapperPayload.setMaxValue(treeNode.getData());
        }
        printKthSmallest(treeNode.getRightNode(), wrapperPayload);

    }
}
