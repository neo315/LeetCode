// # 62 Unique Path
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. 
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// How many possible unique paths are there?

//  Array Dynamic Programming


public class Solution { 
    public int uniquePaths(int m, int n) { 
        int[] path = new int[m * n]; 
         
        for (int i = 0; i < m; i++) 
            path[i * n] = 1; 
        for (int j = 0; j < n; j++) 
            path[j] = 1; 
             
        for (int i = 1; i < m; i++) 
        { 
            for (int j = 1; j < n; j++) 
            { 
                path[i * n + j] = path[(i - 1) * n + j] + path[i * n + j - 1]; 
            } 
        } 
        return path[m * n - 1]; 
    } 
}