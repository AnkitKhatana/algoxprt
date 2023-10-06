package binaryTree.Medium;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class SplitBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int populateSumForAllNodes(BinaryTree node , List<Integer> sumList){
        if(node == null)
            return 0;
        int leftSum = populateSumForAllNodes(node.left,sumList);
        int rightSum = populateSumForAllNodes(node.right,sumList);
        int nodeSum = leftSum+rightSum+node.value;
        sumList.add(nodeSum);
        return nodeSum;
    }

    public int splitBinaryTree(BinaryTree tree) {
        // Write your code here.
        List<Integer> sumList = new ArrayList<>();
        populateSumForAllNodes(tree,sumList);
        int treeSum=sumList.get(sumList.size()-1);
        for(int i=0; i<sumList.size()-1; i++){
            int nodeSum = sumList.get(i);
            if(nodeSum == treeSum-nodeSum){
                return nodeSum;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(2);
        tree.left = new BinaryTree(4);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(6);
        tree.right = new BinaryTree(10);
        tree.right.left = new BinaryTree(3);
        tree.right.right = new BinaryTree(3);
        int expected = 16;
        int actual = new SplitBinaryTree().splitBinaryTree(tree);
        Utils.assertTrue(expected == actual);
    }
}
