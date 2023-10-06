package bst.easy;

import util.Utils;

public class FindClosestValueInBST1 {

    private static int closest=0;
    private static int deltaClosest=0;

    public static void findClosestRecursive(BST tree , int target){
        if(tree == null)
            return;
        if(tree.value == target)
            closest=target;
        else if(tree.value < target){
            int delta = Math.abs(tree.value-target);
            if(delta < deltaClosest) {
                closest = tree.value;
                deltaClosest = delta;
            }
            findClosestRecursive(tree.right,target);
        } else {
            int delta = Math.abs(target-tree.value);
            if(delta < deltaClosest) {
                closest = tree.value;
                deltaClosest = delta;
            }
            findClosestRecursive(tree.left,target);
        }
    }
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        closest=tree.value;
        deltaClosest = Integer.MAX_VALUE;
        findClosestRecursive(tree,target);
        return closest;
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
        System.out.println("actual : "+actual);
        Utils.assertEquals(expected, actual);
    }
    
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
