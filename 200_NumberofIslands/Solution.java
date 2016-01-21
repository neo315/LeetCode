// #200 Number of Islands 
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//You may assume all four edges of the grid are all surrounded by water.
//
//Example 1:
//
//11110
//11010
//11000
//00000
//Answer: 1
//
//Example 2:
//
//11000
//11000
//00100
//00011
//Answer: 3

public class Solution { 
    public int numIslands(char[][] grid) { 
        if (grid == null) return 0; 
        int M = grid.length; 
        if (M == 0) return 0; 
        int N = grid[0].length; 
        boolean[][] visited = new boolean[M][N]; 
        int[][] id = new int[M][N]; 
        int[] count = {0}; 
        for (int i = 0; i < M; i++) 
            for (int j = 0; j < N; j++) 
                { 
                    if (!visited[i][j] && grid[i][j] == '1') 
                    { 
                        dfs(grid, i, j, visited, id, count); 
                        count[0]++; 
 
                    } 
                } 
        return count[0]; 
    } 
     
    private void dfs(char[][] grid, int i, int j, boolean[][] visited, int[][] id, int[] count) 
    { 
         
        visited[i][j] = true; 
        if (grid[i][j] == '1')  
        { 
            id[i][j] = count[0]; 
        if (i < grid.length - 1 && !visited[i+1][j]) dfs(grid, i+1, j, visited, id, count); 
        if (j < grid[0].length - 1 && !visited[i][j+1]) dfs(grid, i, j+1, visited, id, count); 
        if (i > 0 && !visited[i-1][j]) dfs(grid, i-1, j, visited, id, count); 
        if (j > 0 && !visited[i][j-1]) dfs(grid, i, j-1, visited, id, count); 
        } 
        return; 
    } 
}