package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals1 {
    public static boolean isIntervalOverlap(int[] leftInterval , int[] rightInterval){
        int leftIntervalStart = leftInterval[0];
        int leftIntervalEnd = leftInterval[1];
        int rightIntervalStart = rightInterval[0];
        int rightIntervalEnd = rightInterval[1];

        if(leftIntervalStart <= rightIntervalStart && rightIntervalStart <= leftIntervalEnd) {
            return true;
        } else if(rightIntervalStart <= leftIntervalStart && leftIntervalStart <= rightIntervalEnd) {
            return true;
        }
        return false;
    }

    public static int[] getMergedInterval(int[] leftInterval , int[] rightInterval){
        int leftIntervalStart = leftInterval[0];
        int leftIntervalEnd = leftInterval[1];
        int rightIntervalStart = rightInterval[0];
        int rightIntervalEnd = rightInterval[1];

        return new int[] {(leftIntervalStart<rightIntervalStart)?(leftIntervalStart):(rightIntervalStart) , (leftIntervalEnd>rightIntervalEnd)?(leftIntervalEnd):(rightIntervalEnd) };
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.

        java.util.Arrays.sort(intervals,new java.util.Comparator<int []>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0],b[0]);
            }
        });

        List<int[]> mergedIntervals = new ArrayList<>();

        for(int[] interval : intervals){
            boolean overlap=false;
            for(int index=0; index<mergedIntervals.size(); index++){
                if(isIntervalOverlap(mergedIntervals.get(index),interval)){
                    int[] mergedInterval = mergedIntervals.remove(index);
                    mergedIntervals.add(index , getMergedInterval(mergedInterval , interval));
                    overlap=true;
                }
            }
            if(!overlap)
                mergedIntervals.add(interval);
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals =
                new int[][] {
                        {2, 3},
                        {4, 5},
                        {6, 7},
                        {8, 9},
                        {1, 10}
                };
        int[][] expected =
                new int[][] {
                        {1, 2},
                        {3, 8},
                        {9, 10}
                };


        int[][] actual = mergeOverlappingIntervals(intervals);

        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.print(actual[i][j]+",");
            }
            System.out.println();
        }

    }
}
