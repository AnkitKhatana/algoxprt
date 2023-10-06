package dp.medium;

import util.Utils;

public class MaxSubsetSumNoAdjacent1 {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if(array.length == 0)
            return 0;
        for(int i=2; i<array.length; i++){
            if(i>2){
                array[i] = array[i] + Math.max(array[i-2] , array[i-3]);
            }
            else if(i==2)
                array[i] = array[i]+array[i-2];
        }
        return Math.max( array[array.length-1] , array.length > 1 ? array[array.length-2] : 0);
    }

    public static void main(String[] args) {
        int[] input = {75, 105, 120, 75, 90, 135};
        Utils.assertTrue(maxSubsetSumNoAdjacent(input) == 330);
    }
}
