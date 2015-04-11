package datastructure.linkedlist.utility;

import datastructure.linkedlist.doublelinkelist.DoubleLinkedList;

/**
 * Created by GPrabhu on 3/7/2015.
 */
public class DllUtility {
    public  static DoubleLinkedList constructDoubleLinkedList(){
        DoubleLinkedList doubleLinkedList1=new DoubleLinkedList(1);
        DoubleLinkedList doubleLinkedList2=new DoubleLinkedList(2);
        DoubleLinkedList doubleLinkedList3=new DoubleLinkedList(3);
        DoubleLinkedList doubleLinkedList4=new DoubleLinkedList(4);
        DoubleLinkedList doubleLinkedList5=new DoubleLinkedList(5);
        doubleLinkedList1.setLeftLinkedList(null);
        doubleLinkedList1.setRightLinkedList(doubleLinkedList2);
        doubleLinkedList2.setLeftLinkedList(doubleLinkedList1);
        doubleLinkedList2.setRightLinkedList(doubleLinkedList3);
        doubleLinkedList3.setLeftLinkedList(doubleLinkedList2);
        doubleLinkedList3.setRightLinkedList(doubleLinkedList4);
        doubleLinkedList4.setLeftLinkedList(doubleLinkedList3);
        doubleLinkedList4.setRightLinkedList(doubleLinkedList5);
        doubleLinkedList5.setLeftLinkedList(doubleLinkedList4);
        doubleLinkedList5.setRightLinkedList(null);
        return doubleLinkedList1;
    }

    public static void printDoubleLinkedList(DoubleLinkedList doubleLinkedList){
        while (doubleLinkedList != null){
            System.out.println(doubleLinkedList.getValue()+"-->");
            doubleLinkedList = doubleLinkedList.getRightLinkedList();
        }
    }


}
