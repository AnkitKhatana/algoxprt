package bst.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReconstructBstIterative {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class BSTWrapper {
        public BST tree;
        public boolean rightCovered;
        public BSTWrapper(BST tree, boolean rightCovered){
            this.tree = tree;
            this.rightCovered = rightCovered;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        Stack<BSTWrapper> stack = new Stack<>();
        BSTWrapper root = new BSTWrapper(new BST(preOrderTraversalValues.get(0)),false);
        BSTWrapper current = root;
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            int value = preOrderTraversalValues.get(i);
            if (value < current.tree.value) {
                current.tree.left = new BST(value);
                stack.push(current);
                current = new BSTWrapper(current.tree.left,false);
            } else {
                while (!stack.isEmpty() && stack.peek().tree.value < value && !stack.peek().rightCovered )
                    current = stack.pop();
                current.tree.right = new BST(value);
                if(stack.isEmpty())
                    current.rightCovered = true;
                else
                    current.rightCovered = stack.peek().rightCovered;
                stack.push(current);
                current = new BSTWrapper(current.tree.right,false);
            }
        }
        return root.tree;
    }


    public static List<Integer> getDfsOrder(BST node, List<Integer> values) {
        values.add(node.value);
        if (node.left != null) {
            getDfsOrder(node.left, values);
        }
        if (node.right != null) {
            getDfsOrder(node.right, values);
        }
        return values;
    }

    public static void main1(String[] args) {
        ArrayList<Integer> preOrderTraversalValues =
                new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
        BST tree = new BST(10);
        tree.left = new BST(4);
        tree.left.left = new BST(2);
        tree.left.left.left = new BST(1);
        tree.left.right = new BST(3);
        tree.right = new BST(17);
        tree.right.right = new BST(19);
        tree.right.right.left = new BST(18);
        List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
        System.out.println(expected);
        BST actual = new ReconstructBstIterative().reconstructBst(preOrderTraversalValues);
        List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        System.out.println(actualValues);
        Utils.assertTrue(expected.equals(actualValues));
    }

    public static void main(String[] args) {
        ArrayList<Integer> preOrderTraversalValues =
                new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 5, 6, 9, 7, 17, 19, 18));
        BST tree = new BST(10);
        tree.left = new BST(4);
        tree.left.left = new BST(2);
        tree.left.left.left = new BST(1);
        tree.left.right = new BST(3);
        tree.right = new BST(17);
        tree.right.right = new BST(19);
        tree.right.right.left = new BST(18);
        List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
        System.out.println(expected);
        BST actual = new ReconstructBstIterative().reconstructBst(preOrderTraversalValues);
        List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        System.out.println(actualValues);
        Utils.assertTrue(expected.equals(actualValues));
    }

}
