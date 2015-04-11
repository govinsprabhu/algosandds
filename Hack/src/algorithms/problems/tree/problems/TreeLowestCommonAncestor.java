package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 2/26/2015.
 */
public class TreeLowestCommonAncestor {
    public static void main(String args[]){
        TreeNode root= TreeUtils.constructTree();
        TreeUtils.inOrder(root);
        TreeNode treeNode=lowestCommonAncestor(root, 8, 5   );
        if(treeNode!=null){
            System.out.println(treeNode.getData());
        }
        else {
            System.out.println("NO LCA");
        }
    }

    private static TreeNode lowestCommonAncestor(TreeNode root,int n1,int n2){
        if(root==null){
            return null;
        }
        if(root.getData()==n1|| root.getData()==n2){
            return root;
        }

        TreeNode leftNode=lowestCommonAncestor(root.getLeftNode(),n1,n2);
        TreeNode rightNode=lowestCommonAncestor(root.getRightNode(),n1,n2);

        if(leftNode!=null&&rightNode!=null){
            return root;
        }
        return leftNode!=null?leftNode:rightNode;
    }
}
