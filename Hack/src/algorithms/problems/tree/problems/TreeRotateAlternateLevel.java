package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 3/22/2015.
 */
public class TreeRotateAlternateLevel {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.constructTree();
        rotateAlternateLevel(treeNode,0);
        TreeUtils.inOrder(treeNode);
    }

    private static void rotateAlternateLevel(TreeNode root,int level) {
        if(root == null){
            return;
        }

        rotateAlternateLevel(root.getLeftNode(),level+1);
        if(level%2 == 0){
            TreeNode tmp = root.getLeftNode();
            root.setLeftNode(root.getRightNode());
            root.setRightNode(tmp);
        }

        rotateAlternateLevel(root.getRightNode(),level+1);
    }
}
