package algorithms.problems.AlgorithmDesignAndAnalysis.dijkstra;

import java.util.ArrayList;

/**
 * Created by GPrabhu on 11/22/2014.
 */
public class VertexNew {
    int id;
    int distance;
    boolean isExplored;
    ArrayList<EdgeNew> edge;

    public VertexNew(int id, int distance) {
        this.id = id;
        this.distance = distance;
        edge=new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setExplored(boolean isExplored) {
        this.isExplored = isExplored;
    }

    public void setEdge(ArrayList<EdgeNew> edge) {
        this.edge = edge;
    }

    public int getId() {
        return id;

    }

    public int getDistance() {
        return distance;
    }

    public boolean isExplored() {
        return isExplored;
    }

    public ArrayList<EdgeNew> getEdge() {
        return edge;
    }
}
