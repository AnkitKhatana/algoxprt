package strings.easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<characters.length(); i++)
            frequencyMap.put(characters.charAt(i),frequencyMap.getOrDefault(characters.charAt(i),0)+1);

        for(int i=0; i<document.length(); i++){
            char c = document.charAt(i);
            int frequency = frequencyMap.getOrDefault(c,0);
            if(frequency == 0)
                return false;
            else
                frequencyMap.put(c,frequency - 1);
        }
        return true;
    }

    public static void main(String[] args) {
//        String characters = "Bste!hetsi ogEAxpelrt x ";
//        String document = "AlgoExpert is the Best!";
        String characters = "abcabc";
        String document = "aabbccc";
        boolean expected = true;
        System.out.println(new GenerateDocument().generateDocument(characters,document));
    }

}
