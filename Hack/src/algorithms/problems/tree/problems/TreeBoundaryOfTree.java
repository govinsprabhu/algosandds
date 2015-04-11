package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

public class TreeBoundaryOfTree {
    public static void main(String args[]){
        TreeNode treeNode= TreeUtils.constructTree();
        printBoundary(treeNode);
    }

    private static void printBoundary(TreeNode root){
        if(root!=null){
            System.out.println(root.getData());
        }
        printLeftBoundary(root.getLeftNode());
        printLeafNode(root.getLeftNode());
        printLeafNode(root.getRightNode());
        printRightBoundary(root.getRightNode());

    }

    private static void printLeftBoundary(TreeNode root){
       if(root==null){
           return;
       }
        if(root.getLeftNode()!=null){
            System.out.println(root.getData());
            printLeftBoundary(root.getLeftNode());
        }
        else if(root.getRightNode()!=null){
            System.out.println(root.getData());
            printRightBoundary(root.getRightNode());
        }

    }

    private static void printRightBoundary(TreeNode root){
        if(root==null){
            return;
        }
        if(root.getRightNode()!=null){
            System.out.println(root.getData());
            printLeftBoundary(root.getLeftNode());
        }
        else if(root.getLeftNode()!=null){
            System.out.println(root.getData());
            printRightBoundary(root.getLeftNode());
        }

    }
    private static void printLeafNode(TreeNode root){
        if(root==null)
            return;
        if(root.getLeftNode()==null&&root.getRightNode()==null){
            System.out.println(root.getData());
        }

        printLeafNode(root.getLeftNode());
        printLeafNode(root.getRightNode());

    }
}
