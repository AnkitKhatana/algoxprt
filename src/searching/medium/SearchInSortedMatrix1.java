package searching.medium;

import java.util.Arrays;

public class SearchInSortedMatrix1 {
    public static int[] searchInSortedMatrixP1P2(int[][] matrix, int target) {
        // Write your code here.
        int row=0, column=matrix[0].length-1;
        while(row<matrix.length && column>0){
            if(matrix[row][column] ==target)
                return new int[]{row,column};
            else if(matrix[row][column] > target)
                column--;                                                   // Ignoring everything below current element in this column , as all elements below current element in this column are larger than current element
            else
                row++;                                                      // Ignoring everything on left of current element in this row , as all elements are smaller than current element
        }
        return new int[]{-1,-1};
    }

    public static int[] searchInSortedMatrixP3P4(int[][] matrix, int target){
        int row=matrix.length-1, column=0;
        while(row>=0 && column<matrix[0].length){
            if(matrix[row][column] == target)
                return new int[]{row,column};
            else if(matrix[row][column] > target)
                row--;                                                      // Ignoring All elements to right of current element in a row , as all of them are greater than current element
            else
                column++;                                                   // Ignoring all elements above current element in a column , as all of them are smaller than current element.
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[][] matrix= {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        int target = 44;
        System.out.println(Arrays.toString(searchInSortedMatrixP1P2(matrix,target)));
    }
}
