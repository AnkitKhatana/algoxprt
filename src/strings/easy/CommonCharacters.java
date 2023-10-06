package strings.easy;

import java.lang.reflect.Array;
import java.util.*;

public class CommonCharacters {

    public Set<Character> getCharSet(String string){
        Set<Character> charSet = new HashSet<>();
        for(int i=0; i<string.length();i++){
            charSet.add(string.charAt(i));
        }
        return charSet;
    }
    public String[] commonCharacters(String[] strings) {
        // Write your code here.
        List<Character> commonCharacters = new ArrayList<>(getCharSet(strings[0]));
        for(int i=1;i<strings.length; i++){
            String string = strings[i];
            Set<Character> charSet = getCharSet(string);
            for(int j=0; j<commonCharacters.size(); j++){
                if(!charSet.contains(commonCharacters.get(j)))
                    commonCharacters.remove(j--);
            }
        }
        String[] commonCharAsString = new String[commonCharacters.size()];
        for(int i=0; i<commonCharacters.size(); i++){
            commonCharAsString[i] = new String( new char[] {commonCharacters.get(i)});
        }
        return commonCharAsString;
    }

    public static void main(String[] args) {
        String[] input1 = new String[] {"abc", "bcd", "cbad"};
        String[] input = new String[] {"ab&cdef!", "f!ed&cba", "a&bce!d", "ae&fb!cd", "efa&!dbc", "eff!&fff&fffffffbcda", "eeee!efff&fffbbbbbaaaaaccccdddd", "*******!***&****abdcef************", "*******!***&****a***********f*", "*******!***&****b***********c*"};
        System.out.println(Arrays.toString(new CommonCharacters().commonCharacters(input)));
    }
}
