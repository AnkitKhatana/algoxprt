package stacks.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] array) {
        // Write your code here.
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex])
                maxIndex = i;
        }
        int[] output = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            int newIndex = (i + maxIndex + 1) % array.length;
            while (!stack.isEmpty() && array[stack.peek()] < array[newIndex]) {
                output[stack.pop()] = array[newIndex];
            }
            stack.push(newIndex);
        }
        while (!stack.isEmpty()) {
            output[stack.pop()] = -1;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, -3, -4, 6, 7, 2};
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement(array)));
    }
}
