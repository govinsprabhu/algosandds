package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 2/26/2015.
 */
public class TreeAllRootToLeafPath {
    public static void main(String args[]) {
        TreeNode root = TreeUtils.constructTree();
        int[] a = new int[5];
        printAllPaths(root, a, 0);
    }

    private static void printAllPaths(TreeNode root, int[] a, int pathLevel) {
        if (root == null) {
            return;
        }
        a[pathLevel++] = root.getData();
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            printRootToLeag(a, pathLevel);
            return;
        }
        printAllPaths(root.getLeftNode(), a, pathLevel);
        printAllPaths(root.getRightNode(), a, pathLevel);
    }

    private static void printRootToLeag(int[] a, int pathLevel) {
        for (int i = 0; i < pathLevel; i++) {
            System.out.print(a[i]);
            System.out.println();
        }
    }

}
