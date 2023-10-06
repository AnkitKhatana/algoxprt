package searching.medium;

import java.util.Arrays;

public class SearchSortedMatrix {

    public static int[] binarySearchColumn(int[][] matrix, int target, int width, int heightStart, int heightEnd){
        while(heightStart<=heightEnd){
            int iMiddle=(heightStart+heightEnd)/2;
            if(matrix[iMiddle][width] == target)
                return new int[] {iMiddle,width};
            else if(matrix[iMiddle][width] > target)
                heightEnd=iMiddle-1;
            else
                heightStart=iMiddle+1;
        }
        return new int[] {-2,-2};
    }

    public static int[] binarySearchRow(int[][] matrix, int target, int height, int widthStart, int widthEnd){
        while(widthStart<=widthEnd){
            int jMiddle=(widthStart+widthEnd)/2;
            if(matrix[height][jMiddle] == target)
                return new int[] {height,jMiddle};
            else if(matrix[height][jMiddle] > target)
                widthEnd=jMiddle-1;
            else
                widthStart=jMiddle+1;
        }
        return new int[] {-2,-2};
    }
    public static int[] checkEdge(int[][] matrix, int target, int widthStart, int widthEnd, int heightStart, int heightEnd){
        if(widthStart==widthEnd && heightStart==heightEnd)
            return new int[] {-2,-2};
        else if(widthStart==widthEnd)
            return binarySearchColumn(matrix,target,widthStart,heightStart,heightEnd);
        else if(heightStart==heightEnd)
            return binarySearchRow(matrix,target,heightStart,widthStart,widthEnd);
        else
            return new int[] {-1,-1};
    }
    public static int[] searchSortedMatrix(int[][] matrix, int target, int widthStart, int widthEnd, int heightStart, int heightEnd){
        int jMiddle = (widthStart+widthEnd)/2;
        int iMiddle = (heightStart+heightEnd)/2;
        if(target == matrix[iMiddle][jMiddle])
            return new int[] {iMiddle,jMiddle};
        else if(target > matrix[iMiddle][jMiddle]){
            int[] returned = checkEdge(matrix,target,widthStart,widthEnd,heightStart,heightEnd);
            if(returned[0]==-2 && returned[1]==-2)
                return new int[] {-1,-1};
            if(returned[0] == -1 && returned[1] == -1)
                returned = searchSortedMatrix(matrix, target, jMiddle + 1, widthEnd, heightStart, iMiddle);            // traverse Top-right
            if(returned[0] == -1 && returned[1] == -1)
                returned = searchSortedMatrix(matrix,target,widthStart,jMiddle,iMiddle+1,heightEnd);            // traverse Bottom-left
            if(returned[0] == -1 && returned[1] == -1)
                returned = searchSortedMatrix(matrix,target,jMiddle+1,widthEnd,iMiddle+1,heightEnd);   // traverse Bottom-right
            return returned;
        }
        else {
            int[] returned = checkEdge(matrix,target,widthStart,widthEnd,heightStart,heightEnd);
            if(returned[0]==-2 && returned[1]==-2)
                return new int[] {-1,-1};
            if(returned[0] == -1 && returned[1] == -1)
                returned = searchSortedMatrix(matrix,target,widthStart,jMiddle,heightStart,iMiddle);  // traverse Top-left
            if(returned[0] == -1 && returned[1] == -1)
                returned = searchSortedMatrix(matrix,target,jMiddle+1,widthEnd,heightStart,iMiddle);            // traverse Top-right
            if(returned[0] == -1 && returned[1] == -1)
                returned = searchSortedMatrix(matrix,target,widthStart,jMiddle,iMiddle+1,heightEnd);            // traverse Bottom-left
            return returned;
        }
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        return searchSortedMatrix(matrix,target,0,matrix[0].length-1,0,matrix.length-1);
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
        System.out.println(Arrays.toString(searchInSortedMatrix(matrix,target)));
    }
}
