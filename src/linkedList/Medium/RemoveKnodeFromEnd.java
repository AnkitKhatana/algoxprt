package linkedList.Medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveKnodeFromEnd {

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        if(k==0)
            return;
        else if(k==1){
            while(head.next.next !=null)
                head=head.next;
            head.next=null;
            return;
        }
        LinkedList leading = head;
        for(int i=0; i<k-1; i++)
            leading=leading.next;
        LinkedList lagging = head;
        while(leading.next!=null){
            leading=leading.next;
            lagging=lagging.next;
        }
        lagging.value=lagging.next.value;
        lagging.next=lagging.next.next;
    }
    public void TestCase1() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        RemoveKnodeFromEnd.removeKthNodeFromEnd(test, 4);
        System.out.println((compare(test.getNodesInArray(), expected)));
    }

    public static void main(String args[]){
        new RemoveKnodeFromEnd().TestCase1();
    }

    public boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    class TestLinkedList extends RemoveKnodeFromEnd.LinkedList {

        public TestLinkedList(int value) {
            super(value);
        }

        public void addMany(int[] values) {
            RemoveKnodeFromEnd.LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new RemoveKnodeFromEnd.LinkedList(value);
                current = current.next;
            }
        }

        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            RemoveKnodeFromEnd.LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }
}
