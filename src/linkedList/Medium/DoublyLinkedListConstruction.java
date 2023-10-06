package linkedList.Medium;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedListConstruction {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            if(containsNode(node))
                remove(node);
            node.next=this.head;
            if(this.head == null)
                this.tail=node;
            else
                this.head.prev=node;
            this.head=node;
        }

        public void setTail(Node node) {
            // Write your code here.
            if(containsNode(node))
                remove(node);
            node.prev=this.tail;
            if(this.tail == null)
                this.head=node;
            else
                this.tail.next=node;
            this.tail=node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            if(containsNode(nodeToInsert))
                remove(nodeToInsert);
            nodeToInsert.prev=node.prev;
            nodeToInsert.next=node;
            node.prev=nodeToInsert;
            if(node == this.head)
                this.head=nodeToInsert;
            else
                nodeToInsert.prev.next=nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            if(containsNode(nodeToInsert))
                remove(nodeToInsert);
            nodeToInsert.prev=node;
            nodeToInsert.next=node.next;
            node.next=nodeToInsert;
            if(node == this.tail)
                this.tail=nodeToInsert;
            else
                nodeToInsert.next.prev=nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if(position<1)
                return;
            if(this.head==null) {
                this.head = nodeToInsert;
                this.tail = nodeToInsert;
                return;
            }
            Node node = this.head;
            for(int i=1; i<position; i++)
                node=node.next;
            if(node == null)
                insertAfter(this.tail,nodeToInsert);
            else
                insertBefore(node,nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
            Node node=this.head;
            while(node!=null) {
                Node nextNode = node.next;
                if (node.value == value)
                    remove(node);
                node=nextNode;
            }
        }

        public void remove(Node node) {
            // Write your code here.
            if(this.head == this.tail) {
                this.head = null;
                this.tail = null;
            }else if(node == this.head) {
                this.head = node.next;
                node.next.prev=null;
                node.next=null;
            }
            else if(node == this.tail) {
                this.tail = node.prev;
                node.prev.next=null;
                node.prev=null;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
            }
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node node= this.head;
            while(node!=null) {
                if(node.value == value)
                    return true;
                node = node.next;
            }
            return false;
        }

        public boolean containsNode(Node node){
            Node temp = this.head;
            while(temp!=null){
                if(temp==node)
                    return true;
                temp=temp.next;
            }
            return false;
        }

    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

class ProgramTest {
    private List<Integer> getNodeValuesHeadToTail(DoublyLinkedListConstruction.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        DoublyLinkedListConstruction.Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(DoublyLinkedListConstruction.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        DoublyLinkedListConstruction.Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void bindNodes(DoublyLinkedListConstruction.Node nodeOne, DoublyLinkedListConstruction.Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public void TestCase1() {
        DoublyLinkedListConstruction.DoublyLinkedList linkedList = new DoublyLinkedListConstruction.DoublyLinkedList();
        DoublyLinkedListConstruction.Node one = new DoublyLinkedListConstruction.Node(1);
        DoublyLinkedListConstruction.Node two = new DoublyLinkedListConstruction.Node(2);
        DoublyLinkedListConstruction.Node three = new DoublyLinkedListConstruction.Node(3);
        DoublyLinkedListConstruction.Node three2 = new DoublyLinkedListConstruction.Node(3);
        DoublyLinkedListConstruction.Node three3 = new DoublyLinkedListConstruction.Node(3);
        DoublyLinkedListConstruction.Node four = new DoublyLinkedListConstruction.Node(4);
        DoublyLinkedListConstruction.Node five = new DoublyLinkedListConstruction.Node(5);
        DoublyLinkedListConstruction.Node six = new DoublyLinkedListConstruction.Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;

        linkedList.setHead(four);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {5, 3, 2, 1, 4}));

        linkedList.setTail(six);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5, 6}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 3, 2, 1, 4}));

        linkedList.insertBefore(six, three);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 3, 5, 2, 1, 4}));

        linkedList.insertAfter(six, three2);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6, 3}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4}));
        
        linkedList.insertAtPosition(1, three3);
        System.out.println(
                compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 4, 1, 2, 5, 3, 6, 3}));
        System.out.println(
                compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4, 3}));

        linkedList.removeNodesWithValue(3);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 6}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 2, 1, 4}));

        linkedList.remove(two);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 5, 6}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 1, 4}));

        System.out.println(linkedList.containsNodeWithValue(5));
    }

    public static void main(String[] args) {
        new ProgramTest().TestCase1();
    }
}
