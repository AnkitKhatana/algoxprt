package graphs.medium;

import util.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BreadthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            Deque<Node> traversalOrder = new ArrayDeque();
            //breadthFirstSearch(array,traversalOrder);
            breadthFirstSearchIterative(array);
            return array;
        }

        public void breadthFirstSearch(List<String> array, Deque<Node> traversalOrder) {
            array.add(this.name);
            for(Node child : this.children)
                traversalOrder.addLast(child);
            if(!traversalOrder.isEmpty())
                traversalOrder.removeFirst().breadthFirstSearch(array,traversalOrder);
        }

        public void breadthFirstSearchIterative(List<String> array) {
            Deque<Node> traversalOrder = new ArrayDeque<>();
            traversalOrder.addLast(this);
            while(!traversalOrder.isEmpty()){
                Node current = traversalOrder.removeFirst();
                array.add(current.name);
                for(Node node : current.children)
                    traversalOrder.addLast(node);
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        String[] expected = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        List<String> inputArray = new ArrayList<String>();
        List<String> actual = graph.breadthFirstSearch(inputArray);
        Utils.assertTrue(compare(actual, expected));
    }

    public static boolean compare(List<String> arr1, String[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
