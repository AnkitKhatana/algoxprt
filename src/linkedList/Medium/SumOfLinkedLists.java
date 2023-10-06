package linkedList.Medium;

import java.util.ArrayList;

public class SumOfLinkedLists {
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
        int sum=0;
        LinkedList sumLL = null;
        LinkedList current = sumLL;

        while(true){
            if(linkedListOne!=null && linkedListTwo != null) {
                sum = linkedListOne.value + linkedListTwo.value + carry;
                linkedListOne = linkedListOne.next;
                linkedListTwo = linkedListTwo.next;
            }
            else if(linkedListOne!=null) {
                sum = linkedListOne.value + carry;
                linkedListOne = linkedListOne.next;
            }
            else if(linkedListTwo!=null) {
                sum = linkedListTwo.value + carry;
                linkedListTwo = linkedListTwo.next;
            }
            else {
                if(carry==0)
                    break;
                else{
                    sum=carry;
                    carry=0;
                }
            }
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }
            else
                carry=0;
            if(current == null) {
                sumLL = new LinkedList(sum);
                current=sumLL;
            }else {
                current.next = new LinkedList(sum);
                current=current.next;
            }
        }

        return sumLL;
    }


    public static void main(String args[]) {
        LinkedList ll1 = addMany(new LinkedList(2), new int[] {4, 7, 1});
        LinkedList ll2 = addMany(new LinkedList(9), new int[] {4, 5});
        LinkedList expected = addMany(new LinkedList(1), new int[] {9, 2, 2});
        LinkedList actual = new SumOfLinkedLists().sumOfLinkedLists(ll1, ll2);
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
