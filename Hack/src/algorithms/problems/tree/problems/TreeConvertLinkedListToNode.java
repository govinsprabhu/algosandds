package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 3/6/2015.
 */
public class TreeConvertLinkedListToNode {
    public static void main(String args[]){
        TreeNode root = TreeUtils.constructTree();
        TreeNode treeNode=getFromTree(root);
        while(treeNode!=null){
            System.out.println(treeNode.getData());
            treeNode=treeNode.getLeftNode();
        }
    }
    private static TreeNode getFromTree(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.getLeftNode()!=null) {


            TreeNode left = getFromTree(root.getLeftNode());
                for (; left.getRightNode() != null; left = left.getRightNode()) ;
                root.setLeftNode(left);
                left.setRightNode(root);
        }
        if(root.getRightNode()!=null) {
            TreeNode right = getFromTree(root.getRightNode());
                for (; right.getLeftNode() != null; right = right.getLeftNode()) ;
                root.setRightNode(right);
                right.setLeftNode(root);
        }
        return root;
    }
}
