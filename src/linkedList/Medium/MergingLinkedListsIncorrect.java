package linkedList.Medium;

import java.util.Stack;

public class MergingLinkedListsIncorrect {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList potentialIntersectionPoint = null;
        Stack<LinkedList> nodeStackLL1 = new Stack();
        Stack<LinkedList> nodeStackLL2 = new Stack();
        while(linkedListOne!=null){
            nodeStackLL1.add(linkedListOne);
            linkedListOne=linkedListOne.next;
        }
        while(linkedListTwo!=null){
            nodeStackLL2.add(linkedListTwo);
            linkedListTwo=linkedListTwo.next;
        }
        while(!nodeStackLL1.isEmpty() && !nodeStackLL2.isEmpty()){
            if(nodeStackLL1.peek() == nodeStackLL2.pop()) {
                potentialIntersectionPoint=nodeStackLL1.pop();
            }
            else {
                break;
            }
        }
        return potentialIntersectionPoint;
    }

    public LinkedList mergingLinkedLists1(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList potentialIntersectionPoint = null;
        while(linkedListOne!=null && linkedListTwo!=null){
            if(linkedListOne == linkedListTwo){
                if(potentialIntersectionPoint == null)
                    potentialIntersectionPoint=linkedListOne;
            }else {
                potentialIntersectionPoint=null;
            }
            linkedListOne=linkedListOne.next;
            linkedListTwo=linkedListTwo.next;
        }
        return potentialIntersectionPoint;
    }

    public LinkedList mergingLinkedLists2(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList potentialIntersectionPoint = null;
        LinkedList pointerOne = linkedListOne;
        LinkedList pointerTwo = linkedListTwo;
        int length1=0;
        int length2=0;
        while(pointerOne != null){
            length1++;
            pointerOne=pointerOne.next;
        }
        while(pointerTwo != null){
            length2++;
            pointerTwo=pointerTwo.next;
        }
        if(length1 > length2){
            int diff = length1-length2;
            while(diff>0){
                linkedListOne=linkedListOne.next;
                diff--;
            }
        }else {
            int diff = length2-length1;
            while(diff>0){
                linkedListTwo=linkedListTwo.next;
                diff--;
            }
        }
        while(linkedListOne!=null){
            if(linkedListOne.value == linkedListTwo.value && potentialIntersectionPoint == null)
                potentialIntersectionPoint=linkedListOne;
            else if(linkedListOne.value != linkedListTwo.value && potentialIntersectionPoint != null)
                potentialIntersectionPoint=null;
            linkedListOne=linkedListOne.next;
            linkedListTwo=linkedListTwo.next;
        }
        return potentialIntersectionPoint;
    }

    public static void main(String args[]) {
//        LinkedList l1 = new LinkedList(1);
//        l1.next = new LinkedList(2);
//        LinkedList l2 = new LinkedList(3);
//        l2.next = l1.next;
//
//        LinkedList expected = l1.next;
//        LinkedList actual = new MergingLinkedLists().mergingLinkedLists(l1, l2);
//
//        LinkedList actual1 = new MergingLinkedLists().mergingLinkedLists2(l1, l2);
        LinkedList l1 = new LinkedList(1);
        l1.next = new LinkedList(2);
        LinkedList l2 = new LinkedList(2);
        l2.next = new LinkedList(1);

        LinkedList expected = null;
        LinkedList actual = new MergingLinkedListsIncorrect().mergingLinkedLists(l1, l2);
        LinkedList actual1 = new MergingLinkedListsIncorrect().mergingLinkedLists2(l1, l2);
        System.out.println((expected == actual));
        System.out.println((expected == actual1));
    }
}
