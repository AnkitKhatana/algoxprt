package bst.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBstRecursive {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBstRecursive(List<Integer> preOrderTraversalValues , int start , int end){
        if(start >= end)
            return null;
        BST root = new BST(preOrderTraversalValues.get(start));
        int rightStart = start+1;
        while(rightStart < end && preOrderTraversalValues.get(rightStart) < preOrderTraversalValues.get(start))
            rightStart++;
        root.left = reconstructBstRecursive(preOrderTraversalValues , start+1 , rightStart);
        root.right = reconstructBstRecursive(preOrderTraversalValues , rightStart, end);
        return root;
    }

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        // Write your code here.
        return reconstructBstRecursive(preOrderTraversalValues,0,preOrderTraversalValues.size());
    }

    public static List<Integer> getDfsOrder(BST node, List<Integer> values) {
        values.add(node.value);
        if (node.left != null) {
            getDfsOrder(node.left, values);
        }
        if (node.right != null) {
            getDfsOrder(node.right, values);
        }
        return values;
    }
    
    public static void main(String[] args) {
        List<Integer> preOrderTraversalValues =
                new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
        BST tree = new BST(10);
        tree.left = new BST(4);
        tree.left.left = new BST(2);
        tree.left.left.left = new BST(1);
        tree.left.right = new BST(3);
        tree.right = new BST(17);
        tree.right.right = new BST(19);
        tree.right.right.left = new BST(18);
        List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
        System.out.println(expected);
        BST actual = new ReconstructBstRecursive().reconstructBst(preOrderTraversalValues);
        List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        System.out.println(actualValues);
        Utils.assertTrue(expected.equals(actualValues));
    }
}
