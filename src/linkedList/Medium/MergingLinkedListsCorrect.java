package linkedList.Medium;

import java.util.HashSet;
import java.util.Set;

public class MergingLinkedListsCorrect {
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
        Set<LinkedList> firstLLNodes = new HashSet<>();
        while(linkedListOne!=null){
            firstLLNodes.add(linkedListOne);
            linkedListOne=linkedListOne.next;
        }
        while(linkedListTwo!=null){
            if(firstLLNodes.contains(linkedListTwo))
                return linkedListTwo;
            linkedListTwo=linkedListTwo.next;
        }
        return linkedListTwo;
    }

    public LinkedList mergingLinkedLists1(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList iterator1 = linkedListOne;
        LinkedList iterator2 = linkedListTwo;
        int count1=0;
        int count2=0;
        while(iterator1!=null){
            count1++;
            iterator1=iterator1.next;
        }
        while(iterator2!=null){
            count2++;
            iterator2=iterator2.next;
        }
        int diff = Math.abs(count1-count2);
        iterator1 = count1 > count2 ? linkedListOne : linkedListTwo;
        iterator2 = count1 > count2 ? linkedListTwo : linkedListOne;
        while(diff-- > 0)
            iterator1=iterator1.next;
        while(iterator1!=iterator2){
            iterator1=iterator1.next;
            iterator2=iterator2.next;
        }
        return iterator1;
    }

    public LinkedList mergingLinkedLists2(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList pointer1 = linkedListOne;
        LinkedList pointer2 = linkedListTwo;
        while(pointer1 != pointer2){
            if(pointer1.next == null) {
                pointer1 = linkedListTwo;
            } else
                pointer1=pointer1.next;
            if(pointer2.next == null) {
                pointer2 = linkedListOne;
            } else
                pointer2=pointer2.next;
        }
        return pointer1;
    }

    public static void main(String args[]) {
        LinkedList l1 = new LinkedList(1);
        l1.next = new LinkedList(2);
        LinkedList l2 = new LinkedList(3);
        l2.next = l1.next;

        LinkedList expected = l1.next;

//        LinkedList l1 = new LinkedList(1);
//        l1.next = null;
//        LinkedList l2 = new LinkedList(2);
//        l2.next = new LinkedList(3);
//        l2.next.next = new LinkedList(4);
//        l2.next.next.next = l1;
//        LinkedList expected = l1;

//        LinkedList actual = new MergingLinkedListsCorrect().mergingLinkedLists(l1, l2);
//        LinkedList actual1 = new MergingLinkedListsCorrect().mergingLinkedLists1(l1, l2);
        LinkedList actual2 = new MergingLinkedListsCorrect().mergingLinkedLists2(l1, l2);
//        System.out.println((expected == actual));
//        System.out.println((expected == actual1));
        System.out.println((expected == actual2));
    }
}
