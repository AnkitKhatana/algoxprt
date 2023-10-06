package stacks.medium;

import util.Utils;

import java.util.Stack;


public class BestDigits {
    public String bestDigits(String number, int numDigits) {
        // Write your code here.
        Stack<Character> characterStack = new Stack<>();
        for(int i=0; i<number.length(); i++){
            while(!characterStack.isEmpty() && characterStack.peek() < number.charAt(i) && numDigits > 0){
                characterStack.pop();
                numDigits--;
            }
            characterStack.push(number.charAt(i));
        }
        while(numDigits-- >0)
            characterStack.pop();
        char[] characterArray = new char[characterStack.size()];
        for(int i=characterStack.size()-1; i>=0; i--){
            characterArray[i] = characterStack.pop();
        }
        return new String(characterArray);
    }

    public static void main(String[] args) {
        String number = "462839";
        int numDigits = 2;
        String expected = "6839";
        String actual = new BestDigits().bestDigits(number, numDigits);
        System.out.println(actual);
        Utils.assertTrue(expected.equals(actual));

        String number1 = "22";
        int numDigits1 = 1;
        String expected1 = "2";
        String actual1 = new BestDigits().bestDigits(number1, numDigits1);
        System.out.println(actual1);
        Utils.assertTrue(expected1.equals(actual1));
    }
}
