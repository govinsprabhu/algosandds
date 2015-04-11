package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class TreeNodesWIthDistanceK {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree();
        int[] a = new int[5];
        int level = 0;
        printNodesWithKDistances(root, 3, a, level);
    }

    private static void printNodesWithKDistances(TreeNode root, int k, int[] a, int level) {
        if (root == null) {
            return;
        }
        a[level] = root.getData();
        level++;
        if (k == 0) {
            printPath(a, level);
            System.out.println("_________________________");
            return;
        }
        printNodesWithKDistances(root.getLeftNode(), k - 1, a, level);
        printNodesWithKDistances(root.getRightNode(), k - 2, a, level);

    }

    private static void printPath(int[] a, int level) {
        for (int i = 0; i < level; i++) {
            System.out.println(a[i]);
        }
    }
}