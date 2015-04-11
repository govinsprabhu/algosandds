package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue queue=new LinkedList<>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.remove());


    }

}
