package graphs.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class RemoveIslands {

    public void colourAdjacentCoordinates(int[][] matrix , int i , int j, List<int[]> coOrdinatesOfIslandsTouchingBorder , int value){
        matrix[i][j] = value;
        coOrdinatesOfIslandsTouchingBorder.add(new int[] {i,j});
        if(i > 1 && matrix[i-1][j] == 1)
            colourAdjacentCoordinates(matrix,i-1,j,coOrdinatesOfIslandsTouchingBorder,value);
        if(i < matrix.length-2 && matrix[i+1][j] == 1)
            colourAdjacentCoordinates(matrix,i+1, j, coOrdinatesOfIslandsTouchingBorder, value);
        if(j > 1 && matrix[i][j-1] == 1)
            colourAdjacentCoordinates(matrix,i,j-1, coOrdinatesOfIslandsTouchingBorder,value);
        if(j < matrix[i].length-2 && matrix[i][j+1] == 1)
            colourAdjacentCoordinates(matrix,i,j+1,coOrdinatesOfIslandsTouchingBorder,value);
    }

    public void colourIslandsTouchingBorder(int[][] matrix , List<int []> coOrdinatesOfIslandsTouchingBorder) {
        if(matrix[0].length  > 2)
            for(int i=0; i<matrix.length; i++){
                if(matrix[i][0] == 1 && matrix[i][1] == 1)
                    colourAdjacentCoordinates(matrix,i,1,coOrdinatesOfIslandsTouchingBorder,-1);
                if(matrix[i][matrix[i].length-1] == 1 && matrix[i][matrix[i].length-2] == 1)
                    colourAdjacentCoordinates(matrix,i,matrix[i].length-2,coOrdinatesOfIslandsTouchingBorder,-1);
            }
        if(matrix.length > 2)
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[0][j] == 1 && matrix[1][j] == 1)
                    colourAdjacentCoordinates(matrix,1,j,coOrdinatesOfIslandsTouchingBorder,-1);
                if(matrix[matrix.length-1][j] == 1 && matrix[matrix.length-2][j] ==1)
                    colourAdjacentCoordinates(matrix,matrix.length-2 , j, coOrdinatesOfIslandsTouchingBorder, -1);
            }
    }
    public int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        List<int[]> coOrdinatesOfIslandsTouchingBorder = new ArrayList<>();
        colourIslandsTouchingBorder(matrix,coOrdinatesOfIslandsTouchingBorder);
        for(int i=1; i<matrix.length-1; i++){
            for(int j=1; matrix.length>1 && j<matrix[i].length-1; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int[] coOrdinates : coOrdinatesOfIslandsTouchingBorder){
            matrix[coOrdinates[0]][coOrdinates[1]] = 1;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1},
        };
        int[][] expected = new int[][] {
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1},
        };
        int[][] actual = new RemoveIslands().removeIslands(input);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                Utils.assertTrue(actual[i][j] == expected[i][j]);
            }
        }
    }
}
