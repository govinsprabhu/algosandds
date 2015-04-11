package clonedemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GPrabhu on 3/22/2015.
 */
public class Demo {

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A();
        List<B> list = new ArrayList<>();
        for (int i=0;i<=10;i++){
            B b = new B();
            b.setS("Name"+i);
        }
        a.setList(list);
        A clonedObj =(A) a.clone();
        System.out.println(clonedObj);
        List<B> cloBList = clonedObj.getList();
        assert !a.equals(clonedObj);
        for(int i=0;i<=10;i++ ){
            assert (list.get(i).equals(cloBList.get(i)));
        }
    }
}
