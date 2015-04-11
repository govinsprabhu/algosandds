package datastructure.queue;

public class Queue {
    private int rear;
    private int front;
    private int a[];
    private int n;


    public Queue(int n) {
        this.n = n;
        a=new int[n];
        front = rear = -1;
    }
    public int getFront(){
        return a[front];
    }

    public void push_back(int value) {
        if (rear == n-1) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        a[++rear] = value;
    }

    public int pop_front() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = a[front++];
        if (front == rear) {
            front = rear = -1;
        }
        return value;
    }
    public boolean isEmpty(){
        return front==-1?true:false;
    }
    public  int back(){
        return a[rear];
    }
    public int pop_back() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value= a[rear--];
        if(rear==front){
            rear=front=-1;
        }
        return value;
    }

}