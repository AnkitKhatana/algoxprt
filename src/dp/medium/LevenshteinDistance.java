package dp.medium;

import util.Utils;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int[][] memoized = new int[str1.length()+1][str2.length()+1];
        memoized[0][0] = 0;
        for(int i=1; i<str1.length()+1; i++)
            memoized[i][0]=i;
        for(int j=1; j<str2.length()+1; j++)
            memoized[0][j]=j;
        for(int i=1; i<str1.length()+1; i++){
            for(int j=1; j<str2.length()+1; j++){
                int noOp = Integer.MAX_VALUE;
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    noOp = memoized[i-1][j-1];
                int del = memoized[i-1][j] + 1;
                int ins = memoized[i][j-1] + 1;
                int sub = memoized[i-1][j-1] + 1;
                memoized[i][j] = Integer.min(noOp,Integer.min(del,Integer.min(ins,sub)));
            }
        }
        return memoized[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        Utils.assertTrue(levenshteinDistance("abc", "yabd") == 2);
    }
}
