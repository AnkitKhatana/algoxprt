package stacks.medium;

import util.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

    public int reversePolishNotation(String[] tokens) {
        // Write your code here.
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "*":
                    int operand1 = Integer.parseInt(stack.pop());
                    int operand2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(operand1 * operand2));
                    break;
                case "+":
                    operand1 = Integer.parseInt(stack.pop());
                    operand2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(operand1 + operand2));
                    break;
                case "-":
                    operand1 = Integer.parseInt(stack.pop());
                    operand2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(operand2 - operand1));
                    break;
                case "/":
                    operand1 = Integer.parseInt(stack.pop());
                    operand2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(operand2 / operand1));
                    break;
                default:
                    stack.push(token);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String args[]) {
//        String[] input = new String[] {"3", "2", "+", "7", "*"};
//        int expected = 35;
//        int actual = new ReversePolishNotation().reversePolishNotation(input);
//        System.out.println(actual);
//        Utils.assertTrue(expected == actual);
        String[] input1 = new String[]{"50", "3", "17", "+", "2", "-", "/"};
        int expected1 = 2;
        int actual1 = new ReversePolishNotation().reversePolishNotation(input1);
        System.out.println(actual1);
        Utils.assertTrue(expected1 == actual1);
    }
}
