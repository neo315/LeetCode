// #64 Minimum Path Sum 
// Given a m x n grid filled with non-negative numbers, 
// find a path from top left to bottom right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

// Tags:  Array Dynamic Programming

public class Solution { 
    public int minPathSum(int[][] grid) { 
         
        int m = grid.length; 
        int n = grid[0].length; 
        int[] path = new int[m * n]; 
         
        path[0] = grid[0][0]; 
        for (int j = 1; j < n; j++) 
            path[j] = path[j - 1] + grid[0][j]; 
         
        for (int i = 1; i < m; i++) 
            path[i * n] = path[(i - 1) * n] + grid[i][0]; 
         
        for (int i = 1; i < m; i++) 
        { 
            for (int j = 1; j < n; j++) 
            { 
                if (path[(i - 1) * n + j] < path[i * n + j - 1]) path[i * n + j] = grid[i][j] + path[(i - 1) * n + j]; 
                else path[i * n + j] = grid[i][j] + path[i * n + j - 1]; 
            } 
        } 
         return path[m * n - 1]; 
    } 
}