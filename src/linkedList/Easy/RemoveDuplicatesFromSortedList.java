package linkedList.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        if(linkedList == null)
            return linkedList;
        LinkedList prev=linkedList;
        LinkedList current=linkedList.next;
        while(current != null){
            if(current.value == prev.value){
                prev.next = current.next;
                current.next=null;
                current=prev.next;
            }else {
                prev=prev.next;
                current=current.next;
            }
        }
        return linkedList;
    }

    public static RemoveDuplicatesFromSortedList.LinkedList addMany(RemoveDuplicatesFromSortedList.LinkedList ll, List<Integer> values) {
        RemoveDuplicatesFromSortedList.LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new RemoveDuplicatesFromSortedList.LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public List<Integer> getNodesInArray(RemoveDuplicatesFromSortedList.LinkedList ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        RemoveDuplicatesFromSortedList.LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList.LinkedList input = new RemoveDuplicatesFromSortedList.LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 6));
        RemoveDuplicatesFromSortedList.LinkedList output = new RemoveDuplicatesFromSortedList().removeDuplicatesFromLinkedList(input);
        RemoveDuplicatesFromSortedList.LinkedList current = output;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
