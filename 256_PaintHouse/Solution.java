//256 Paint House
public class Solution { 
    public int minCost(int[][] costs) { 
        if (costs == null || costs.length == 0 || costs[0].length != 3) { 
            return 0; 
        } 
        int m = costs.length, n = costs[0].length; 
        int[][] dp = new int[m+1][n]; 
        for (int i = 1; i <= m; i++) { 
            for (int j = 0; j < n; j++) { 
                int previousCost = Integer.MAX_VALUE; 
                for (int k = 0; k < n; k++) { 
                    if (k == j) continue; 
                    previousCost = Math.min(previousCost, dp[i-1][k]); 
                } 
                dp[i][j] = costs[i-1][j] + previousCost; 
            } 
        } 
        int result = dp[m][0]; 
        for (int i = 0; i < n; i++) { 
            result = Math.min(dp[m][i], result); 
        } 
        return result; 
    } 
}