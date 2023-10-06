package arrays.easy;

import util.Utils;

public class TransposeMatrix {
    public int[][] transposeMatrix(int[][] matrix) {
        // Write your code here.
        int height = matrix.length;
        int width = matrix[0].length;
        int [][] transpose = new int[width][height];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                transpose[j][i]= matrix[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = new int[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] actual = new TransposeMatrix().transposeMatrix(input);
        Utils.assertTrue(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                Utils.assertTrue(expected[i][j] == actual[i][j]);
            }
        }
    }
}
