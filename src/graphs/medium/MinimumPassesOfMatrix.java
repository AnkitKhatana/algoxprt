package graphs.medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumPassesOfMatrix {

    public void populateSteps(int[][] steps , int i, int j, int count) {
        if(steps[i][j] <= count && count != 0)
            return;
        steps[i][j] = count;
        if(i>0)
            populateSteps(steps,i-1,j,count+1);
        if(i<steps.length-1)
            populateSteps(steps,i+1,j,count+1);
        if(j>0)
            populateSteps(steps,i,j-1,count+1);
        if(j<steps[i].length-1)
            populateSteps(steps,i,j+1,count+1);
    }
    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        int[][] steps = new int[matrix.length][matrix[0].length];
        List<int[]> roots = new ArrayList<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0)
                    steps[i][j] = -1;
                else if(matrix[i][j] < 0)
                    steps[i][j] = Integer.MAX_VALUE;
                else {
                    steps[i][j] = 0;
                    roots.add(new int[]{i,j});
                }
            }
        }

        for(int[] root : roots){
            populateSteps(steps,root[0],root[1],0);
        }

        int maxSteps = 0;

        for(int i=0; i< steps.length; i++){
            for(int j=0; j<steps[i].length; j++){
                if(steps[i][j] == Integer.MAX_VALUE)
                    return -1;
                if(steps[i][j] > 0 && maxSteps < steps[i][j])
                    maxSteps=steps[i][j];
            }
        }

        return maxSteps;
    }

    public static void main(String[] args) {
        int[][] matrix =
                new int[][] {{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int expected = 3;
        int actual = new MinimumPassesOfMatrix().minimumPassesOfMatrix(matrix);
        assert (expected == actual);
    }
}
