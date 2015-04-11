package algorithms.problems.string;

import datastructure.linkedlist.doublelinkelist.DoubleLinkedList;

/**
 * Created by GPrabhu on 3/1/2015.
 */
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String string = "etesmst";
        //printFirstNonRepeatingCharacter(string);
        DoubleLinkedList linkedListNode=null;

        printFirstNonRepeatingCharacterUsingLinkedList(string, linkedListNode);
    }

    private static void printFirstNonRepeatingCharacterUsingLinkedList(String string, DoubleLinkedList linkedListNodeHead) {
        boolean[] isRepeating = new boolean[256];
        DoubleLinkedList[] linkedListNodes = new DoubleLinkedList[256];
        int[] a = new int[256];
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (!isRepeating[character]) {
                if (linkedListNodes[character] == null) {
                    DoubleLinkedList linkedListNode = new DoubleLinkedList();
                    linkedListNode.setValue(character);
                    linkedListNodeHead=addToTheEnd(linkedListNodeHead, linkedListNode);
                    linkedListNodes[character] = linkedListNodeHead;
                } else {

                   linkedListNodeHead= removeLinkedList(linkedListNodeHead, linkedListNodes[character]);
                    isRepeating[character] = true;
                    linkedListNodes[character]=null;
                }
            }
            if (linkedListNodeHead != null) {
                System.out.println(linkedListNodeHead.getValue());
            }
        }


    }

    private static DoubleLinkedList removeLinkedList(DoubleLinkedList linkedListNodeHead, DoubleLinkedList linkedListNode) {

        if(linkedListNode.getRightLinkedList()==null){
            DoubleLinkedList linkedListNode1=linkedListNode.getLeftLinkedList();
            linkedListNode1.setRightLinkedList(null);
        }
        else if(linkedListNode.getLeftLinkedList()==null){
            linkedListNodeHead=linkedListNode.getRightLinkedList();
            linkedListNodeHead.setLeftLinkedList(null);

        }
        else  {
            DoubleLinkedList linkedListNode1 = linkedListNode.getLeftLinkedList();
            linkedListNode1.setRightLinkedList(linkedListNode.getRightLinkedList());
            linkedListNode.getRightLinkedList().setLeftLinkedList(linkedListNode1);
        }
        return linkedListNodeHead;
    }

    private static DoubleLinkedList addToTheEnd(DoubleLinkedList linkedListNodeHead, DoubleLinkedList linkedListNode) {
        if (linkedListNodeHead == null) {
            linkedListNodeHead = linkedListNode;
            return linkedListNodeHead;
        }
        DoubleLinkedList linkedListNode1 = linkedListNodeHead;
        while (linkedListNode1.getRightLinkedList() != null) {
            linkedListNode1 = linkedListNode1.getRightLinkedList();
        }
        linkedListNode1.setRightLinkedList(linkedListNode);
        linkedListNode.setLeftLinkedList(linkedListNode1);
        return linkedListNodeHead;
    }

    private static void printFirstNonRepeatingCharacter(String string) {
        int[] count = new int[256];
        for (int i = 0; i < string.length(); i++) {
            count[string.charAt(i)]++;

        }
        for (int i = 0; i < string.length(); i++) {
            if (count[string.charAt(i)] == 1) {
                System.out.println("First non repeating character is: " + string.charAt(i));
                return;
            }
        }
    }
}
