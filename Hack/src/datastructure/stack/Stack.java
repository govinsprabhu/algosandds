package datastructure.stack;

import java.util.ArrayList;

/**
 * Created by GPrabhu on 2/28/2015.
 */
public class Stack {
    ArrayList<Object> stack;
    int top;

    public Stack() {
        this.stack = new ArrayList<>();
        this.top = -1;
    }
    public int peek(){
        return  (int)stack.get(top);
    }
    public void push(Object n) {
        stack.add(n);
        top++;
    }

    public Object pop() {
        return stack.remove(top--);
    }
    public Boolean isEmpty(){
        return top==-1;
    }

}
