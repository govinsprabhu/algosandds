/*
package algorithms.problems.crakingthecoding.linkedlist;

*/
/**
 * Created by GPrabhu on 12/10/2014.
 *//*

public class CountingSum {
    public static void main(String[] args) {
        LinkedListNode linkedListNode1=new LinkedListNode(1);
        LinkedListNode head=linkedListNode1;
        LinkedListNode linkedListNode2=new LinkedListNode(2);
        LinkedListNode linkedListNode3=new LinkedListNode(3);
        head.node=linkedListNode2;
        linkedListNode2.node=linkedListNode3;
        linkedListNode3.node=null;
        //printLinkedListNode(linkedListNode1);
        LinkedListNode linkedListNode4=new LinkedListNode(7);
        LinkedListNode linkedListNode5=new LinkedListNode(8);
        LinkedListNode linkedListNode6=new LinkedListNode(9);
        linkedListNode4.node=linkedListNode5;
        linkedListNode5.node=linkedListNode6;
        linkedListNode6.node=null;
        //printLinkedListNode(linkedListNode4);

        LinkedListNode result=addToList(linkedListNode1, linkedListNode4,0);
        printLinkedListNode(result);

    }

    private static void printLinkedListNode( LinkedListNode result) {
        LinkedListNode nextNode=result;
        while(nextNode!=null){
            System.out.println(nextNode.value);
            nextNode=nextNode.node;
        }
    }

    private static LinkedListNode addToList(LinkedListNode linkedListNode1, LinkedListNode linkedListNode4, int carry) {

        int value=carry;
        if(linkedListNode1==null&&linkedListNode4==null &&carry==1){
            return new LinkedListNode(1);
        }
        else if(linkedListNode1==null && linkedListNode4==null)
        {
            return null;
        }
        if(linkedListNode1!=null){
            value+=linkedListNode1.value;
        }
        if(linkedListNode4!=null){
            value+=linkedListNode4.value;
        }
        LinkedListNode result=new LinkedListNode(value%10);
        LinkedListNode nextNode=addToList(linkedListNode1==null?null:linkedListNode1.node,linkedListNode4==null?null:linkedListNode4.node, value>=10?1:0);
        result.node=nextNode;
        return result;
    }
}
*/
