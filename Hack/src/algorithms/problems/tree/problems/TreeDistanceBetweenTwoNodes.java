package algorithms.problems.tree.problems;

import algorithms.payloads.PageObject;
import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 2/28/2015.
 */
public class TreeDistanceBetweenTwoNodes {
    public static void main(String args[]) {
        TreeNode treeNode = TreeUtils.constructTree();
        //      System.out.println(TreeUtils.height(treeNode));
        System.out.print(printDistant(treeNode, 2, 6));
    }

    private static int printDistant(TreeNode treeNode, int n1, int n2) {
        PageObject pageObject = new PageObject();
        TreeNode root = leastAncestralNode(treeNode, pageObject, n1, n2, 0);
        if (pageObject.getDist1() != 0 && pageObject.getDist2() != 0) {
            return pageObject.getDist();
        }
        if (pageObject.getDist1() != n1) {
            return findLevel(root, n2, 0);
        }
        return findLevel(root, n1, 0);
    }

    private static TreeNode leastAncestralNode(TreeNode root, PageObject pageObject, int n1, int n2, int level) {
        if (root == null) {
            return null;
        }
        if (root.getData() == n1) {
            pageObject.setDist1(level);
            return root;
        }
        if (root.getData() == n2) {
            pageObject.setDist2(level);
            return root;
        }
        TreeNode leftTreeNode = leastAncestralNode(root.getLeftNode(), pageObject, n1, n2, level + 1);
        TreeNode rightTreeNode = leastAncestralNode(root.getRightNode(), pageObject, n1, n2, level + 1);
        if (leftTreeNode != null && rightTreeNode != null) {
            pageObject.setDist(pageObject.getDist1() + pageObject.getDist2() - 2 * level);
            return root;
        }
        return leftTreeNode != null ? leftTreeNode : rightTreeNode;
    }

    private static int findLevel(TreeNode root, int data, int level) {
        if (root == null) {
            return 0;
        }
        if (root.getData() == data) {
            return level;
        }
        int leftLevel = findLevel(root.getLeftNode(), data, level + 1);
        return leftLevel != 0 ? leftLevel : findLevel(root.getRightNode(), data, level + 1);
    }
}
