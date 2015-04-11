package datastructure.binaryTree.utility;

import datastructure.binaryTree.TreeNode;

/**
 * Created by GPrabhu on 2/26/2015.
 */
public class TreeUtils {
    public static TreeNode constructTree() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        //TreeNode treeNode8 = new TreeNode(8, null, null);
        //TreeNode treeNode9 = new TreeNode(9, null, null);
        treeNode1.setLeftNode(treeNode2);
        treeNode1.setRightNode(treeNode3);
        treeNode2.setLeftNode(treeNode4);
        treeNode2.setRightNode(treeNode5);
        treeNode3.setLeftNode(treeNode6);
        treeNode3.setRightNode(treeNode7);
        //treeNode5.setRightNode(treeNode8);
        //treeNode8.setRightNode(treeNode9);
        return treeNode1;
    }
    public static TreeNode constructBinarySearchTree() {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(7, null, null);
        TreeNode treeNode5 = new TreeNode(9, null, null);
        TreeNode treeNode6 = new TreeNode(11, null, null);
        TreeNode treeNode7 = new TreeNode(13, null, null);
        //TreeNode treeNode8 = new TreeNode(8, null, null);
        //TreeNode treeNode9 = new TreeNode(9, null, null);
        treeNode1.setLeftNode(treeNode2);
        treeNode1.setRightNode(treeNode3);
        treeNode2.setLeftNode(treeNode4);
        treeNode2.setRightNode(treeNode5);
        treeNode3.setLeftNode(treeNode6);
        treeNode3.setRightNode(treeNode7);
        //treeNode5.setRightNode(treeNode8);
        //treeNode8.setRightNode(treeNode9);
        return treeNode1;
    }


    public static int height(TreeNode root) {
        if (root == null) {
            return 0;

        }
        return 1 + Math.max(height(root.getLeftNode()), height(root.getRightNode()));
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeftNode());
        System.out.println(root.getData());
        inOrder(root.getRightNode());
    }

    public static void  levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.getData() + " ");
            return;

        }
        levelOrder(root.getLeftNode(), level - 1);
        levelOrder(root.getRightNode(), level - 1);
   }
    public  static  int findLevel(TreeNode root,int currentLevel,int data){
        if(root==null){
            return 0;
        }

        if(root.getData()==data){
            return currentLevel;
        }
        int leftLevel=findLevel(root.getLeftNode(),currentLevel+1,data);
        return leftLevel!=0?leftLevel:findLevel(root.getRightNode(),currentLevel+1,data);

    }
    public static TreeNode constructTree(int[] a, int l, int h) {
        if(l>h){
            return null;
        }
        int m=(l+h)/2;
        TreeNode treeNode=new TreeNode(a[m]);
        treeNode.setLeftNode(constructTree(a,l,m-1));
        treeNode.setRightNode(constructTree(a,m+1,h));
        return treeNode;
    }
}
