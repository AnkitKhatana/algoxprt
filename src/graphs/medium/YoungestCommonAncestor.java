package graphs.medium;

import util.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {
        // Write your code here.
        int heightOne=0, heightTwo=0;
        AncestralTree temp = descendantOne;
        while(temp != topAncestor){
            heightOne++;
            temp = temp.ancestor;
        }
        temp = descendantTwo;
        while(temp != topAncestor){
            heightTwo++;
            temp = temp.ancestor;
        }
        while(heightOne>heightTwo){
            descendantOne = descendantOne.ancestor;
            heightOne--;
        }
        while(heightTwo>heightOne){
            descendantTwo = descendantTwo.ancestor;
            heightTwo--;
        }
        while(descendantOne != descendantTwo){
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }
        return descendantOne; // Replace this line
    }

    public static AncestralTree getYoungestCommonAncestorUsingStack(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {
        // Write your code here.
        Stack<AncestralTree> pathDescendantOne = new Stack<>();
        Stack<AncestralTree> pathDescendantTwo = new Stack<>();
        while(descendantOne != topAncestor){
            pathDescendantOne.push(descendantOne);
            descendantOne = descendantOne.ancestor;
        }
        pathDescendantOne.push(descendantOne);
        while(descendantTwo != topAncestor){
            pathDescendantTwo.push(descendantTwo);
            descendantTwo = descendantTwo.ancestor;
        }
        pathDescendantTwo.push(descendantTwo);
        AncestralTree yca = pathDescendantOne.peek();
        while(!pathDescendantOne.isEmpty() && !pathDescendantTwo.isEmpty() && pathDescendantOne.peek() == pathDescendantTwo.peek()){
            yca = pathDescendantOne.peek();
            pathDescendantOne.pop();
            pathDescendantTwo.pop();
        }

        return yca; // Replace this line
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }


    public static HashMap<Character, AncestralTree> getTrees() {
        HashMap<Character,AncestralTree> trees = new HashMap<Character, AncestralTree>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new AncestralTree(a));
        }

        trees.get('A').addAsAncestor(new AncestralTree[] {
                trees.get('B'),
                trees.get('C'),
                trees.get('D'),
                trees.get('E'),
                trees.get('F')});
        return trees;
    }

    public static void main(String[] args) {
        HashMap<Character,AncestralTree> trees = getTrees();
        trees.get('A').addAsAncestor(new AncestralTree[] {
                trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[] {
                trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[] {
                trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[] {
                trees.get('F'), trees.get('G')});

        AncestralTree yca = getYoungestCommonAncestor(
                trees.get('A'), trees.get('E'), trees.get('I')
        );
        Utils.assertTrue(yca == trees.get('B'));
    }

}
