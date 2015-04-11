package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

import java.util.Arrays;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class TreeFromArray {
    public static void main(String[] args) {
        int[] a = {8, 2, 4, 9, 12, 3, 1};
        Arrays.sort(a);
        TreeNode treeNode = TreeUtils.constructTree(a, 0, a.length - 1);
        TreeUtils.inOrder(treeNode);
        int[] path = new int[5];
        printPath(treeNode, 12, path, 0);
    }

    private static void printPath(TreeNode root, int k, int[] path, int level) {
        if (root == null) {
            path = null;
            return;
        }
        if (root.getData() == k) {
            printPathArray(path, level);
            return;
        }
        if (root.getData() > k) {
            path[level] = 0;
            printPath(root.getLeftNode(), k, path, level + 1);
        }
        path[level] = 1;
        printPath(root.getRightNode(), k, path, level + 1);
    }

    private static void printPathArray(int[] path, int level) {
        for (int i = 0; i < level; i++) {
            System.out.println(path[i]);
        }
    }


}
