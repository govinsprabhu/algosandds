package clonedemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GPrabhu on 3/22/2015.
 */

public class A implements Cloneable  {
    public List<B> getList() {
        return list;
    }

    public void setList(List<B> list) {
        this.list = list;
    }

    private List<B> list;



    @Override
    protected Object clone() throws CloneNotSupportedException {

        A a = new A();
        List<B> list = new ArrayList<>();
        for(B b : list){
            list.add((B)b.clone());
        }
        a.list = list;
        return a;
    }
}
