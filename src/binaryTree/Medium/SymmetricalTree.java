package binaryTree.Medium;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class SymmetricalTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public List<BinaryTree> getChildren(List<BinaryTree> parentList){
        List<BinaryTree> childList = new ArrayList<>();
        for(int i=0; i<parentList.size(); i++){
            BinaryTree node = parentList.get(i);
            if(node == null ) {
                childList.add(null);
                childList.add(null);
            } else {
                childList.add(node.left);
                childList.add(node.right);
            }
        }
        return childList;
    }

    public boolean checkPalindrome(List<BinaryTree> nodesList){
        if(nodesList.size()%2 == 1)
            return false;
        int start=0;
        int end=nodesList.size()-1;
        while(start<end){
            BinaryTree first = nodesList.get(start++);
            BinaryTree second = nodesList.get(end--);
            if(first != second && (first == null || second == null || first.value != second.value)){
                return false;
            }
        }
        return true;
    }

    public int countNulls(List<BinaryTree> nodesList){
        int count=0;
        for(int i=0; i<nodesList.size(); i++){
            if(nodesList.get(i) == null)
                count++;
        }
        return count;
    }

    public boolean symmetricalTree(BinaryTree tree) {
        // Write your code here.
        List<BinaryTree> parentList = new ArrayList<>();
        List<BinaryTree> childList;
        parentList.add(tree);
        boolean terminate=false;
        boolean isNotMirrorImage=false;
        do {
            childList = getChildren(parentList);
            boolean isPalindrome = checkPalindrome(childList);
            if(!isPalindrome){
                terminate = true;
                isNotMirrorImage=true;
            }
            if(countNulls(childList) == childList.size())
                terminate=true;
            parentList=childList;
        }while(!terminate);
        return !isNotMirrorImage;
    }

    public static void main1(String args[]) {
        BinaryTree tree = new BinaryTree(10);
        tree.left = new BinaryTree(5);
        tree.right = new BinaryTree(5);
        tree.left.left = new BinaryTree(7);
        tree.left.right = new BinaryTree(9);
        tree.right.left = new BinaryTree(9);
        tree.right.right = new BinaryTree(7);
        boolean expected = true;
        boolean actual = new SymmetricalTree().symmetricalTree(tree);
        Utils.assertTrue(expected == actual);
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(5);
        tree.right = new BinaryTree(5);
        boolean expected = true;
        boolean actual = new SymmetricalTree().symmetricalTree(tree);
        Utils.assertTrue(expected == actual);
    }
}
