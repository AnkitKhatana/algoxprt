package bst.easy;

import util.Utils;

public class FindClosestValueInBST3 {

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        int closestValue = Integer.MAX_VALUE;
        int closestDelta = Integer.MAX_VALUE;
        BST node = tree;
        while(node != null){
            System.out.println(node.value);
            int nodeDelta = Math.abs(node.value - target);
            if(nodeDelta < closestDelta) {
                closestDelta = nodeDelta;
                closestValue = node.value;
            }
            if (target == node.value)
                return tree.value;
            else if(target > node.value){
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
        return closestValue;
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

        int expected = 13;
        int actual = findClosestValueInBst(root, 12);
        Utils.assertEquals(expected, actual);
    }
}
