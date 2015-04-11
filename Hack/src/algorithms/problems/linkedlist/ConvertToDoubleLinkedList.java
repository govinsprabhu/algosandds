package algorithms.problems.linkedlist;

import algorithms.problems.linkedlist.payload.WrapperDll;
import datastructure.linkedlist.doublelinkelist.DoubleLinkedList;
import datastructure.linkedlist.utility.DllUtility;

/**
 * Created by GPrabhu on 3/23/2015.
 */
public class ConvertToDoubleLinkedList {
    public static void main(String[] args) {

        DoubleLinkedList root = new DoubleLinkedList(10);
        DoubleLinkedList DoubleLinkedList2 = new DoubleLinkedList(8);
        DoubleLinkedList DoubleLinkedList3 = new DoubleLinkedList(12);
        DoubleLinkedList DoubleLinkedList4 = new DoubleLinkedList(4, null, null);
        DoubleLinkedList DoubleLinkedList5 = new DoubleLinkedList(9, null, null);
        DoubleLinkedList DoubleLinkedList6 = new DoubleLinkedList(11, null, null);
        DoubleLinkedList DoubleLinkedList7 = new DoubleLinkedList(14, null, null);

        root.setLeftLinkedList(DoubleLinkedList2);
        root.setRightLinkedList(DoubleLinkedList3);
        DoubleLinkedList2.setLeftLinkedList(DoubleLinkedList4);
        DoubleLinkedList2.setRightLinkedList(DoubleLinkedList5);
        DoubleLinkedList3.setLeftLinkedList(DoubleLinkedList6);
        DoubleLinkedList3.setRightLinkedList(DoubleLinkedList7);


        WrapperDll wrapperDll = new WrapperDll();
        toDoubleLinkedList(root, wrapperDll);

        DllUtility.printDoubleLinkedList(wrapperDll.head);

    }

    private static void toDoubleLinkedList(DoubleLinkedList root, WrapperDll wrapperDll) {
        if (root == null) {
            return;
        }

        toDoubleLinkedList(root.getLeftLinkedList(), wrapperDll);
        if (wrapperDll.previous == null) {
            wrapperDll.head = root;
        } else {
            wrapperDll.previous.setRightLinkedList(root);
            root.setLeftLinkedList(wrapperDll.previous);
        }

        wrapperDll.previous = root;
        toDoubleLinkedList(root.getRightLinkedList(), wrapperDll);
        return;
    }


}
