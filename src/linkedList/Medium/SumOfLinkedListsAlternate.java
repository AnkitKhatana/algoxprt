package linkedList.Medium;

import java.util.ArrayList;

public class SumOfLinkedListsAlternate {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int carry=0;
        LinkedList sumLL = new LinkedList(0);
        LinkedList current = sumLL;

        while(linkedListOne!=null || linkedListTwo!=null || carry!=0){
            int valueOne=0;
            int valueTwo=0;
            if(linkedListOne!=null){
                valueOne=linkedListOne.value;
                linkedListOne=linkedListOne.next;
            }
            if(linkedListTwo!=null){
                valueTwo = linkedListTwo.value;
                linkedListTwo = linkedListTwo.next;
            }
            int sum=valueOne+valueTwo+carry;
            carry=sum/10;
            sum=sum%10;
            current.next=new LinkedList(sum);
            current=current.next;
        }
        return sumLL.next;
    }


    public static void main(String args[]) {
        LinkedList ll1 = addMany(new LinkedList(2), new int[] {4, 7, 1});
        LinkedList ll2 = addMany(new LinkedList(9), new int[] {4, 5});
        LinkedList expected = addMany(new LinkedList(1), new int[] {9, 2, 2});
        LinkedList actual = new SumOfLinkedListsAlternate().sumOfLinkedLists(ll1, ll2);
        System.out.println(getNodesInArray(actual));
        System.out.println((getNodesInArray(expected).equals(getNodesInArray(actual))));
    }

    public static LinkedList addMany(LinkedList linkedList, int[] values) {
        LinkedList current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public static ArrayList<Integer> getNodesInArray(LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }
}
