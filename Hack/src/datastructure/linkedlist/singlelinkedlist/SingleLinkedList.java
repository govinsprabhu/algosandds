package datastructure.linkedlist.singlelinkedlist;

/**
 * Created by GPrabhu on 3/7/2015.
 */
public class SingleLinkedList {
    int data;
    SingleLinkedList next;

    public SingleLinkedList() {
    }

    public SingleLinkedList(int data, SingleLinkedList next) {
        this.data = data;
        this.next = next;
    }

    public SingleLinkedList(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(SingleLinkedList next) {
        this.next = next;
    }

    public SingleLinkedList getNext() {
        return next;
    }


}
