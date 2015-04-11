package algorithms.problems.linkedlist;

import datastructure.linkedlist.singlelinkedlist.SingleLinkedList;
import datastructure.linkedlist.utility.SllUtility;

/**
 * Created by GPrabhu on 3/22/2015.
 */
public class LinkListPalindromeRecursive {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = SllUtility.constructSingleLinkedList();
        System.out.println(isPalindrome(singleLinkedList, 6).success);

    }


    private static WrapperNode isPalindrome(SingleLinkedList singleLinkedList, int length) {
        if (length == 2) {
            return new WrapperNode(singleLinkedList.getNext().getNext(), singleLinkedList.getData() == singleLinkedList.getNext().getData());
        } else if (length == 1) {
            return new WrapperNode(singleLinkedList.getNext(), true);
        } else {
            WrapperNode node = isPalindrome(singleLinkedList.getNext(), length - 2);
            System.out.println("============"+node.success);
            if (!node.success) {
                return node;
            }
            boolean success = singleLinkedList.getData() == node.singleLinkedList.getData();
            return new WrapperNode(node.singleLinkedList.getNext(), success);
        }
    }
    private static class WrapperNode {
        public SingleLinkedList singleLinkedList;
        public boolean success;

        public WrapperNode(SingleLinkedList next, boolean b) {
            this.singleLinkedList = next;
            this.success = b;
        }
    }
    private static class WrapperNodeOther{
        public SingleLinkedList node;
        public boolean isEven;
    }
}
