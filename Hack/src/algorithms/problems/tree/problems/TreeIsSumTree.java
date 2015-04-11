package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

public class TreeIsSumTree {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructTree();
        TreeUtils.inOrder(treeNode);
        System.out.println(isSumTree(treeNode));
    }

    private static boolean isSumTree(TreeNode root) {
        if (root == null || (root.getLeftNode() == null && root.getRightNode() == null)) {
            return true;
        }
        int left = sum(root.getLeftNode());
        int right = sum(root.getRightNode());

        if(root.getData() == left + right
                &&(isSumTree(root.getLeftNode())
                &&isSumTree(root.getRightNode())))
            return true;
        return false;
    }

    private static int sum(TreeNode node) {
        if (node == null)
            return 0;
        return sum(node.getLeftNode())+node.getData()+sum(node.getRightNode());
    }
}
