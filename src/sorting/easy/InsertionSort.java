package sorting.easy;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        // Write your code here.
        int boundary=0;
        while(boundary<array.length-1){
            int toPlace = array[boundary+1];
            int probeIndex = boundary++;
            while(probeIndex>=0 && toPlace < array[probeIndex]){
                array[probeIndex+1]=array[probeIndex--];
            }
            array[probeIndex+1]=toPlace;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(insertionSort(input)));
    }
}
