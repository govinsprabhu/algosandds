package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

import java.util.*;

/**
 * Created by GPrabhu on 3/18/2015.
 */
public class TreeVerticalSum {
    private TreeNode treeNode;
    private int horizontalDistance;

    public TreeVerticalSum(TreeNode treeNode, int horizontalDistance) {
        this.treeNode = treeNode;
        this.horizontalDistance = horizontalDistance;
    }

    public TreeVerticalSum() {
        this.horizontalDistance = 0;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructTree();
        TreeVerticalSum treeVerticalSum = new TreeVerticalSum();
        treeVerticalSum.verticalSum(treeNode);
        TreeUtils.inOrder(treeNode);
    }

    private void verticalSum(TreeNode treeNode) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeVerticalSum> queue = new LinkedList<>();
        queue.add(new TreeVerticalSum(treeNode, 0));
        while (!queue.isEmpty()) {
            TreeVerticalSum treeVerticalSum = queue.poll();
            if (map.containsKey(treeVerticalSum.horizontalDistance)) {
                int sum = map.get(treeVerticalSum.horizontalDistance);
                map.put(treeVerticalSum.horizontalDistance, sum + treeVerticalSum.treeNode.getData());

            } else {
                map.put(treeVerticalSum.horizontalDistance, treeVerticalSum.treeNode.getData());
            }
            if (treeVerticalSum.treeNode.getLeftNode() != null) {
                queue.add(new TreeVerticalSum(treeVerticalSum.treeNode.getLeftNode(), treeVerticalSum.horizontalDistance - 1));
            }
            if (treeVerticalSum.treeNode.getRightNode() != null) {
                queue.add(new TreeVerticalSum(treeVerticalSum.treeNode.getRightNode(), treeVerticalSum.horizontalDistance + 1));
            }
        }
        for (int key : map.keySet()) {
            System.out.println("key :" + key + "value " + map.get(key));
        }
    }
}
