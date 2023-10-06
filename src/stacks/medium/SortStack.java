package stacks.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStack {
    public void insertIntoStack(Stack<Integer> stack,Integer newElement){
        if(stack.isEmpty() || newElement > stack.peek())
            stack.push(newElement);
        else {
            Integer temp = stack.pop();
            insertIntoStack(stack,newElement);
            stack.push(temp);
        }
    }
    public void sortStackRecursive(Stack<Integer> stack){
        if(stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        sortStackRecursive(stack);
        insertIntoStack(stack,temp);
    }
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // Write your code here.
        Stack<Integer> stackCustom = new Stack<>();
        stackCustom.addAll(stack);
        sortStackRecursive(stackCustom);
        return new ArrayList<>(stackCustom);
    }

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1));
        System.out.println(new SortStack().sortStack(stack));
    }
}
