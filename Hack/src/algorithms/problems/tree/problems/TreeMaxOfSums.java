package algorithms.problems.tree.problems;

import algorithms.problems.tree.payload.WrapperPayload;
import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class TreeMaxOfSums {
    public static void main(String[] args) {
        TreeNode treeNode= TreeUtils.constructTree();
        WrapperPayload maxOfSums=new WrapperPayload(0);
        maxOfSums(treeNode,maxOfSums);
        System.out.println(maxOfSums.getMaxValue()+"\n-----------------");
        TreeUtils.inOrder(treeNode);

    }

    private static int maxOfSums(TreeNode root,WrapperPayload WrapperPayload) {
       if(root.getRightNode()==null&&root.getLeftNode()==null){
           return  root.getData();
       }
        int leftSum=maxOfSums(root.getLeftNode(), WrapperPayload);
        int rightSum=maxOfSums(root.getRightNode(), WrapperPayload);
        root.setData(root.getData()+leftSum+rightSum);
        if(root.getData()> WrapperPayload.getMaxValue()){
            WrapperPayload.setMaxValue(root.getData());
        }
        return root.getData();
    }
}
