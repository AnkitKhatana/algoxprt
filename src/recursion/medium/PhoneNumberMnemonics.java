package recursion.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumberMnemonics {

    public static char[][] MappingsArray = {new char[]{'0'}, new char[] {'1'}, new char[]{'a','b','c'}, new char[]{'d','e','f'}, new char[]{'g','h','i'}, new char[]{'j','k','l'}, new char[]{'m','n','o'}, new char[]{'p','q','r','s'}, new char[]{'t','u','v'},new char[]{'w','x','y','z'}};

    public char[] getMappings(Character c){
        return MappingsArray[Integer.parseInt(c.toString())];
    }

    public void phoneNumberMnemonicsHelper(int level, ArrayList<String> mnemonics, char[] presentMnemonic, String phoneNumber){
        if(level == phoneNumber.length())
            mnemonics.add(new String(presentMnemonic));
        else {
            for (char c : getMappings(phoneNumber.charAt(level))) {
                presentMnemonic[level] = c;
                phoneNumberMnemonicsHelper(level + 1, mnemonics, presentMnemonic, phoneNumber);
            }
        }
    }
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.
        ArrayList<String> mnemonics = new ArrayList<>();
        phoneNumberMnemonicsHelper(0,mnemonics,new char[phoneNumber.length()],phoneNumber);
        return mnemonics;
    }

    public static void main(String[] args) {
        String phoneNumber = "1905";
        ArrayList<String> output = new PhoneNumberMnemonics().phoneNumberMnemonics(phoneNumber);
        for(String mnemonic : output){
            System.out.println(mnemonic+',');
        }
    }

}
