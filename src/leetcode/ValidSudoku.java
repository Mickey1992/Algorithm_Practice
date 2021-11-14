package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku2(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        // Check rows
        for(int i = 0; i < 9; i++){
            Set<Character> chk = new HashSet<>();
            for(int j =0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(chk.contains(board[i][j])) return false;
                chk.add(board[i][j]);
            }
        }

        // Check columns
        for(int i = 0; i < 9; i++){
            Set<Character> chk = new HashSet<>();
            for(int j =0; j < 9; j++){
                if(board[j][i] == '.') continue;
                if(chk.contains(board[j][i])) return false;
                chk.add(board[j][i]);
            }
        }

        // Check square
        for(int i = 0; i < 9; i+=3){
            for(int j =0; j < 9; j+=3){
                if (!chkSquare(board, i, j)) return false;
            }
        }
        return true;
    }

    public static boolean chkSquare(char[][] board, int x, int y){
        Set<Character> chk = new HashSet<>();
        for(int i = 0; i < 3; i++){
            for(int j =0; j < 3; j++){
                if(board[x+i][y+j] == '.') continue;
                if(chk.contains(board[x+i][y+j])) return false;
                chk.add(board[x+i][y+j]);
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        int[][] chkRow = new int [9][9];
        int[][] chkCol = new int [9][9];
        int[][] chkSquare = new int [9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '1' ;
                if(chkRow[i][num]++ > 0 ) return false;
                if(chkCol[j][num]++ > 0 ) return false;
                if(chkSquare[(i/3) * 3 + (j/3)][num]++ > 0 ) return false;
            }
        }
        return true;
    }
}
