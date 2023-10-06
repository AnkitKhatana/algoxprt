package binaryTree.Medium;

public class FindSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessorInRightSubTree(BinaryTree node){
        while(node.left != null)
            node=node.left;
        return node;
    }

    public BinaryTree findSuccessorInOrder(BinaryTree tree, BinaryTree node){
        while(node.parent!=null){
            if(node.parent.left == node)
                return node.parent;
            node=node.parent;
        }
        return null;
    }
    
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if(node.right != null)
            return findSuccessorInRightSubTree(node.right);
        return findSuccessorInOrder(tree, node);
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
        BinaryTree node1 = root;
        BinaryTree expected = root;
        BinaryTree output = new FindSuccessor().findSuccessor(root, node1);
        System.out.println(output.value);
        assert (expected == output);
    }
}
