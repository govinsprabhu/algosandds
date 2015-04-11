package datastructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GPrabhu on 2/26/2015.
 */
public class ListQueue {
    private int rear;
    private int front;
    private List<Object> list;

    public ListQueue() {
        list = new ArrayList<>();
        front = rear = -1;
    }

    public int getFront() {
        return (int) list.get(front);
    }

    public void push_back(int value) {
        if (front == -1) {
            front = 0;
        }
        ++rear;
        list.add(value);
    }

    public Object pop_front() {
        if(front==-1){
            System.out.println("Queue is empty");
            return -1;
        }

        Object value = list.remove(front);
        if (front == rear) {
            front = rear = -1;
        }
        else {
            rear--;
        }
        return value;
    }

    public boolean isEmpty() {
        return front == -1 ? true : false;
    }

    public Object back() {
        return list.get(rear);
    }

    public Object pop_back() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        Object value = list.remove(rear);
        if (rear == front) {
            rear = front = -1;
        }else {
            rear--;
        }
        return value;
    }
}
