// # 79 Word Search 
//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//For example,
//Given board =
//
//[
//  ["ABCE"],
//  ["SFCS"],
//  ["ADEE"]
//]
//word = "ABCCED", -> returns true,
//word = "SEE", -> returns true,
//word = "ABCB", -> returns false.
// Tags: Array, Backtracking

public class Solution { 
    public boolean exist(char[][] board, String word) { 
        if (board == null || word == null) return false; 
        int M = board.length; 
        if (M == 0) return false; 
        int N = board[0].length; 
        boolean[][] visited = new boolean[M][N]; 
 
        for (int i = 0; i < M; i++) 
            for (int j = 0; j < N; j++)  
                    if (helper(i, j, board, visited, word, 0)) return true; 
        return false; 
    } 
     
    private boolean helper(int i, int j, char[][] board, boolean[][] visited, String word, int index) 
    { 
        if (word.length() == index) 
            return true; 
 
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index))   
            return false;   
             
            visited[i][j] = true; 
        boolean   res = helper(i-1, j, board, visited, word, index+1) || 
                  helper(i, j-1, board, visited, word, index+1) || 
                  helper(i+1, j, board, visited, word, index+1) || 
                  helper(i, j+1, board, visited, word, index+1); 
            visited[i][j] = false; 
        return res; 
 
    } 
}