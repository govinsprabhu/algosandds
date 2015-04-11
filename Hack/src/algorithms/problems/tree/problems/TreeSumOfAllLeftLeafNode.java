package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 2/28/2015.
 */
public class TreeSumOfAllLeftLeafNode {
    public static void main(String args[]) {
        TreeNode treeNode = TreeUtils.constructTree();
        TreeUtils.inOrder(treeNode);
        System.out.println(sumOfAllLeftLeafNode(treeNode));
    }

    private static int sumOfAllLeftLeafNode(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.getLeftNode() != null && isLeftNode(root.getLeftNode())) {
            return root.getLeftNode().getData();
        }

        sum += sumOfAllLeftLeafNode(root.getLeftNode());
        sum += sumOfAllLeftLeafNode(root.getRightNode());
        return sum;
    }

    private static boolean isLeftNode(TreeNode treeNode) {
        if (treeNode.getLeftNode() == null && treeNode.getRightNode() == null) {
            return true;
        }

        return false;
    }
}
