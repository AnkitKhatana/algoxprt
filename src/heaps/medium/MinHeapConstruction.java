package heaps.medium;

import util.Utils;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapConstruction {

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            for(int element : array)
                insert(element);
            return heap;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Write your code here.
            int leftIdx = 2*currentIdx+1;
            int rightIdx = 2*currentIdx+2;
            if((endIdx-1)/2 < currentIdx || heap.get(endIdx) < Math.min(heap.get(leftIdx),heap.get(rightIdx))){
                heap.set(currentIdx , heap.get(endIdx));
                heap.remove(endIdx);
                return;
            }
            if(heap.get(leftIdx) <= heap.get(rightIdx)) {
                heap.set(currentIdx, heap.get(leftIdx));
                siftDown(leftIdx,endIdx,heap);
            }
            else {
                heap.set(currentIdx, heap.get(rightIdx));
                siftDown(rightIdx,endIdx,heap);
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            if(currentIdx == 0)
                return;
            int parentIdx = (currentIdx-1)/2 ;
            if(heap.get(parentIdx) > heap.get(currentIdx)){
                int temp = heap.get(currentIdx);
                heap.set(currentIdx , heap.get(parentIdx));
                heap.set(parentIdx , temp);
                siftUp(parentIdx,heap);
            }
        }

        public int peek() {
            // Write your code here.
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            int min=heap.get(0);
            siftDown(0,heap.size()-1,heap);
            return min;
        }

        public void insert(int value) {
            // Write your code here.
            heap.add(value);
            siftUp(heap.size()-1,heap);
        }
    }


    public static void main1(String[] args) {
        MinHeap minHeap = new MinHeap(new ArrayList<Integer>(
                Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)
        ));
        minHeap.insert(76);
        Utils.assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
        Utils.assertTrue(minHeap.peek() == -5);
        Utils.assertTrue(minHeap.remove() == -5);
        Utils.assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
        Utils.assertTrue(minHeap.peek() == 2);
        Utils.assertTrue(minHeap.remove() == 2);
        Utils.assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
        Utils.assertTrue(minHeap.peek() == 6);
        minHeap.insert(87);
        Utils.assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(new ArrayList<Integer>(
                Arrays.asList(-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8)
        ));

        Utils.assertTrue(minHeap.remove() == -10);
        Utils.assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
        Utils.assertTrue(minHeap.peek() == -10);
        minHeap.insert(-8);
        Utils.assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
        Utils.assertTrue(minHeap.peek() == -10);
        Utils.assertTrue(minHeap.remove() == -10);
        Utils.assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
    }


    static boolean isMinHeapPropertySatisfied(List<Integer> array) {
        for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                return true;
            }
            if (array.get(parentIdx) > array.get(currentIdx)) {
                return false;
            }
        }

        return true;
    }

}
