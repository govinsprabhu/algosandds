package datastructure.binaryTree;

/**
 * Created by GPrabhu on 12/13/2014.
 */
public class TreeNode {
    int data;
    TreeNode leftNode;
    TreeNode rightNode;
    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void inOrderTraverse(TreeNode root) {
        if (root.getLeftNode() != null) {
            inOrderTraverse(root.getLeftNode());
        }
        System.out.println(root.getData());
        if (root.getRightNode() != null) {
            inOrderTraverse(root.getRightNode());
        }
    }
}
