package strings.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Semordnilap {

    public String reverseString(String str) {
        if(str.isEmpty())
            return "";
        StringBuffer reverse = new StringBuffer();
        for(int i=str.length()-1; i>=0; i--){
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        // Write your code here.

        ArrayList<ArrayList<String>> semordnilap = new ArrayList<>();

        Set<String> reverseSet=new HashSet<>();
        for(String word : words){
            if(reverseSet.contains(word)){
                ArrayList<String> semordnilapPair = new ArrayList<>();
                semordnilapPair.add(word);
                semordnilapPair.add(reverseString(word));
                semordnilap.add(semordnilapPair);
            }
            else
                reverseSet.add(reverseString(word));
        }

        return semordnilap;
    }

    public static void main(String[] args) {
        String[] input = new String[] {"desserts", "stressed", "hello"};

        String[] input1 = new String[] {"diaper", "abc", "test", "cba", "repaid"};

        ArrayList<ArrayList<String>> semordnilapPairs = new Semordnilap().semordnilap(input1);

        for(ArrayList<String> pair : semordnilapPairs){
            for(String alone : pair){
                System.out.print(alone+" ");
            }
            System.out.println();
        }
    }
}
