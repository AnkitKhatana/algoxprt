package binaryTree.Medium;

import util.Utils;

public class HeightBalancedBinaryTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    boolean isBalanced=true;
    public int heightBalancedBinaryTreeHelper(BinaryTree node){
        if(node == null || !isBalanced)
            return 0;
        int leftSubTreeHeight=heightBalancedBinaryTreeHelper(node.left);
        int rightSubTreeHeight=heightBalancedBinaryTreeHelper(node.right);
        if(Math.abs(leftSubTreeHeight-rightSubTreeHeight) > 1)
            isBalanced=false;
        return leftSubTreeHeight>rightSubTreeHeight ? leftSubTreeHeight+1 : rightSubTreeHeight+1;
    }
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        heightBalancedBinaryTreeHelper(tree);
        return isBalanced;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
        boolean expected = true;
        boolean actual = new HeightBalancedBinaryTree().heightBalancedBinaryTree(root);
        Utils.assertTrue(expected == actual);
    }
}
