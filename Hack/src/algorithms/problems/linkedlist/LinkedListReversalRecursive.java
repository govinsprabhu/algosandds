package algorithms.problems.linkedlist;

import datastructure.linkedlist.singlelinkedlist.SingleLinkedList;
import datastructure.linkedlist.utility.SllUtility;

/**
 * Created by GPrabhu on 3/21/2015.
 */
public class LinkedListReversalRecursive {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = SllUtility.constructSingleLinkedList();
        SingleLinkedList head = reverse(singleLinkedList);
        while (head != null){
            System.out.println(head.getData());
            head = head.getNext();
        }
    }

    private static SingleLinkedList reverse(SingleLinkedList singleLinkedList) {
        if (singleLinkedList.getNext() == null) {
            return singleLinkedList;
        }
        SingleLinkedList head = reverse(singleLinkedList.getNext());
        SingleLinkedList q = singleLinkedList.getNext();
        q.setNext(singleLinkedList);
        singleLinkedList.setNext(null);
        return head;
    }
}
