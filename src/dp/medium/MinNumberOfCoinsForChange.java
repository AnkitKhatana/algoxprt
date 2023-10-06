package dp.medium;

import util.Utils;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] minCoins = new int[n+1];
        java.util.Arrays.fill(minCoins,-1);
        minCoins[0] = 0;
        for(int i=0; i< denoms.length; i++){
            for(int j=denoms[i]; j<n+1; j++){
                if(minCoins[j-denoms[i]] != -1)
                    if(minCoins[j] == -1)
                        minCoins[j] = minCoins[j-denoms[i]] + 1;
                    else
                        minCoins[j] = Math.min(minCoins[j] , minCoins[j-denoms[i]] + 1);
            }
        }
        return minCoins[n];
    }

    public static int minNumberOfCoinsForChange1(int n, int[] denoms) {
        int[] minCoins = new int[n+1];
        java.util.Arrays.fill(minCoins,-1);
        minCoins[0] = 0;
        for(int i=0; i< denoms.length; i++){
            for(int j=denoms[i]; j<n+1; j++){
                if(minCoins[j-denoms[i]] == -1);
                else if(minCoins[j] == -1)
                    minCoins[j] = minCoins[j-denoms[i]] + 1;
                else
                    minCoins[j] = Math.min(minCoins[j] , minCoins[j-denoms[i]]+1);
            }
        }
        return minCoins[n];
    }

    public static void testCase1() {
        int[] input = {1, 5, 10};
        Utils.assertTrue(minNumberOfCoinsForChange(7, input) == 3);
    }

    public static void testcase2() {
        int[] input = {2,4};
        Utils.assertTrue(minNumberOfCoinsForChange(7, input) == -1);
    }

    public static void testCase3() {
        int[] input = {1, 5, 10};
        Utils.assertTrue(minNumberOfCoinsForChange1(7, input) == 3);
    }

    public static void testcase4() {
        int[] input = {2,4};
        Utils.assertTrue(minNumberOfCoinsForChange1(7, input) == -1);
    }

    public static void main(String[] args) {
        testCase1();
        testcase2();
        testCase3();
        testcase4();
    }


}
