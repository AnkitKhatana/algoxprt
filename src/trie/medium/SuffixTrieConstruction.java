package trie.medium;

import util.Utils;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            for(int i=str.length()-1 ; i>=0 ; i--)
                insertStringIntoTrie(str.substring(i));
        }

        public void insertStringIntoTrie(String str) {
            if(str.length() == 0)
                return;
            TrieNode iterator = root;
            int strIndex = 0;
            while(iterator.children.containsKey(str.charAt(strIndex))){
                iterator = iterator.children.get(str.charAt(strIndex++));
            }
            while(strIndex < str.length()){
                TrieNode newNode = new TrieNode();
                iterator.children.put(str.charAt(strIndex++),newNode);
                iterator=newNode;
            }
            iterator.children.put('*',null);
        }

        public boolean contains(String str) {
            // Write your code here.
            if(str.length() == 0)
                return true;
            TrieNode iterator = root;
            int strIndex = 0;
            while(iterator.children.containsKey(str.charAt(strIndex))){
                iterator = iterator.children.get(str.charAt(strIndex));
                if(strIndex == str.length()-1)
                    if(iterator.children.containsKey('*'))
                        return true;
                    else
                        return false;
                strIndex++;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        SuffixTrie trie = new SuffixTrie("babc");
        Utils.assertTrue(trie.contains("abc"));
    }
}
