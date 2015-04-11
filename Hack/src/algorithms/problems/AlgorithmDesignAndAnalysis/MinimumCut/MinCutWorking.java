package algorithms.problems.AlgorithmDesignAndAnalysis.MinimumCut;

import java.util.*;

/**
 * Created by GPrabhu on 11/9/2014.
 */
class Node {
    public int id;
    public LinkedList<Integer> nodeEdge;
}

// AdjacencyLists for graph
class AdjacencyLists {
    public int len = 200; // number of node
    public Hashtable<Integer, Node> nodeHash = new Hashtable();
    // add vertex(node),id from 1

    public void addVertex(int id) {
        Node node = new Node();
        node.id = id; // from index of 0
        node.nodeEdge = new LinkedList();
        nodeHash.put(id, node);
        HashMap hashMap =new HashMap();
        hashMap.keySet();

        List<Integer> lists= new ArrayList<>();
        List<Integer> sample =new ArrayList<>();
        LinkedList linkedList = new LinkedList();
        


    }

    public void addAdjvex(int start, int end) {
        nodeHash.get(start).nodeEdge.addLast(end);
    }

    public int getAdjvex(int node, int index) {
        return nodeHash.get(node).nodeEdge.get(index);
    }

    public void contractVertex(int nodeA, int nodeB) {
        deleteEdge(nodeA, nodeB); // delete the edge nodeB in nodeA
        findEnd(nodeA, nodeB); // change nodeB to a in node change
        addList(nodeA, nodeB); // add nodeB in the last of nodeA
        nodeHash.remove(nodeB);// remove nodeB
    }

    // delete edge,number of edge need be changed is >=1, even >2...
    public void deleteEdge(int nodeA, int nodeB) {
        while (nodeHash.get(nodeA).nodeEdge.contains(nodeB)) {
            int index = nodeHash.get(nodeA).nodeEdge.indexOf(nodeB);
            nodeHash.get(nodeA).nodeEdge.remove(index);
//                        print(nodeA);
        }
        while (nodeHash.get(nodeB).nodeEdge.contains(nodeA)) {
            int index = nodeHash.get(nodeB).nodeEdge.indexOf(nodeA);
            nodeHash.get(nodeB).nodeEdge.remove(index);
//                        print(nodeB);
        }
    }

    public void findEnd(int nodeA, int nodeB) {
        boolean record[] = new boolean[len];// check the node which has been changed yet
        for (int index = 0; index < nodeHash.get(nodeB).nodeEdge.size(); index++) {
            int change = nodeHash.get(nodeB).nodeEdge.get(index);
            if (record[change-1] == false) {
                changeToEnd(nodeA, nodeB, change);
                record[change-1] = true;
            }
        }
    }

    public void changeToEnd(int nodeA, int nodeB, int change) {
        for (int index = 0; index < nodeHash.get(change).nodeEdge.size(); index++) {
            if (nodeHash.get(change).nodeEdge.get(index) == nodeB) {
                nodeHash.get(change).nodeEdge.set(index, nodeA);
            }
        }
    }

    public void addList(int nodeA, int nodeB) {
        while (!nodeHash.get(nodeB).nodeEdge.isEmpty()) {
            nodeHash.get(nodeA).nodeEdge.addLast(nodeHash.get(nodeB).nodeEdge
                    .pop());
        }
//                print(nodeA);
    }

    // computer the edge number of nodeHash.get(0)
    public int computerEdge(int node) {
        int n = nodeHash.get(node).nodeEdge.size();
        return n;
    }

    // print edges of nodeA, for datastructure
    public void print(int nodeA) {
        if (!nodeHash.get(nodeA).nodeEdge.isEmpty()) {
            System.out.print("[" + nodeA + "]:");
            for (int index = 0; index < nodeHash.get(nodeA).nodeEdge.size(); index++) {
                System.out.print(nodeHash.get(nodeA).nodeEdge.get(index) + "-");
            }
            System.out.println();
        }
    }
}
