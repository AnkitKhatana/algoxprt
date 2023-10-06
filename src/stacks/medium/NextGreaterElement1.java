package stacks.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] array) {
        // Write your code here.
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex])
                maxIndex = i;
        }
        int[] output = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = array.length-1; i >= 0; i--) {
            int newIndex = (i + maxIndex + 1)%array.length;
            while (!stack.isEmpty() && stack.peek() <= array[newIndex])
                stack.pop();
            output[newIndex] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[newIndex]);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, -3, -4, 6, 7, 2};
        System.out.println(Arrays.toString(new NextGreaterElement1().nextGreaterElement(array)));
    }
}
