package famousAlgos.medium;

import util.Utils;

public class KadaneAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.
        int end=0,currSum=0,maxSum=Integer.MIN_VALUE;
        while(end < array.length){
            currSum += array[end++];
            if(currSum > maxSum)
                maxSum = currSum;
            if(currSum < 0)
                currSum=0;
        }
        return maxSum ;
    }

    public static void main(String[] args) {
        int[] input = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        Utils.assertTrue(kadanesAlgorithm(input) == 19);
    }
}
