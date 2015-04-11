package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class TreeCheckTwoTreesAreSame {
    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.constructTree();
        TreeNode root2=TreeUtils.constructTree();
        System.out.println(isSame(root1, root2));

    }
    private static boolean isSame(TreeNode root1,TreeNode root2){
        if(root2==null){
            return false;
        }
        return findFirstMatchingNode(root1,root2);
    }
    private static boolean findFirstMatchingNode(TreeNode root1,TreeNode root2){
        if(root1==null){
            return false;
        }
        if(root1.getData()==root2.getData()){
            return checkSame(root1,root2);
        }
        return findFirstMatchingNode(root1.getLeftNode(),root2)||findFirstMatchingNode(root2.getRightNode(),root2);
    }

    private static boolean checkSame(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }

        if(root1==null||root2==null){
            return false;
        }
        return checkSame(root1.getLeftNode(),root2.getLeftNode())&&checkSame(root1.getRightNode(),root2.getRightNode());
    }

}
