package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 2/27/2015.
 */
public class TreeChildrenSumProperty {
    public static void main(String[] args) {
        TreeNode treeNode= TreeUtils.constructTree();
        childrenSumProperty(treeNode);
        TreeUtils.inOrder(treeNode);

    }
    private static  void childrenSumProperty(TreeNode root){
        if(root==null||(root.getRightNode()==null&&root.getLeftNode()==null)){
            return;
        }
        childrenSumProperty(root.getLeftNode());
        childrenSumProperty(root.getRightNode());
        int data = 0;
        if(root.getLeftNode()!=null){
            data=root.getLeftNode().getData();
        }
        if(root.getRightNode()!=null){
            data+=root.getRightNode().getData();
        }
        int difference=data-root.getData();
        if(difference>0){
            root.setData(root.getData()+difference);
        }
        else {
            propagateDifference(root,-difference);
        }

    }

    private static void propagateDifference(TreeNode root, int difference) {
        if(root.getLeftNode()!=null){
           root.getLeftNode().setData(root.getLeftNode().getData() + difference);
            propagateDifference(root.getLeftNode(),difference);
        }
        else if(root.getRightNode()!=null){
            root.getRightNode().setData(root.getLeftNode().getData() + difference);
            propagateDifference(root.getRightNode(),difference);
        }

    }
}
