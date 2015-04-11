package datastructure.queue;

/**
 * Created by GPrabhu on 2/26/2015.
 */
public class Main {
    public static void main(String[] args) {
        Queue queue=new Queue(5);
        System.out.println(queue.pop_back());
        queue.push_back(1);
        queue.push_back(2);
        queue.push_back(3);
        queue.push_back(4);
        queue.push_back(5);
        queue.push_back(6);

        System.out.println(queue.pop_back());
        System.out.println(queue.pop_front());
    }
}
