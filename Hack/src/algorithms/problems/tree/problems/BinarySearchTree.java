package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;


/**
 * Created by GPrabhu on 3/15/2015.
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree();
        TreeUtils.inOrder(root);
        System.out.println(printIsBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean printIsBst(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.getData() < minValue || root.getData() > maxValue) {
            return false;
        }
        return printIsBst(root.getLeftNode(), minValue, root.getData()) &&
                printIsBst(root.getRightNode(), root.getData(), maxValue);


    }
}
