package stacks.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStack1 {

    public void insertIntoSortedStack(ArrayList<Integer> stack, int top, int element){
        if(top == -1 || stack.get(top) < element)
            stack.add(top+1,element);
        else {
            int temp = stack.get(top);
            stack.remove(top);
            insertIntoSortedStack(stack,top-1,element);
            stack.add(top+1,temp);
        }
    }
    public void sortStackRecursive(ArrayList<Integer> stack , int top){
        if(top == -1)
            return;
        int temp=stack.get(top);
        stack.remove(top);
        sortStackRecursive(stack,top-1);
        insertIntoSortedStack(stack,top-1,temp);
    }
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // Write your code here.
        sortStackRecursive(stack,stack.size()-1);
        return stack;
    }

//    public void insertIntoSortedStack(ArrayList<Integer> stack, int element){
//        int top = stack.size()-1;
//        if(top == -1 || stack.get(top) < element)
//            stack.add(top+1,element);
//        else {
//            int temp = stack.get(top);
//            stack.remove(top);
//            insertIntoSortedStack(stack,element);
//            stack.add(top+1,temp);
//        }
//    }
//    public void sortStackRecursive(ArrayList<Integer> stack ){
//        if(stack.size()==0)
//            return;
//        int top = stack.size()-1;
//        int temp=stack.get(top);
//        stack.remove(top);
//        sortStackRecursive(stack);
//        insertIntoSortedStack(stack,temp);
//    }
//    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
//        // Write your code here.
//        sortStackRecursive(stack);
//        return stack;
//    }

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1));
        System.out.println(new SortStack1().sortStack(stack));
    }
}
