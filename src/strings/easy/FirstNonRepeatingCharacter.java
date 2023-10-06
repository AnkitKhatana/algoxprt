package strings.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character,Integer> frequencyMap = new LinkedHashMap<>();
        Map<Character,Integer> indexMap = new HashMap<>();
        for(int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            indexMap.putIfAbsent(c,i);
        }

        for(Map.Entry entry : frequencyMap.entrySet()){
            if((int)entry.getValue()==1)
                return indexMap.get((char)entry.getKey());
        }
        return -1;
    }
    public static void main(String[] args) {
        String input = "abcdcaf";
        int expected = 1;
        System.out.println(new FirstNonRepeatingCharacter().firstNonRepeatingCharacter(input));
    }
}
