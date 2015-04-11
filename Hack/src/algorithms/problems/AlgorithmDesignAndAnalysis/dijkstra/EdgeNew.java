package algorithms.problems.AlgorithmDesignAndAnalysis.dijkstra;

/**
 * Created by GPrabhu on 11/22/2014.
 */
public class EdgeNew {
    int distance;
    int id;

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;

    }

    public int getId() {
        return id;
    }

    public EdgeNew(int distance, int id) {
        this.distance = distance;
        this.id = id;
    }
}
