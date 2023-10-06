package searching.easy;

import java.util.Arrays;

public class ThreeLargestIntegers {

    public static void shiftAndPlace(int[] array , int element , int index){
        for(int i=0; i<index; i++)
            array[i]=array[i+1];
        array[index] = element;
    }
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] threeLargest = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int element : array){
            if(element > threeLargest[0]){
                if(element > threeLargest[1]){
                    if(element > threeLargest[2])
                        shiftAndPlace(threeLargest,element,2);
                    else
                        shiftAndPlace(threeLargest,element,1);
                }
                else
                    shiftAndPlace(threeLargest,element,0);
            }
        }
        return threeLargest;
    }

    public static void main(String[] args) {
        int[] input = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] input1 = {10, 5, 9, 10, 12};
        int[] input2 = {1};
        int[] input3 = {1,2};
        int[] input4 = {1,2,3};
        int[] input5 = {3,2,1};

        System.out.println(Arrays.toString(findThreeLargestNumbers(input5)));
    }
}
