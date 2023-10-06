package graphs.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RiverSizes {

    public static int findRiverSize(int[][] matrix, int i, int j){
        int left=0,right=0,top=0,bottom=0;
        matrix[i][j] = -1;
        if(i>0 && matrix[i-1][j]==1)
            top=findRiverSize(matrix,i-1,j);
        if(i<matrix.length-1 && matrix[i+1][j]==1)
            bottom=findRiverSize(matrix,i+1,j);
        if(j>0 && matrix[i][j-1] == 1)
            left=findRiverSize(matrix,i,j-1);
        if(j<matrix[i].length-1 && matrix[i][j+1] == 1)
            right=findRiverSize(matrix,i,j+1);
        return 1+top+bottom+left+right;
    }
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        List<Integer> sizes = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 1)
                    sizes.add(findRiverSize(matrix,i,j));
            }
        }
        return sizes;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        int[] expected = {1, 2, 2, 2, 5};
        List<Integer> output = riverSizes(input);
        Collections.sort(output);
        Utils.assertTrue(compare(output, expected));
    }

    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
