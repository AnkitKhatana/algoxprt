package bst.easy;

import util.Utils;

public class FindClosestVlaueInBST2 {

    public static void findClosestRecursive(BST tree , int target , Closest closest){
        int deltaNode = Math.abs(tree.value-target);
        if(deltaNode < closest.delta){
            closest.delta=deltaNode;
            closest.value=tree.value;
        }
        if(tree.value ==target) {
            closest.delta = 0;
            closest.value = tree.value;
        } else if(tree.value < target && tree.right != null)
            findClosestRecursive(tree.right,target,closest);
        else if(tree.left != null)
            findClosestRecursive(tree.left,target,closest);
    }
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        Closest closest = new Closest();
        findClosestRecursive(tree,target,closest);
        return closest.value;
    }

    static class Closest {
        public int value;
        public int delta;
        public Closest() {
            value = Integer.MAX_VALUE;
            delta = Integer.MAX_VALUE;
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

        int expected = 13;
        int actual = findClosestValueInBst(root, 12);
        Utils.assertEquals(expected, actual);
    }
}
