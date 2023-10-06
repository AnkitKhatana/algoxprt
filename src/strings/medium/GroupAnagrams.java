package strings.medium;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        Map<String , List<String>> anagramMap = new HashMap<>();
        List<List<String>> groupedAnagrams = new ArrayList<>();
        for(String word : words){
            String sortedWord = getSortedWord(word);
            List<String> permutationList;
            if(anagramMap.containsKey(sortedWord))
                permutationList = anagramMap.get(sortedWord);
            else
                permutationList = new ArrayList<>();
            permutationList.add(word);
            anagramMap.put(sortedWord,permutationList);
        }

        for(List<String> permutationList : anagramMap.values()){
            groupedAnagrams.add(permutationList);
        }

        return groupedAnagrams;
    }

    public static String getSortedWord(String word){
        char[] charArray=word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        List<String> words =
                new ArrayList<String>(
                        Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));

        List<List<String>> output = groupAnagrams(words);

        for (List<String> innerList : output) {
            for(String word : innerList)
                System.out.print(word+",");
            System.out.println();
        }
    }
}
