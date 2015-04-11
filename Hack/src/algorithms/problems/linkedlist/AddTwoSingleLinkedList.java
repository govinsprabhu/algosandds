package algorithms.problems.linkedlist;

import datastructure.linkedlist.singlelinkedlist.SingleLinkedList;
import datastructure.linkedlist.utility.SllUtility;

/**
 * Created by GPrabhu on 3/8/2015.
 */
public class AddTwoSingleLinkedList{

    public static void main(String args[]){
        SingleLinkedList sll1= SllUtility.constructSingleLinkedListOdd();
        SingleLinkedList sll2=SllUtility.constructSingleLinkedListEven();
        SingleLinkedList merge=merge(sll1,sll2);
        SllUtility.printSll(merge);

    }
    private static SingleLinkedList merge(SingleLinkedList sll1,SingleLinkedList sll2){
        if(sll1==null){
            return sll2;
        }
        if(sll2==null){
            return sll1;
        }
        SingleLinkedList result = null;
        if(sll1.getData()<sll2.getData()){
            result=sll1;
            result.setNext(merge(sll1.getNext(),sll2));
        }
        else if(sll2.getData()<sll1.getData()){
            result=sll2;
            result.setNext(merge(sll1,sll2.getNext()));
        }
        return result;
    }
}