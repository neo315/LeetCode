//// #51 N-Queens
//The n-queens puzzle is the problem of placing n queens on an n?n chessboard such that no two queens attack each other.
//Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//For example,
//There exist two distinct solutions to the 4-queens puzzle:[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//// Tags:  Backtracking

public class Solution { 
    public List<String[]> solveNQueens(int n) { 
        List<String[]> result = new ArrayList<String[]>(); 
         
        helper(n, 0, new int[n], result); 
        return result; 
    } 
     
    private void helper(int n, int row, int[] columnForRow, List<String[]> result) 
    { 
        if (row == n) 
        { 
            String[] item = new String[n]; 
             
            for (int i = 0; i < n; i++) 
            { 
                StringBuilder sb = new StringBuilder(); 
                 
                for (int j = 0; j < n; j++) 
                { 
                    if (columnForRow[i] == j) sb.append('Q'); 
                    else sb.append('.'); 
                     
                } 
                item[i] = sb.toString(); 
            } 
            result.add(item); 
            return; 
        } 
         
       for (int i = 0; i < n; i++) 
       { 
           columnForRow[row] = i; 
           if (check(row, columnForRow))  
                helper(n, row+1, columnForRow, result); 
       } 
    } 
     
    private boolean check(int row, int[] columnForRow) 
    { 
        for (int i = 0; i < row; i++) 
            if (columnForRow[i] == columnForRow[row] || Math.abs(columnForRow[i]-columnForRow[row]) == row - i)  
                return false; 
        return true; 
    } 
}