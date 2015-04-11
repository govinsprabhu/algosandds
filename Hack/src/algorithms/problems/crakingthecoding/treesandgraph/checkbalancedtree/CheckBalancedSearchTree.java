package algorithms.problems.crakingthecoding.treesandgraph.checkbalancedtree;

import algorithms.problems.crakingthecoding.treesandgraph.binarysearchtree.BinarySearchTree;
import datastructure.binaryTree.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GPrabhu on 12/13/2014.
 */
public class CheckBalancedSearchTree {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert();
        CheckBalancedSearchTree checkBalancedSearchTree =new CheckBalancedSearchTree();
        System.out.println(checkBalancedSearchTree.checkBalanced(binarySearchTree));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            char c= in.readLine().charAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(5).length());
    }

    private boolean checkBalanced(BinarySearchTree binarySearchTree) {
        System.out.println(getMax(binarySearchTree.getRoot()));
        System.out.println(getMin(binarySearchTree.getRoot()));
        return (getMax(binarySearchTree.getRoot())-getMin(binarySearchTree.getRoot()))<=1;
    }

    private  int getMax(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(getMax(root.getRightNode()),getMax(root.getLeftNode()));
    }
    private  int getMin(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.min(getMin(root.getRightNode()), getMin(root.getLeftNode()));
    }

}
