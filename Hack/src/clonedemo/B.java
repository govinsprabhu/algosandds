package clonedemo;

/**
 * Created by GPrabhu on 3/22/2015.
 */
public class B implements Cloneable {

    private String s;


    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
