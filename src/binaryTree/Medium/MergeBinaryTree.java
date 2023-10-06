package binaryTree.Medium;

import util.Utils;

public class MergeBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int sumOfNodes(BinaryTree node1, BinaryTree node2){
        return node1.value = node1.value + (node2 == null ? 0 : node2.value);
    }
    public void mergeBinarySubTrees(BinaryTree node1, BinaryTree node2){
        sumOfNodes(node1,node2);
        BinaryTree left2= node2 == null ? null : node2.left ;
        if(node1.left != null || left2 != null ){
            if(node1.left == null)
                node1.left = new BinaryTree(0);
            mergeBinaryTrees(node1.left,left2);
        }
        BinaryTree right2 = node2 == null ? null : node2.right;
        if(node1.right != null || right2 != null){
            if(node1.right == null)
                node1.right = new BinaryTree(0);
            mergeBinaryTrees(node1.right,right2);
        }
    }

    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        mergeBinarySubTrees(tree1,tree2);
        return tree1;
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1);
        tree1.left = new BinaryTree(3);
        tree1.left.left = new BinaryTree(7);
        tree1.left.right = new BinaryTree(4);
        tree1.right = new BinaryTree(2);

        BinaryTree tree2 = new BinaryTree(1);
        tree2.left = new BinaryTree(5);
        tree2.left.left = new BinaryTree(2);
        tree2.right = new BinaryTree(9);
        tree2.right.left = new BinaryTree(7);
        tree2.right.right = new BinaryTree(6);

        BinaryTree actual = new MergeBinaryTree().mergeBinaryTrees(tree1, tree2);

        Utils.assertTrue(actual.value == 2);
        Utils.assertTrue(actual.left.value == 8);
        Utils.assertTrue(actual.left.left.value == 9);
        Utils.assertTrue(actual.left.right.value == 4);
        Utils.assertTrue(actual.right.value == 11);
        Utils.assertTrue(actual.right.left.value == 7);
        Utils.assertTrue(actual.right.right.value == 6);
    }
}
