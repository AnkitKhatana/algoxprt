package dp.medium;

import util.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxSubsetSumNoAdjacent {
    static class MaxSum {
        int maxSum;
        MaxSum(int maxSum) {
            this.maxSum = maxSum;
        }
    }

    public static void maxSubsetSumNoAdjacent(int[] array, MaxSum sumObject, int index, int sumTillNow){
        if(index >= array.length) {
            if(sumObject.maxSum < sumTillNow)
                sumObject.maxSum = sumTillNow;
            return;
        }
        maxSubsetSumNoAdjacent(array, sumObject, index+2,sumTillNow+array[index]);
        maxSubsetSumNoAdjacent(array, sumObject, index+3, sumTillNow+array[index]);
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        Set<Integer> sumSet = new HashSet<>();
        MaxSum sumObject = new MaxSum(0);
        maxSubsetSumNoAdjacent(array,sumObject,0,0);
        maxSubsetSumNoAdjacent(array,sumObject,1,0);
        return sumObject.maxSum;
    }

    public static void main(String[] args) {
        int[] input = {75, 105, 120, 75, 90, 135};
        Utils.assertTrue(maxSubsetSumNoAdjacent(input) == 330);
    }

}
