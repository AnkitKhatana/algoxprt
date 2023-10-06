package dp.medium;

import util.Utils;

public class NumberOfWaysToMakeChange1 {

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

    public static void checkPermutation(int n, int current, int[] denoms, int runningSum, Count count) {
        for(int i=0; i <= n/denoms[current]; i++){
            int tempRunningSum = runningSum + denoms[current] * (i);
            if(tempRunningSum == n) {
                count.increment();
                return;
            }
            if(tempRunningSum > n)
                return;
            if(current < denoms.length-1)
                checkPermutation(n,current+1,denoms,tempRunningSum,count);
        }
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        if(n == 0)
            return 1;
        Count count = new Count();
        checkPermutation(n,0,denoms,0,count);
        return count.getCount();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        System.out.println(numberOfWaysToMakeChange(6, input));
    }
}
