package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

import java.util.ArrayList;

/**
 * Created by GPrabhu on 2/28/2015.
 */
public class TreePrintAnyPathSumUpTo {


    public static void main(String arg[]) {
        TreeNode treeNode = TreeUtils.constructTree();

        ArrayList<Integer> buffer = new ArrayList<>();
/*        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        ArrayList<Integer> bufferCopy= (ArrayList<Integer>) buffer.clone();
        bufferCopy.forEach(x-> System.out.println(x));
*/
        printPath(treeNode, buffer, 0, 7);
    }

    private static void printPath(TreeNode treeNode, ArrayList<Integer> buffer, int level, int sum) {
        if (treeNode == null) {
            return;
        }
        int dupli = sum;
        buffer.add(treeNode.getData());
        for (int j = level; j >= 0; j--) {
            dupli -= buffer.get(j);
            if (dupli == 0) {
                print(buffer, j, level);
                System.out.println();

            }

        }
        ArrayList<Integer> treeNodeLeft = (ArrayList<Integer>) buffer.clone();
        ArrayList<Integer> treeNodeRight = (ArrayList<Integer>) buffer.clone();

        printPath(treeNode.getLeftNode(), treeNodeLeft, level + 1, sum);
        printPath(treeNode.getRightNode(), treeNodeRight, level + 1, sum);
    }

    private static void print(ArrayList<Integer> buffer, int j, int level) {
        for (int i = j; i <= level; i++) {
            System.out.print(buffer.get(i) + " ");
        }
    }
}
