package datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GPrabhu on 3/17/2015.
 */
public class Graph {
    private Map<Integer, List<Integer>> vertices;


    public Map<Integer, List<Integer>> getVertices() {
        return vertices;
    }

    public Graph(int numberOfVertices) {
        this.vertices = new HashMap<>();
        for (int i = 1; i <= numberOfVertices; i++) {
            vertices.put(i, new ArrayList<>());
        }
    }

    public void setEdges(int source, int destination) {
        List list = vertices.get(source);
        list.add(destination);
    }

    public List getEdges(int vertex) {
        return vertices.get(vertex);
    }
}

