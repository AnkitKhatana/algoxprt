package stacks.medium;

import util.Utils;

import java.util.*;

public class BalancedBrackets {

    private static Set<Character> openingBracketSet = new HashSet<Character>() {{
        add('{');
        add('(');
        add('[');
    }};

    private static Map<Character,Character> closingBracketMap = new HashMap<Character,Character>() {{
        put('}','{');
        put(')','(');
        put(']','[');
    }};

    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Stack<Character> characterStack = new Stack<>();
        for(int i=0; i<str.length(); i++ ){
            Character c = str.charAt(i);
            if(openingBracketSet.contains(c))
                characterStack.push(c);
            else if(closingBracketMap.containsKey(c)){
                if(characterStack.isEmpty())
                    return false;
                else if (closingBracketMap.get(c) == characterStack.peek())
                    characterStack.pop();
                else
                    return false;
            }
        }
        return characterStack.isEmpty();
    }

    public static void main(String args[]) {
        String input = ")[](){}(())()()";
        String input1 = "([])(){}(())()()";
        String input2 = ")[]((){}(())()()";
        String input3 = "()()[{()})]";
        Utils.assertTrue(BalancedBrackets.balancedBrackets(input));
        Utils.assertTrue(BalancedBrackets.balancedBrackets(input1));
        Utils.assertTrue(BalancedBrackets.balancedBrackets(input2));
        Utils.assertTrue(BalancedBrackets.balancedBrackets(input3));
    }
}
