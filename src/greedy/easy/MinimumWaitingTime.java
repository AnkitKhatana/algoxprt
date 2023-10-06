package greedy.easy;

import util.Utils;

import java.util.Arrays;

public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int totalWaitingTime=0;
        for(int i=0; i<queries.length; i++){
            totalWaitingTime += (queries[i] * (queries.length - i -1));
        }
        return totalWaitingTime;
    }

    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        int actual = new MinimumWaitingTime().minimumWaitingTime(queries);
        Utils.assertTrue(actual == expected);
    }
}
