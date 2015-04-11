package algorithms.problems.tree.problems;

import algorithms.problems.tree.payload.WrapperPayload;
import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 *
 * adds left nodes data to its neighbouring right node in each level
 *        1            1
 *      /   \        /  \
 *      2    3      2     5
 */
public class TreeSpecialSumTree {
    public static void main(String args[]){
        TreeNode root = TreeUtils.constructTree();
        TreeUtils.inOrder(root);
        convertToSpecialSumTree(root);
        TreeUtils.inOrder(root);
    }

    private static void convertToSpecialSumTree(TreeNode root){
        int height=TreeUtils.height(root);
        for(int i=1;i<=height;i++){
            convertToSpecialSum(root,i,1,new WrapperPayload(0));
        }
    }

    private static void convertToSpecialSum(TreeNode root,int d,int level,WrapperPayload WrapperPayload){
        if(root==null){
            return;
        }
        if(level==d ){
            root.setData(root.getData()+ WrapperPayload.getMaxValue());
            WrapperPayload.setMaxValue(root.getData());
            return;
        }

        convertToSpecialSum(root.getLeftNode(),d,level+1, WrapperPayload);
        convertToSpecialSum(root.getRightNode(),d,level+1, WrapperPayload);
    }
}
