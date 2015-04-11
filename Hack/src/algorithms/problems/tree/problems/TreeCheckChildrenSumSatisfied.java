package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class TreeCheckChildrenSumSatisfied {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructTree();
        System.out.println(isChildrenSumPropertySatisfied(treeNode));
        TreeUtils.inOrder(treeNode);
    }

    private static boolean isChildrenSumPropertySatisfied(TreeNode root) {
        if (root == null || (root.getRightNode() == null && root.getLeftNode() == null)) {
            return true;
        }
        isChildrenSumPropertySatisfied(root.getLeftNode());
        isChildrenSumPropertySatisfied(root.getRightNode());
        int data = 0;
        if (root.getLeftNode() != null) {
            data = root.getLeftNode().getData();
        }
        if (root.getRightNode() != null) {
            data += root.getRightNode().getData();
        }
        if (data == root.getData() &&
                isChildrenSumPropertySatisfied(root.getLeftNode()) &&
                isChildrenSumPropertySatisfied(root.getRightNode())) {
            return true;
        }
        return false;
    }

}
