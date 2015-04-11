/*
package datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

*/
/**
 * Created by GPrabhu on 3/17/2015.
 *//*

public class DirectedGraph {

    private HashMap<Integer, LinkedList> hashMap = new HashMap<>();

    public List<Vertex> getVertices() {
        return vertices;
    }

    private List<Vertex> vertices;

    public DirectedGraph() {
        vertices = new ArrayList<>();
    }

    public HashMap<Integer, LinkedList> getHashMap() {
        return hashMap;
    }

    public void addVertex(int vertexData) {
        Vertex vertex = new Vertex(vertexData);
        vertices.add(vertex);
        hashMap.put(vertexData, vertex.getAdjacentVertex());
    }

    public void addAdjacentVertex(int vertex, int adjacentVertex) {
        LinkedList linkedList = hashMap.get(vertex);
        linkedList.addLast(adjacentVertex);
    }

    public void addVertices(int[] vertices) {
        for (int count = 0; count < vertices.length; count++) {
            addVertex(vertices[count]);
        }
    }

    public void addAdjacentVertices(int vertex, int[] adjacentVertices) {
        for (int count = 0; count < adjacentVertices.length; count++) {
            addAdjacentVertex(vertex, adjacentVertices[count]);
        }
    }

}
*/
