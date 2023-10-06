package bst.medium;

import util.Utils;

public class BSTConstruction {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST iter = this;
            while(true){
                if(value < iter.value) {
                    if(iter.left == null){
                        iter.left = new BST(value);
                        break;
                    }
                    else
                        iter = iter.left;
                }
                else {
                    if(iter.right == null){
                        iter.right = new BST(value);
                        break;
                    }
                    else
                        iter = iter.right;
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            BST iter = this;
            while(iter != null){
                if(value == iter.value )
                    return true;
                else if(value < iter.value)
                    iter = iter.left;
                else
                    iter = iter.right;
            }
            return false;
        }

        private void removeLeaf(BST node , BST parent){
            if(parent.left == node)
                parent.left = null;
            else
                parent.right = null;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if(this.left == null && this.right == null)
                return this;
            BST iter = this;
            BST parent = iter;
            while(iter != null && iter.value != value){
                parent = iter;
                if(value < iter.value)
                    iter = iter.left;
                else
                    iter = iter.right;
            }
            if(iter == null)
                return this;

            if(iter.left == null && iter.right == null){
                removeLeaf(iter , parent);
            } else if(iter.right != null){
                parent = iter;
                BST successor = iter.right;
                while(successor.left != null){
                    parent = successor;
                    successor = successor.left;
                }
                iter.value = successor.value;
                if(successor.right == null)
                    removeLeaf(successor,parent);
                else {
                    if(parent.left == successor)
                        parent.left = successor.remove(successor.value);
                    else
                        parent.right = successor.remove(successor.value);
                }
            } else if(iter.right == null) {
                parent = iter;
                BST predecessor = iter.left;
                while(predecessor.right != null){
                    parent = predecessor;
                    predecessor = predecessor.right;
                }
                iter.value = predecessor.value;
                if(predecessor.left == null)
                    removeLeaf(predecessor,parent);
                else {
                    if(parent.left == predecessor)
                        parent.left = predecessor.remove(predecessor.value);
                    else
                        parent.right = predecessor.remove(predecessor.value);
                }
            }
            return this;
        }
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        root.insert(12);
        Utils.assertTrue(root.right.left.left.value == 12);

        root.remove(10);
        Utils.assertTrue(root.contains(10) == false);
        Utils.assertTrue(root.value == 12);

        Utils.assertTrue(root.contains(15));
    }
}
