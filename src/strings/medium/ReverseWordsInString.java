package strings.medium;

import java.util.Arrays;

public class ReverseWordsInString {

    public enum State {WHITESPACE , NONWHITESPACE}
    private State state;
    private int iterator;

    public String extractNextBlock(char[] string ){
        int end=iterator, start;
        if(state==State.WHITESPACE){
            while(iterator>=0 && string[iterator] == ' ')
                iterator--;
            state=State.NONWHITESPACE;
        }
        else {
            while(iterator>=0 && string[iterator] != ' ')
                iterator--;
            state=State.WHITESPACE;
        }
        start = iterator+1;
        char[] block = new char[end-start+1];
        int i=0;
        while (start <= end)
            block[i++] =string[start++];
        return new String(block);
    }

    public String reverseWordsInString(String string) {
        // Write your code here.
        if(string.length() == 0)
            return "";

        StringBuffer sb = new StringBuffer();
        char[] input = string.toCharArray();
        int length=string.length();
        iterator=length-1;

        if(input[iterator] == ' ')
            state=State.WHITESPACE;
        else
            state=State.NONWHITESPACE;

        while(iterator>=0){
            String nextBlock = extractNextBlock(input);
            sb.append(nextBlock);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "tim is great";
        String input2 = "whitespaces    4";
        String input = "Algoexpert is the best!";

        System.out.println(new ReverseWordsInString().reverseWordsInString(input));
    }
}
