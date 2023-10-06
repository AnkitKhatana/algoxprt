package sorting.medium;

import java.util.Arrays;

public class ThreeNumberSumCountSort {

    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int[] orderFrequency=new int[3];
        for(int i=0; i<array.length; i++){
            for(int j=0; j<order.length; j++){
                if(array[i] == order[j])
                    orderFrequency[j]++;
            }
        }
        int arrayIndex=0;
        for(int i=0; i<orderFrequency.length; i++){
            while(orderFrequency[i]-- > 0)
                array[arrayIndex++]=order[i];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = new int[] {0, 1, -1};
        System.out.println(Arrays.toString(new ThreeNumberSumCountSort().threeNumberSort(array,order)));
    }
}
