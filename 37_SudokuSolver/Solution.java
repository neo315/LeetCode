// # 37 Sudoku Solver 
//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//Empty cells are indicated by the character '.'.
//
//You may assume that there will be only one unique solution.
//
//Tags: Backtracking, Hash Table

public class Solution { 
    public void solveSudoku(char[][] board) { 
        if (board == null || board.length != 9 || board[0].length != 9) 
            return; 
        helper(board, 0, 0); 
        return; 
    } 
    private boolean helper(char[][] board, int i, int j) 
    { 
        if (j >= 9)  
            return helper(board, i+1, 0); 
         
        if (i == 9)  
            return true; 
         
        if(board[i][j]=='.')   
        {   
            for(int k=1;k<=9;k++)   
            {   
                board[i][j] = (char)(k+'0');   
                if(isValid(board))   
                {   
                    if(helper(board,i,j+1))   
                        return true;   
                }   
                board[i][j] = '.';   
            }   
        }   
        else return helper(board, i, j+1); 
        return false; 
    } 
  
   private boolean isValid(char[][] board) { 
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
                    if (row[num][i]) 
                        return false; 
                    else row[num][i] = true; 
                     
                    if (column[num][j]) 
                        return false; 
                    else column[num][j] = true; 
                     
                    if (box[num][(i/3)*3+j/3]) 
                        return false; 
                    else box[num][(i/3)*3+j/3] = true; 
                } 
            } 
        return true; 
    } 
}