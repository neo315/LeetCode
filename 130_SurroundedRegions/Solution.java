// # 130 Surrounded Regions
//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//For example,
//X X X X
//X O O X
//X X O X
//X O X X
//After running your function, the board should be:
//
//X X X X
//X X X X
//X X X X
//X O X X
//Tags: Breadth-first Search

public class Solution { 
    public void solve(char[][] board) { 
      if (board == null || board.length <= 1 || board[0].length <= 1) return; 
       
      for (int i = 0; i < board.length; i++) 
      { 
          fill(board, i, 0); 
          fill(board, i, board[0].length-1); 
      } 
      for (int i = 0; i < board[0].length; i++) 
      { 
          fill(board, 0, i); 
          fill(board, board.length-1, i); 
      } 
      for (int i = 0; i < board.length; i++) 
        for (int j = 0; j < board[0].length; j++) 
        { 
            if (board[i][j] == 'O') board[i][j] = 'X'; 
            else if (board[i][j] == '#') board[i][j] = 'O'; 
        } 
         
      return; 
    } 
     
    private void fill(char[][] board, int i, int j) 
    { 
        if (board[i][j] != 'O') return; 
        board[i][j] = '#'; 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        int code = i * board[0].length + j; 
        queue.offer(code); 
         
        while (!queue.isEmpty()) 
        { 
            int temp = queue.poll(); 
            int row = temp / board[0].length; 
            int column = temp % board[0].length; 
             
            if (row > 0 && board[row-1][column] == 'O') 
            { 
                queue.offer((row-1)*board[0].length+column); 
                board[row-1][column] = '#'; 
            } 
            if (row < board.length-1 && board[row+1][column] == 'O') 
            { 
                queue.offer((row+1)*board[0].length+column); 
                board[row+1][column] = '#'; 
            } 
            if (column > 0 && board[row][column-1] == 'O') 
            { 
                queue.offer(row*board[0].length+column-1); 
                board[row][column-1] = '#'; 
            } 
            if (column < board[0].length-1 && board[row][column+1] == 'O') 
            { 
                queue.offer(row*board[0].length+column+1); 
                board[row][column+1] = '#'; 
            } 
        } 
        return; 
    } 
}