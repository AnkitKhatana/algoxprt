package bst.medium;

import util.Utils;

public class FindKthLargestValueInBst {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class Counter {
        public int count;
        Counter(int count){
            this.count=count;
        }
    }

    public BST reverseInOrder(BST node , int k, Counter counter){
        if(node == null)
            return null;
        BST returned = reverseInOrder(node.right,k,counter);
        if(returned != null)
            return returned;
        counter.count++;
        if(counter.count==k)
            return node;
        return reverseInOrder(node.left,k,counter);
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        Counter counter = new Counter(0);
        return reverseInOrder(tree,k,counter).value;
    }

    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.left.right = new BST(3);
        root.left.right = new BST(5);
        root.right = new BST(20);
        root.right.left = new BST(17);
        root.right.right = new BST(22);
        int k = 3;
        int expected = 17;
        int actual = new FindKthLargestValueInBst().findKthLargestValueInBst(root, k);
        Utils.assertTrue(expected == actual);
    }

}
