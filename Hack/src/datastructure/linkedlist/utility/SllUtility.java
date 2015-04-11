package datastructure.linkedlist.utility;

import datastructure.linkedlist.singlelinkedlist.SingleLinkedList;

/**
 * Created by GPrabhu on 3/7/2015.
 */
public class SllUtility {
    public static SingleLinkedList constructSingleLinkedList(){
        SingleLinkedList singleLinkedList1=new SingleLinkedList(1);
        SingleLinkedList singleLinkedList2=new SingleLinkedList(2);
        SingleLinkedList singleLinkedList3=new SingleLinkedList(3);
        SingleLinkedList singleLinkedList4=new SingleLinkedList(3);
        SingleLinkedList singleLinkedList5=new SingleLinkedList(2);
        SingleLinkedList singleLinkedList6=new SingleLinkedList(1);
        singleLinkedList1.setNext(singleLinkedList2);
        singleLinkedList2.setNext(singleLinkedList3);
        singleLinkedList3.setNext(singleLinkedList4);
        singleLinkedList4.setNext(singleLinkedList5);
        singleLinkedList5.setNext(singleLinkedList6);
        singleLinkedList6.setNext(null);
        return singleLinkedList1;
    }
    public static SingleLinkedList constructSingleLinkedListOdd(){
        SingleLinkedList singleLinkedList1=new SingleLinkedList(1);
        SingleLinkedList singleLinkedList2=new SingleLinkedList(3);
        SingleLinkedList singleLinkedList3=new SingleLinkedList(5);
        SingleLinkedList singleLinkedList4=new SingleLinkedList(7);
        SingleLinkedList singleLinkedList5=new SingleLinkedList(9);
        SingleLinkedList singleLinkedList6=new SingleLinkedList(11);
        singleLinkedList1.setNext(singleLinkedList2);
        singleLinkedList2.setNext(singleLinkedList3);
        singleLinkedList3.setNext(singleLinkedList4);
        singleLinkedList4.setNext(singleLinkedList5);
        singleLinkedList5.setNext(singleLinkedList6);
        singleLinkedList6.setNext(null);
        return singleLinkedList1;
    }
    public static SingleLinkedList constructSingleLinkedListEven(){
        SingleLinkedList singleLinkedList1=new SingleLinkedList(2);
        SingleLinkedList singleLinkedList2=new SingleLinkedList(4);
        SingleLinkedList singleLinkedList3=new SingleLinkedList(6);
        SingleLinkedList singleLinkedList4=new SingleLinkedList(8);
        SingleLinkedList singleLinkedList5=new SingleLinkedList(10);
        SingleLinkedList singleLinkedList6=new SingleLinkedList(12);
        singleLinkedList1.setNext(singleLinkedList2);
        singleLinkedList2.setNext(singleLinkedList3);
        singleLinkedList3.setNext(singleLinkedList4);
        singleLinkedList4.setNext(singleLinkedList5);
        singleLinkedList5.setNext(singleLinkedList6);
        singleLinkedList6.setNext(null);
        return singleLinkedList1;
    }
    public static void printSll(SingleLinkedList singleLinkedList){
        SingleLinkedList head=singleLinkedList;
        while (head!=null){
            System.out.print(head.getData()+"-->");
            head=head.getNext();
        }
    }

    public static SingleLinkedList constructSingleLinkedListOddWithOddSize() {
        SingleLinkedList singleLinkedList1=new SingleLinkedList(5);
        SingleLinkedList singleLinkedList2=new SingleLinkedList(3);
        SingleLinkedList singleLinkedList3=new SingleLinkedList(1);
        SingleLinkedList singleLinkedList4=new SingleLinkedList(2);
        SingleLinkedList singleLinkedList5=new SingleLinkedList(1);
        SingleLinkedList singleLinkedList6=new SingleLinkedList(3);
        SingleLinkedList singleLinkedList7=new SingleLinkedList(5);

        singleLinkedList1.setNext(singleLinkedList2);
        singleLinkedList2.setNext(singleLinkedList3);
        singleLinkedList3.setNext(singleLinkedList4);
        singleLinkedList4.setNext(singleLinkedList5);
        singleLinkedList5.setNext(singleLinkedList6);
        singleLinkedList6.setNext(singleLinkedList7);
        return singleLinkedList1;

    }
}
