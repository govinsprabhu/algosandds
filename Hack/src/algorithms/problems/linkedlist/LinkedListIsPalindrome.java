package algorithms.problems.linkedlist;

import datastructure.linkedlist.singlelinkedlist.SingleLinkedList;
import datastructure.linkedlist.utility.SllUtility;

/**
 * Created by GPrabhu on 3/7/2015.
 */
public class LinkedListIsPalindrome {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = SllUtility.constructSingleLinkedList();
        SllUtility.printSll(singleLinkedList);
        isPalindrome(singleLinkedList);
        SllUtility.printSll(singleLinkedList);
    }

    private static void isPalindrome(SingleLinkedList linkedList) {
        SingleLinkedList head=linkedList;
        SingleLinkedList slow = linkedList;
        SingleLinkedList fast = linkedList;
        SingleLinkedList previous_slow = null;
        while (fast!=null&&fast.getNext()!= null ) {
            previous_slow = slow;
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        SingleLinkedList median = null;
        if (fast != null) {

            median = slow;
            slow = slow.getNext();
        }
        previous_slow.setNext(null);
        SingleLinkedList reversed = reverse(slow);
        isPalindrome(linkedList, reversed);
        reversed= reverse(reversed);
        if (median != null) {
            previous_slow.setNext(median);
            median.setNext(reversed);
        } else {
            previous_slow.setNext(reversed);

        }
    }

    private static void isPalindrome(SingleLinkedList linkedList, SingleLinkedList reverse) {
        while (reverse != null && linkedList != null && reverse.getData() == linkedList.getData()) {
            linkedList = linkedList.getNext();
            reverse = reverse.getNext();
        }
        if (linkedList != null || linkedList != null) {

            System.out.println("Not palindrome");
            return;
        }
        System.out.println("palindrome");

    }

    private static SingleLinkedList reverse(SingleLinkedList linkedList) {
        SingleLinkedList previous = null;
        SingleLinkedList next = null;
        SingleLinkedList current = linkedList;
        while (current!= null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }


}
