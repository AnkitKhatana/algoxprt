package sorting.easy;

import java.util.Arrays;

public class BubbleSort {

    public static void swap(int[] array,int firstIndex, int secondIndex){
        int temp=array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        int lastSwap=0;
        int n=array.length;
        do{
            lastSwap=0;
            for(int j=0; j < n-1; j++){
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                    lastSwap=j;
                }
            }
            n=lastSwap+1;
        }while(lastSwap>0);
        return array;
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(bubbleSort(input)));
    }
}
