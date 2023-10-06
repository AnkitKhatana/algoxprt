package bst.medium;

import util.Utils;

public class ValidateBST {

    public static SubTreeData validateBstRecursive(BST node){
        if(node == null)
            return new SubTreeData(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        SubTreeData left = validateBstRecursive(node.left);
        if(!left.isValid)
            return new SubTreeData(0,0,false);
        SubTreeData right = validateBstRecursive(node.right);
        if(!right.isValid)
            return new SubTreeData(0,0,false);
        if(left.largest != Integer.MIN_VALUE && node.value <= left.largest)
            return new SubTreeData(0,0,false);
        if(right.smallest != Integer.MAX_VALUE && node.value > right.smallest)
            return new SubTreeData(0,0,false);

        return new SubTreeData(left.smallest == Integer.MAX_VALUE ? node.value : left.smallest,right.largest == Integer.MIN_VALUE ? node.value : right.largest,true);
    }
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBstRecursive(tree).isValid;
    }

    static class SubTreeData {
        int smallest;
        int largest;
        boolean isValid;

        public SubTreeData(int smallest , int largest , boolean isValid){
            this.smallest = smallest;
            this.largest = largest;
            this.isValid = isValid;
        }
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
