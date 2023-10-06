package strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharactersForWords {

    public char[] minimumCharactersForWords(String[] words) {
        Map<Character,Integer> minCharFrequencyForAll = new HashMap<>();
        int minCharRequired=0;
        for(String word : words){
            char[] charArray = word.toCharArray();
            Map<Character,Integer> minCharFrequencyForCurrent = new HashMap<>(minCharFrequencyForAll);
            for(char c : charArray) {
                if (minCharFrequencyForCurrent.getOrDefault(c,0) > 0)
                    minCharFrequencyForCurrent.put(c,minCharFrequencyForCurrent.get(c)-1);
                else {
                    minCharFrequencyForAll.put(c, minCharFrequencyForAll.getOrDefault(c, 0) + 1);
                    minCharRequired++;
                }
            }
        }
        char[] minimumCharForWords = new char[minCharRequired];
        int index=0;
        for(Map.Entry<Character,Integer> entry : minCharFrequencyForAll.entrySet()){
            Character key = entry.getKey();
            Integer frequency = entry.getValue();
            while(frequency-- > 0){
                minimumCharForWords[index++] = key;
            }
        }

        return minimumCharForWords;
    }

    public static void main(String[] args) {
        String[] input = new String[] {"this", "that", "did", "deed", "them!", "a"};
        System.out.println(new MinimumCharactersForWords().minimumCharactersForWords(input));
    }
}
