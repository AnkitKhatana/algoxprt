package bst.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBst {

    public static BST construct(List<Integer> array , int start , int end){
        if(start > end)
            return null;
        int mid = (start+end)/2;
        BST node = new BST(array.get(mid));
        node.left = construct(array,start,mid-1);
        node.right = construct(array, mid+1 , end);
        return node;
    }

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return construct(array,0,array.size()-1);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        BST tree = minHeightBst(array);

        Utils.assertTrue(validateBst(tree));
        Utils.assertEquals(4, getTreeHeight(tree));

        List<Integer> inOrder = inOrderTraverse(tree, new ArrayList<Integer>());
        List<Integer> expected = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        Utils.assertTrue(expected.equals(inOrder));
    }

    static boolean validateBst(BST tree) {
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean validateBst(BST tree, int minValue, int maxValue) {
        if (tree.value < minValue || tree.value >= maxValue) {
            return false;
        }
        if (tree.left != null && !validateBst(tree.left, minValue, tree.value)) {
            return false;
        }
        if (tree.right != null && !validateBst(tree.right, tree.value, maxValue)) {
            return false;
        }
        return true;
    }

    static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    static int getTreeHeight(BST tree) {
        return getTreeHeight(tree, 0);
    }

    static int getTreeHeight(BST tree, int height) {
        if (tree == null) return height;
        int leftTreeHeight = getTreeHeight(tree.left, height + 1);
        int rightTreeHeight = getTreeHeight(tree.right, height + 1);
        return Math.max(leftTreeHeight, rightTreeHeight);
    }
}
