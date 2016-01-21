public class Solution2 { 
    public int minPathSum(int[][] grid) { 
         
        int m = grid.length; 
        int n = grid[0].length; 
        int[] path = new int[n]; 
         
        path[0] = grid[0][0]; 
        for (int j = 1; j < n; j++) 
            path[j] = path[j - 1] + grid[0][j]; 
         
         
        for (int i = 1; i < m; i++) 
        { 
            path[0] = grid[i][0] + path[0]; 
            for (int j = 1; j < n; j++) 
            { 
                if (path[j] < path[j - 1]) path[j] = grid[i][j] + path[j]; 
                else path[j] = grid[i][j] + path[j - 1]; 
            } 
        } 
         return path[n - 1]; 
    } 
}