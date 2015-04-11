    package algorithms.problems.crakingthecoding.treesandgraph.binarysearchtree;

    import datastructure.binaryTree.TreeNode;

    public class BinarySearchTree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public BinarySearchTree() {
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert();
    }

    public void insert() {
        root = new TreeNode(5);
        add(root, new TreeNode(4));
        add(root, new TreeNode(9));
        add(root, new TreeNode(3));
        add(root, new TreeNode(6));
        add(root, new TreeNode(8));
        add(root, new TreeNode(6));
       // add(root,new TreeNode(7));
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode root) {
        if (root.getLeftNode() != null)
            inOrderTraversal(root.getLeftNode());
        System.out.println(root.getData());
        if (root.getRightNode() != null) {
            inOrderTraversal(root.getRightNode());
        }
    }

    private void add(TreeNode root, TreeNode newNode) {
        if (root.getData() == newNode.getData()) {
            System.out.println("Duplicate Data");
            return;
        }
        if (root.getData() > newNode.getData()) {
            if (root.getLeftNode() == null) {
                root.setLeftNode(newNode);
            } else {
                add(root.getLeftNode(), newNode);
            }
        } else {
            if (root.getRightNode() == null) {
                root.setRightNode(newNode);
            } else {
                add(root.getRightNode(), newNode);
            }

        }
    }

}