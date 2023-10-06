package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class spiralTraverse {
    public enum Direction { RIGHT , LEFT , DOWN , UP }

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.

        int n=array.length;
        int m=array[0].length;

        int leftWall = 0;
        int rightWall = m-1;
        int ceiling = 0;
        int floor = n-1;

        int xIndex = 0;
        int yIndex = 0;
        int count=0;

        List<Integer> traversedElements = new ArrayList<>();
        Direction direction = Direction.RIGHT;

        while(count < n*m){
            switch(direction) {
                case RIGHT :
                    while(count < n*m && xIndex <= rightWall){
                        traversedElements.add(array[yIndex][xIndex]);
                        xIndex++;
                        count++;
                    }
                    xIndex = xIndex-1;
                    yIndex = yIndex+1;
                    ceiling = ceiling+1;
                    direction = Direction.DOWN;
                    break;
                case DOWN :
                    while(count < n*m && yIndex <= floor){
                        traversedElements.add(array[yIndex][xIndex]);
                        yIndex++;
                        count++;
                    }
                    yIndex = yIndex-1;
                    xIndex = xIndex-1;
                    rightWall=rightWall-1;
                    direction = Direction.LEFT;
                    break;
                case LEFT :
                    while(count < n*m && xIndex >= leftWall){
                        traversedElements.add(array[yIndex][xIndex]);
                        xIndex--;
                        count++;
                    }
                    xIndex = xIndex+1;
                    yIndex = yIndex-1;
                    floor = floor-1;
                    direction = Direction.UP;
                    break;
                case UP :
                    while(count < n*m && yIndex >= ceiling){
                        traversedElements.add(array[yIndex][xIndex]);
                        yIndex--;
                        count++;
                    }
                    yIndex = yIndex+1;
                    xIndex = xIndex+1;
                    leftWall=leftWall+1;
                    direction = Direction.RIGHT;
                    break;
            }
        }
        return traversedElements;
    }


    public static List<Integer> spiralTraverse1(int[][] array) {
        List<Integer> traversedElements = new ArrayList<>();
        int startRow=0 , startCol=0 , endRow=array.length-1 , endCol=array[0].length-1;

        while(startRow<=endRow && startCol<=endCol){
            for(int col=startCol; col<=endCol ; col++)
                traversedElements.add(array[startRow][col]);
            startRow++;

            for(int row=startRow; row<=endRow; row++)
                traversedElements.add(array[row][endCol]);
            endCol--;

            for(int col=endCol; col>=startCol; col--) {
                if(startRow>endRow)
                    break;
                traversedElements.add(array[endRow][col]);
            }
            endRow--;

            for(int row=endRow; row>=startRow; row--) {
                if(startCol>endCol)
                    break;
                traversedElements.add(array[row][startCol]);
            }
            startCol++;
        }
        return traversedElements;
    }


    public static void main(String args[]) {
        int[][] input =
                new int[][] {
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        List<Integer> actual = spiralTraverse1(input);
        System.out.println(expected);
        System.out.println(actual);
    }

}
