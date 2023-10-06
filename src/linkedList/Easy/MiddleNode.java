package linkedList.Easy;

public class MiddleNode {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList linkedList) {
        // Write your code here.
        LinkedList firstPointer=linkedList;
        LinkedList secondPointer=linkedList;
        while(secondPointer.next!=null && secondPointer.next.next!=null){
            firstPointer=firstPointer.next;
            secondPointer=secondPointer.next.next;
        }
        return secondPointer.next==null ? firstPointer : firstPointer.next;
    }

    public static void main(String args[]) {
        MiddleNode.LinkedList linkedList = new MiddleNode.LinkedList(0);
        linkedList.next = new MiddleNode.LinkedList(1);
        MiddleNode.LinkedList expected = new MiddleNode.LinkedList(2);
        linkedList.next.next = expected;
        expected.next = new MiddleNode.LinkedList(3);
        MiddleNode.LinkedList actual = new MiddleNode().middleNode(linkedList);
        System.out.println(actual.value);
    }
}
