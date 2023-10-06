package sorting.easy;

import java.util.Arrays;

public class SelectionSort {

    public static void swap(int[] array, int firstIndex, int secondIndex){
        int temp=array[firstIndex];
        array[firstIndex]=array[secondIndex];
        array[secondIndex]=temp;
    }
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        int boundary=0;
        while(boundary<array.length-1){
            int smallest=boundary;
            int probeIndex=boundary+1;
            while(probeIndex< array.length){
                if(array[smallest]>array[probeIndex++]){
                    smallest=probeIndex-1;
                }
            }
            swap(array,boundary++,smallest);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(selectionSort(input)));
    }
}
