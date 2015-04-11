package algorithms.payloads;

/**
 * Created by GPrabhu on 2/28/2015.
 */
public class PageObject {
    int dist1;
    int dist2;
    int dist;

    public PageObject() {
    }

    public void setDist1(int dist1) {
        this.dist1 = dist1;
    }

    public void setDist2(int dist2) {
        this.dist2 = dist2;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getDist1() {
        return dist1;
    }

    public int getDist2() {
        return dist2;
    }

    public int getDist() {
        return dist;
    }
}
