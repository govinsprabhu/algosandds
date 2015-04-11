package datastructure.linkedlist.doublelinkelist;

/**
 * Created by GPrabhu on 12/10/2014.
 */
public class DoubleLinkedList {
    private int value;
    private DoubleLinkedList leftLinkedList;
    private DoubleLinkedList rightLinkedList;

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleLinkedList(int value) {
        this.value = value;
    }

    public DoubleLinkedList() {
        this.leftLinkedList=null;
        this.rightLinkedList=null;
    }

    public DoubleLinkedList(int value, DoubleLinkedList leftLinkedList, DoubleLinkedList rightLinkedList) {
        this.value = value;
        this.leftLinkedList = leftLinkedList;
        this.rightLinkedList = rightLinkedList;
    }

    public void setLeftLinkedList(DoubleLinkedList leftLinkedList) {
        this.leftLinkedList = leftLinkedList;
    }

    public void setRightLinkedList(DoubleLinkedList rightLinkedList) {
        this.rightLinkedList = rightLinkedList;
    }

    public int getValue() {

        return  value;
    }

    public DoubleLinkedList getLeftLinkedList() {
        return leftLinkedList;
    }

    public DoubleLinkedList getRightLinkedList() {
        return rightLinkedList;
    }


}
