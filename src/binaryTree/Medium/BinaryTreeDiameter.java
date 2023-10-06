package binaryTree.Medium;

import java.util.ArrayDeque;
import util.Utils;
public class BinaryTreeDiameter {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    int max;
    public int binaryTreeDiameterRecursive(BinaryTree tree ){
        if(tree == null)
            return 0;
        int leftHeight=binaryTreeDiameterRecursive(tree.left);
        int rightHeight=binaryTreeDiameterRecursive(tree.right);
        if(leftHeight+rightHeight > max)
            max=leftHeight+rightHeight;
        return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;
    }
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        binaryTreeDiameterRecursive(tree);
        return max;
    }

    public static void main(String[] args) {
        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        tree.TestCase1(tree);
    }

    public void TestCase1(BinaryTreeDiameter tree) {
        TestBinaryTree input = new TestBinaryTree(1);
        input.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        int expected = 4;
        int actual = tree.binaryTreeDiameter(input);
        Utils.assertTrue(expected == actual);
    }

    class TestBinaryTree extends BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
}
