package binaryTree.Easy;

import util.Utils;

public class EvaluateExpressionTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        // Write your code here.
        switch(tree.value) {
            case -1 :
                return evaluateExpressionTree(tree.left) + evaluateExpressionTree(tree.right);
            case -2 :
                return evaluateExpressionTree(tree.left) - evaluateExpressionTree(tree.right);
            case -3 :
                return evaluateExpressionTree(tree.left) / evaluateExpressionTree(tree.right);
            case -4 :
                return evaluateExpressionTree(tree.left) * evaluateExpressionTree(tree.right);
            default :
                return tree.value;
        }
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree(-1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(-2);
        tree.right.left = new BinaryTree(5);
        tree.right.right = new BinaryTree(1);
        int expected = 6;
        int actual = new EvaluateExpressionTree().evaluateExpressionTree(tree);
        Utils.assertTrue(expected == actual);
    }
}
