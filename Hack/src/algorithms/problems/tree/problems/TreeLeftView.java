package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;
import algorithms.problems.tree.payload.MaxLevel;

/**
 * Created by GPrabhu on 2/26/2015.
 */
public class TreeLeftView {
    public static void main(String[] args) {
        TreeNode treeNode= TreeUtils.constructTree();

        //leftView(treeNode,1,new MaxLevel(0));
        System.out.println(TreeUtils.findLevel(treeNode, 1, 5));
    }

    public static void leftView(TreeNode root,int level,MaxLevel maxLevel){
        if(root==null){
            return;
        }
        if(level>maxLevel.getMaxValue()){
            System.out.println(root.getData());
            maxLevel.setMaxValue(level);
        }
        leftView(root.getLeftNode(),level+1,maxLevel);
        leftView(root.getRightNode(),level+1,maxLevel);

    }
}
