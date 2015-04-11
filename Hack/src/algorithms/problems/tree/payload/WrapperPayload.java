package algorithms.problems.tree.payload;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class WrapperPayload {

    private int maxValue;

    public int getKthNode() {
        return kthNode;
    }

    public void setKthNode(int kthNode) {
        this.kthNode = kthNode;
    }

    public WrapperPayload() {
        maxValue=0;

    }
    public void decrementCount(){
        kthNode--;
    }

    private int kthNode;


    public WrapperPayload(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
