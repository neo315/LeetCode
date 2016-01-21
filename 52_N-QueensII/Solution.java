public class Solution { 
    public static int totalNQueens(int n) { 
        int[] total = {0}; 
        helper(n, 0, new int[n], total); 
        return total[0]; 
    } 
     
    private static void helper(int n, int row, int[] columnForRow, int[] total) 
    { 
        if (row == n)  
        { 
            total[0] = total[0] + 1; 
            return; 
        } 
        for (int i = 0; i < n; i++) 
        { 
            columnForRow[row] = i; 
            if (check(row, columnForRow))  
                helper(n, row+1, columnForRow, total); 
        } 
    } 
     
    private static boolean check(int row, int[] columnForRow) 
    { 
        for (int i = 0; i < row; i++) 
            if (columnForRow[i] == columnForRow[row] || Math.abs(columnForRow[i]-columnForRow[row]) == row - i)  
                return false; 
        return true; 
    }
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        StdOut.println(Solution.totalNQueens(n));
    }
}