package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GPrabhu on 3/15/2015.
 */
public class TreeLevelOrderUsingQueue {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructTree();
        printLevelOrder(treeNode);
    }

    private static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.getData());
            if(treeNode.getLeftNode()!= null){
                queue.add(treeNode.getLeftNode());
            }
            if(treeNode.getRightNode()!=null){
                queue.add(treeNode.getRightNode());
            }
        }

    }
}
