package dp.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfWaysToMakeChange {

    static List<String> differentCombinations = new ArrayList<>();
    static class Count {
        private int count;
        Count() {
            this.count = 0;
        }
        public void increment() {
            count++;
        }
        public int getCount() {
            return count;
        }
    }
    public static void checkPermutation(int n, int current, int[] denoms, int runningSum, Count count, String currComb) {
        for(int i=0; i <= n/denoms[current]; i++){
            int tempRunningSum = runningSum + denoms[current] * (i);
            String tempCurrComb = currComb;
            if(i>0) {
                for(int j=0; j<i ; j++)
                    if(j == 0)
                        tempCurrComb = denoms[current] + tempCurrComb ;
                    else
                        tempCurrComb = denoms[current] + "+" + tempCurrComb ;
                tempCurrComb =  "+" + tempCurrComb ;
            }
            if(tempRunningSum == n) {
                count.increment();
                differentCombinations.add(tempCurrComb.substring(tempCurrComb.indexOf("+") + 1) + "\n");
                return;
            }
            if(tempRunningSum > n)
                return;
            if(current < denoms.length-1)
                checkPermutation(n,current+1,denoms,tempRunningSum,count,tempCurrComb);
        }
    }
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        if(n == 0)
            return 1;
        Count count = new Count();
        String currComb = new String();
        checkPermutation(n,0,denoms,0,count,currComb);
        return count.getCount();
    }

    public static void main1(String[] args) {
        int[] input = {1, 5};
        Utils.assertTrue(numberOfWaysToMakeChange(6, input) == 2);
    }

    public static void main(String[] args) {
        int[] input = {2,3,4,7};
        int actual = numberOfWaysToMakeChange(0, input);
        System.out.println(actual);
        Utils.assertTrue( actual == 1);

        int[] input1 = {1,2,3};
        int actual1 = numberOfWaysToMakeChange(9, input1);
        System.out.println(actual1);
        System.out.println(Arrays.deepToString(differentCombinations.toArray()));
    }
}
