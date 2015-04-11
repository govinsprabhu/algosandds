package algorithms.problems.tree.problems;

import datastructure.binaryTree.TreeNode;
import datastructure.binaryTree.utility.TreeUtils;

import java.util.*;

/**
 * Created by GPrabhu on 3/25/2015.
 */
public class TreeTopAndBottomViewView {
    private TreeNode treeNode;
    private int hd;

    public TreeTopAndBottomViewView(TreeNode treeNode, int hd) {
        this.treeNode = treeNode;
        this.hd = hd;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree();
        //printTopView(root);
        printBottomView(root);
    }

    private static void printTopView(TreeNode root) {
        Queue<TreeTopAndBottomViewView> queue = new LinkedList<>();
        ArrayList arrayList =new ArrayList();
        queue.add(new TreeTopAndBottomViewView(root,0));
        while (!queue.isEmpty()){
            TreeTopAndBottomViewView treeTopView = queue.poll();
            if(!arrayList.contains(treeTopView.hd)) {
                System.out.println(treeTopView.treeNode.getData());
                arrayList.add(treeTopView.hd);
            }
            if(treeTopView.treeNode.getLeftNode() != null){
                queue.add(new TreeTopAndBottomViewView(treeTopView.treeNode.getLeftNode(),treeTopView.hd-1));
            }
            if(treeTopView.treeNode.getRightNode() != null ){
                queue.add(new TreeTopAndBottomViewView(treeTopView.treeNode.getRightNode(),treeTopView.hd+1));
            }
        }
    }

    private static void printBottomView(TreeNode root){
        Map<Integer,Integer> map = new HashMap<>();
        Queue<TreeTopAndBottomViewView> queue = new LinkedList<>();
        queue.add(new TreeTopAndBottomViewView(root,0));
        while (!queue.isEmpty()){
            TreeTopAndBottomViewView treeBottomView = queue.poll();
            map.put(treeBottomView.hd, treeBottomView.treeNode.getData());
            if(treeBottomView.treeNode.getLeftNode() != null){
                queue.add(new TreeTopAndBottomViewView(treeBottomView.treeNode.getLeftNode(),treeBottomView.hd-1));
            }
            if(treeBottomView.treeNode.getRightNode() != null ){
                queue.add(new TreeTopAndBottomViewView(treeBottomView.treeNode.getRightNode(),treeBottomView.hd+1));
            }
        }
        map.keySet().stream().forEach(x -> System.out.println(map.get(x)));
    }
}
