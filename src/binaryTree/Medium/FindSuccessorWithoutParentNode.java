package binaryTree.Medium;

public class FindSuccessorWithoutParentNode {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    Boolean encounteredNode=false;
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if(tree == null)
            return null;
        BinaryTree leftReturned = findSuccessor(tree.left,node);
        if(leftReturned != null)
            return leftReturned;
        if(encounteredNode)
            return tree;
        if(tree==node)
            encounteredNode=true;
        return findSuccessor(tree.right,node);
    }

    public static void main(String args[]) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.parent = root;
        root.right = new BinaryTree(3);
        root.right.parent = root;
        root.left.left = new BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        BinaryTree node = root.left.right;
        BinaryTree expected = root;
        BinaryTree output = new FindSuccessorWithoutParentNode().findSuccessor(root, node);
        System.out.println(output.value);
        assert (expected == output);
    }
}
