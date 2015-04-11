package algorithms.problems.linkedlist;

import datastructure.linkedlist.singlelinkedlist.SingleLinkedList;
import datastructure.linkedlist.utility.SllUtility;

/**
 * Created by GPrabhu on 3/23/2015.
 */
public class SortingTwoLinkedListInPlace {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList1 = SllUtility.constructSingleLinkedListOdd();
        SingleLinkedList singleLinkedList2 = SllUtility.constructSingleLinkedListEven();
        SingleLinkedList start = null;
        SingleLinkedList end = null;
        start =  merge(singleLinkedList1, singleLinkedList2, start, end);
        SllUtility.printSll(start);
    }

    private static SingleLinkedList merge(SingleLinkedList list1, SingleLinkedList list2, SingleLinkedList start, SingleLinkedList end) {
        while (list1 != null && list2 != null) {

            if (list1.getData() < list2.getData()) {
                if (start == null) {
                    end = start = list1;


                } else {
                    end.setNext(list1);
                    end = end.getNext();
                }
                list1 = list1.getNext();
            } else {
                if (start == null) {
                    end = start = list2;


                } else {
                    end.setNext(list2);
                    end = end.getNext();
                }
                list2 = list2.getNext();
            }
        }
        if (list1 == null) {
            end.setNext(list2);

        }
        if (list2 == null) {
            end.setNext(list1);
        }
        return start;
    }
}

