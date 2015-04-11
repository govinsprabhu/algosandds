package algorithms.problems.graph;

import datastructure.graph.Graph;

import java.util.List;
import java.util.Stack;

/**
 * Created by GPrabhu on 3/17/2015.
 */
public class TopologicalSort {
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Graph directedGraph = new Graph(5);
        directedGraph.setEdges(1,5);
        directedGraph.setEdges(5, 2);
        directedGraph.setEdges(4, 1);
        directedGraph.setEdges(4, 2);
        directedGraph.setEdges(2, 1);
        directedGraph.setEdges(2, 1);
        printTopologicalSort(directedGraph);
    }

    private static void printTopologicalSort(Graph directedGraph) {
        int noOfVertex = directedGraph.getVertices().size();
        boolean[] visited = new boolean[noOfVertex+1];
        for (int index = 1; index <= noOfVertex; index++) {
            if (visited[index] == false) {
                topologicalSort(directedGraph, visited, index);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    private static void topologicalSort(Graph directedGraph, boolean[] visited, int index) {
        visited[index] = true;
        List<Integer> list = directedGraph.getEdges(index);
        if(list!=null) {
            for (int adjacentVertex : list) {
                if (!visited[adjacentVertex])
                    topologicalSort(directedGraph, visited, adjacentVertex);
            }
        }
        stack.push(index);

    }
}
