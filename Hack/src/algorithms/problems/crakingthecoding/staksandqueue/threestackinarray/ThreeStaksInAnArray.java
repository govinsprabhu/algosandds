package algorithms.problems.crakingthecoding.staksandqueue.threestackinarray;

/**
 * Created by GPrabhu on 12/11/2014.
 */
public class ThreeStaksInAnArray {
    private int index;
    private int[] stackPointer;
    private int lastIndex;
    private int[] stack;
    private static StackNode[] stackNodes = new StackNode[300];

    public ThreeStaksInAnArray() {
        this.index = 0;
        this.stackPointer = new int[]{-1, -1, -1};
        this.lastIndex = -1;
    }

    public static void main(String[] args) {
        ThreeStaksInAnArray threeStaksInAnArray = new ThreeStaksInAnArray();
        threeStaksInAnArray.push(0, 1);
        threeStaksInAnArray.push(1, 2);
        threeStaksInAnArray.push(2, 3);
        threeStaksInAnArray.push(0, 4);
        threeStaksInAnArray.push(2, 5);
        threeStaksInAnArray.push(1, 6);
        threeStaksInAnArray.push(0, 7);
        threeStaksInAnArray.push(2,17);
        threeStaksInAnArray.push(1,8);
        threeStaksInAnArray.push(0,21);
        System.out.println(stackNodes.length);
        System.out.println(threeStaksInAnArray.pop(1).value);
        System.out.println(threeStaksInAnArray.pop(1).value);
    }

    public void push(int stackNumber, int value) {
        int lastIndex = stackPointer[stackNumber];
        stackNodes[index] = new StackNode(value, lastIndex);
        stackPointer[stackNumber] = index;
        index++;
    }

    public StackNode pop(int stackNumber) {
        int lastIndex = stackPointer[stackNumber];
        stackPointer[stackNumber] = stackNodes[lastIndex].previous;
        StackNode number = stackNodes[lastIndex];
        stackNodes[lastIndex] = null;
        index--;
        return number;
    }
}
