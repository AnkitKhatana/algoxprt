package dp.medium;

import util.Utils;

public class NumberOfWaysToMakeChange2 {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n+1];
        ways[0] = 1;
        for(int i=0; i<denoms.length; i++){
            for(int j=0; j<=n; j++){
                if(j >= denoms[i])
                    ways[j] += ways[j-denoms[i]];
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5};
        Utils.assertTrue(numberOfWaysToMakeChange(6, input) == 2);
    }
}
