package binaryTree.Easy;

import util.Utils;

public class NodeDepths {

    public static int nodeDepthsRecursive(BinaryTree node , int level){
        if(node == null)
            return 0;
        return level + nodeDepthsRecursive(node.left,level+1) + nodeDepthsRecursive(node.right,level+1);
    }
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return nodeDepthsRecursive(root,0);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String args[]) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int actual = nodeDepths(root);
        Utils.assertEquals(16, actual);
    }
}
