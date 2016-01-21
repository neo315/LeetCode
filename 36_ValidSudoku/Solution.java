// #36 Valid Sudoku 
//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//
//A partially filled sudoku which is valid.
//
//Note:
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
// Tags:  Hash Table
public class Solution { 
    public boolean isValidSudoku(char[][] board) { 
        if (board == null || board.length != 9 || board[0].length != 9) return false; 
         
        boolean[][] row = new boolean[9][9]; 
        boolean[][] column = new boolean[9][9]; 
        boolean[][] box = new boolean[9][9]; 
         
        for (int i = 0; i < 9; i ++) 
            for (int j = 0; j < 9; j++) 
            { 
                if (board[i][j] != '.') 
                { 
                    int num = (int) (board[i][j] - '1'); 
                    if (row[num][i] == true) 
                        return false; 
                    else row[num][i] = true; 
                     
                    if (column[num][j] == true) 
                        return false; 
                    else column[num][j] = true; 
                     
                    if (box[num][(i/3)*3+j/3] == true) 
                        return false; 
                    else box[num][(i/3)*3+j/3] = true; 
                } 
            } 
        return true; 
    } 
}