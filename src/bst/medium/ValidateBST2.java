package bst.medium;

import util.Utils;

public class ValidateBST2 {

    public static boolean validateBstRecursive(BST node , int min , int max) {
        if(node == null)
            return true;
        if(node.value >= max || node.value < min)
            return false;
        return validateBstRecursive(node.left,min,node.value) && validateBstRecursive(node.right,node.value,max);
    }
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBstRecursive(tree , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        Utils.assertTrue(validateBst(root));
    }
}
