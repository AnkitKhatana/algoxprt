package recursion.medium;

import util.Utils;

import java.util.Objects;

public class RevealMinesweeper {

    public int isThisCellAMine(String[][] board, int row, int column){
        return Objects.equals(board[row][column], "M") ? 1 : 0;
    }

    public void revealAdjacentCell(String[][] board, int row, int column){
        if(!Objects.equals(board[row][column],"H"))
            return;
        if(row > 0 && row < board.length-1){
            if(column > 0 && column < board[0].length-1){
                int count = isThisCellAMine(board,row-1,column-1) + isThisCellAMine(board , row,column-1) + isThisCellAMine(board ,row+1,column-1)
                        + isThisCellAMine(board , row+1,column) + isThisCellAMine(board , row+1 , column+1) + isThisCellAMine(board,row,column+1)
                        + isThisCellAMine(board,row-1,column+1) + isThisCellAMine(board ,row-1 , column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row-1,column-1);
                revealAdjacentCell(board,row,column-1);
                revealAdjacentCell(board,row+1,column-1);
                revealAdjacentCell(board,row+1,column);
                revealAdjacentCell(board,row+1,column+1);
                revealAdjacentCell(board,row,column+1);
                revealAdjacentCell(board,row-1,column+1);
                revealAdjacentCell(board,row-1,column);
            }
            else if(column == 0 && column == board[0].length-1){
                int count = isThisCellAMine(board , row+1,column) + isThisCellAMine(board ,row-1 , column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row+1,column);
                revealAdjacentCell(board,row-1,column);
            }
            else if(column == 0) {
                int count = isThisCellAMine(board , row+1,column) + isThisCellAMine(board , row+1 , column+1) + isThisCellAMine(board,row,column+1)
                        + isThisCellAMine(board,row-1,column+1) + isThisCellAMine(board ,row-1 , column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row+1,column);
                revealAdjacentCell(board,row+1,column+1);
                revealAdjacentCell(board,row,column+1);
                revealAdjacentCell(board,row-1,column+1);
                revealAdjacentCell(board,row-1,column);
            }
            else if(column == board[0].length-1){
                int count = isThisCellAMine(board,row-1,column-1) + isThisCellAMine(board , row,column-1) + isThisCellAMine(board ,row+1,column-1)
                        + isThisCellAMine(board , row+1,column) + isThisCellAMine(board ,row-1 , column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row-1,column-1);
                revealAdjacentCell(board,row,column-1);
                revealAdjacentCell(board,row+1,column-1);
                revealAdjacentCell(board,row+1,column);
                revealAdjacentCell(board,row-1,column);
            }
        }
        else if(row == 0 && row == board.length-1) {
            if(column > 0 && column < board[0].length-1){
                int count = isThisCellAMine(board , row,column-1) + isThisCellAMine(board,row,column+1);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row,column-1);
                revealAdjacentCell(board,row,column+1);
            }
            else if(column == 0 && column == board[0].length-1){
                int count = 0;
                board[row][column] = String.valueOf(count);
            }
            else if(column == 0) {
                int count = isThisCellAMine(board,row,column+1);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row,column+1);
            }
            else if(column == board[0].length-1){
                int count = isThisCellAMine(board , row,column-1);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row,column-1);
            }
        }
        else if(row == 0) {
            if(column > 0 && column < board[0].length-1){
                int count = isThisCellAMine(board , row,column-1) + isThisCellAMine(board ,row+1,column-1)
                        + isThisCellAMine(board , row+1,column) + isThisCellAMine(board , row+1 , column+1) + isThisCellAMine(board,row,column+1);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row,column-1);
                revealAdjacentCell(board,row+1,column-1);
                revealAdjacentCell(board,row+1,column);
                revealAdjacentCell(board,row+1,column+1);
                revealAdjacentCell(board,row,column+1);
            }
            else if(column == 0 && column == board[0].length-1){
                int count = isThisCellAMine(board , row+1,column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row+1,column);
            }
            else if(column == 0) {
                int count = isThisCellAMine(board , row+1,column) + isThisCellAMine(board , row+1 , column+1) + isThisCellAMine(board,row,column+1);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row+1,column);
                revealAdjacentCell(board,row+1,column+1);
                revealAdjacentCell(board,row,column+1);
            }
            else if(column == board[0].length-1){
                int count = isThisCellAMine(board , row,column-1) + isThisCellAMine(board ,row+1,column-1)
                        + isThisCellAMine(board , row+1,column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row,column-1);
                revealAdjacentCell(board,row+1,column-1);
                revealAdjacentCell(board,row+1,column);
            }
        }
        else if(row == board.length-1) {
            if(column > 0 && column < board[0].length-1){
                int count = isThisCellAMine(board,row-1,column-1) + isThisCellAMine(board , row,column-1) + isThisCellAMine(board,row,column+1)
                        + isThisCellAMine(board,row-1,column+1) + isThisCellAMine(board ,row-1 , column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row-1,column-1);
                revealAdjacentCell(board,row,column-1);
                revealAdjacentCell(board,row,column+1);
                revealAdjacentCell(board,row-1,column+1);
                revealAdjacentCell(board,row-1,column);
            }
            else if(column == 0 && column == board[0].length-1){
                int count = isThisCellAMine(board ,row-1 , column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row-1,column);
            }
            else if(column == 0) {
                int count = isThisCellAMine(board,row,column+1) + isThisCellAMine(board,row-1,column+1) + isThisCellAMine(board ,row-1 , column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row,column+1);
                revealAdjacentCell(board,row-1,column+1);
                revealAdjacentCell(board,row-1,column);
            }
            else if(column == board[0].length-1){
                int count = isThisCellAMine(board,row-1,column-1) + isThisCellAMine(board , row,column-1) + isThisCellAMine(board ,row-1 , column);
                board[row][column] = String.valueOf(count);
                if(count > 0)
                    return ;
                revealAdjacentCell(board,row-1,column-1);
                revealAdjacentCell(board,row,column-1);
                revealAdjacentCell(board,row-1,column);
            }
        }
    }
    public String[][] revealMinesweeper(String[][] board, int row, int column) {
        // Write your code here.
        if(Objects.equals(board[row][column], "M")){
            board[row][column] = "X";
            return board;
        }
        if(Objects.equals(board[row][column], "H")){
            revealAdjacentCell(board, row, column);
        }
        return board;
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
        String[][] actual = new RevealMinesweeper().revealMinesweeper(board, row, column);

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
