package binaryTree.Medium;

import util.Utils;

public class SymmetricalTree1 {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean symmetricalTree(BinaryTree tree1, BinaryTree tree2){
        if(tree1 == tree2)
            return true;
        if((tree1 == null || tree2 == null))
            return false;
        if(tree1.value != tree2.value)
            return false;
        if(!symmetricalTree(tree1.left,tree2.right))
            return false;
        if(!symmetricalTree(tree1.right,tree2.left))
            return false;
        return true;
    }

    public boolean symmetricalTreeEfficient(BinaryTree left, BinaryTree right){
        if(left != null && right != null && left.value == right.value)
            return (symmetricalTreeEfficient(left.left,right.right) && symmetricalTreeEfficient(left.right,right.left));
        return left == right;
    }

    public boolean symmetricalTree(BinaryTree tree) {
        // Write your code here.
        return symmetricalTreeEfficient(tree.left,tree.right);
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(10);
        tree.left = new BinaryTree(5);
        tree.right = new BinaryTree(5);
        tree.left.left = new BinaryTree(7);
        tree.left.right = new BinaryTree(9);
        tree.right.left = new BinaryTree(9);
        tree.right.right = new BinaryTree(7);
        boolean expected = true;
        boolean actual = new SymmetricalTree1().symmetricalTree(tree);
        Utils.assertTrue(expected == actual);
    }
}
