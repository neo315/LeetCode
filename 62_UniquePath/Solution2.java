// only need o(min(m,n)) space since the path[n] can be reused
    
    public class Solution2 { 
    public int uniquePaths(int m, int n) { 
        int[] path = new int[n]; 
        for (int i = 0; i < n; i++) path[i] = 1; 
         
        for (int i = 1; i < m; i++) 
        { 
            for (int j = 1; j < n; j++) 
            { 
                path[j] = path[j] + path[j - 1]; 
            } 
        } 
        return path[n - 1]; 
    } 
}