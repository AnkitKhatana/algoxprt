package stacks.medium;

import util.Utils;

public class MinMaxStackConstruction {
    static class MinMaxStack {
        private int[] array = new int[1000];
        private int stackTop=-1;
        private int[] minElement = new int[1000];
        private int[] maxElement = new int[1000];
        public int peek() {
            // Write your code here.
            if(stackTop == -1)
                return -1;
            else
                return array[stackTop];
        }

        public int pop() {
            // Write your code here.
            if(stackTop == -1)
                return -1;
            else {
                return array[stackTop--];
            }
        }

        public void push(Integer number) {
            // Write your code here.
            if(stackTop == 999)
                System.out.println("Stack full");
            else {
                array[++stackTop] = number;
                int minElementIndex = stackTop == 0 ? stackTop : (number < array[minElement[stackTop-1]] ? stackTop : minElement[stackTop-1]);
                int maxElementIndex = stackTop == 0 ? stackTop : (number > array[maxElement[stackTop-1]] ? stackTop : maxElement[stackTop-1]);
                minElement[stackTop] = minElementIndex;
                maxElement[stackTop] = maxElementIndex;
            }
        }

        public int getMin() {
            // Write your code here.
            return array[minElement[stackTop]];
        }

        public int getMax() {
            // Write your code here.
            return array[maxElement[stackTop]];
        }
    }

    public static void testMinMaxPeek(int min, int max, int peek, MinMaxStackConstruction.MinMaxStack stack) {
        System.out.println(stack.getMin());
        Utils.assertTrue(stack.getMin() == min);
        System.out.println(stack.getMax());
        Utils.assertTrue(stack.getMax() == max);
        System.out.println(stack.peek());
        Utils.assertTrue(stack.peek() == peek);
    }


    public static void main(String args[]) {
        MinMaxStackConstruction.MinMaxStack stack = new MinMaxStackConstruction.MinMaxStack();
        stack.push(5);
        testMinMaxPeek(5, 5, 5, stack);
        stack.push(7);
        testMinMaxPeek(5, 7, 7, stack);
        stack.push(2);
        testMinMaxPeek(2, 7, 2, stack);
        Utils.assertTrue(stack.pop() == 2);
        Utils.assertTrue(stack.pop() == 7);
        testMinMaxPeek(5, 5, 5, stack);
    }
}
