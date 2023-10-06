package arrays.medium;

import java.util.Arrays;

public class FirstDuplicateValue {

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.

        int[] occurences = new int[array.length];

        for(int element : array){
            if(occurences[element-1] == 0)
                occurences[element-1] = 1;
            else
                return element;
        }

        return -1;
    }

    public static int firstDuplicateValue1(int[] array) {
        // Write your code here.

        for(int element : array){
            if(array[Math.abs(element-1)] < 0)
                return Math.abs(element);
            else
                array[Math.abs(element-1)] = array[Math.abs(element-1)] * -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {3, 1, 3, 1, 1, 4, 4};

        System.out.println(firstDuplicateValue1(array));

    }
}
