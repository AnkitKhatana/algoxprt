package recursion.medium;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class RevealMinesweeperClean {

    public String[][] revealMinesweeper(String[][] board, int row, int column) {
        // Write your code here.
        if(board[row][column].equals("M"))
            board[row][column] = "X";
        else if(board[row][column].equals("H"))
            revealAdjacentSquares(board,row,column);

        return board;
    }

    public void revealAdjacentSquares(String[][] board, int row, int column) {
        ArrayList<Cell> validNeigbours = getValidNeighbours(board ,row, column);
        int count=0;
        for(Cell neighbour : validNeigbours) {
            if(board[neighbour.row][neighbour.column].equals("M"))
                count++;
        }
        board[row][column] = String.valueOf(count);
        if(count == 0)
            for(Cell neighbour : validNeigbours)
                if(board[neighbour.row][neighbour.column].equals("H"))
                    revealAdjacentSquares(board,neighbour.row,neighbour.column);
    }

    public ArrayList<Cell> getValidNeighbours(String[][] board, int row, int column){
        int[][] directions = new int[][] { {0,-1} , {0,1} , {-1,0} , {1,0} , {-1,-1} , {-1,1} , {1,-1} , {1,1} };
        ArrayList<Cell> validNeighbours = new ArrayList<>();
        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = column + direction[1];
            if(newRow >= 0 && newRow < board.length && newCol>=0 && newCol < board[0].length)
                validNeighbours.add(new Cell(newRow,newCol));
        }
        return validNeighbours;
    }

    static class Cell {
        int row;
        int column;

        Cell(int r, int c){
            this.row = r;
            this.column = c;
        }
    }

    public static void main(String[] args) {
        String[][] board = new String[][] {
                {"H", "H", "H", "H", "M"},
                {"H", "H", "M", "H", "H"},
                {"H", "H", "H", "H", "H"},
                {"H", "H", "H", "H", "H"}};
        int row = 3;
        int column = 4;
        String[][] expected = new String[][] {
                {"0", "1", "H", "H", "M"},
                {"0", "1", "M", "2", "1"},
                {"0", "1", "1", "1", "0"},
                {"0", "0", "0", "0", "0"}};
        String[][] actual = new RevealMinesweeperClean().revealMinesweeper(board, row, column);

        Utils.assertTrue(expected.length == actual.length);
        Utils.assertTrue(expected[0].length == actual[0].length);

        for (int currRow = 0; currRow < expected.length; currRow++) {
            for (int currColumn = 0; currColumn < expected[0].length; currColumn++) {
                Utils.assertTrue(
                        expected[currRow][currColumn].equals(actual[currRow][currColumn])
                );
            }
        }
    }
}
