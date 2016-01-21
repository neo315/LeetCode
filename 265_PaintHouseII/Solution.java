// 265 Paint House II
public class Solution { 
    public int minCostII(int[][] costs) { 
        if (costs == null || costs.length == 0 || costs[0].length == 0) { 
            return 0; 
        } 
        int m = costs.length, n = costs[0].length; 
        int[][] dp = new int[m+1][n]; 
        int[] min = new int[m+1]; 
        int[] secondMin = new int[m+1]; 
        for (int i = 1; i <= m; i++) { 
            min[i] = Integer.MAX_VALUE; 
            secondMin[i] = Integer.MAX_VALUE; 
            for (int j = 0; j < n; j++) { 
                if (min[i-1] == dp[i-1][j]) { 
                    dp[i][j] = costs[i-1][j] + secondMin[i-1]; 
                } 
                else { 
                    dp[i][j] = costs[i-1][j] + min[i-1]; 
                } 
                if (dp[i][j] <= min[i]) { 
                    secondMin[i] = min[i]; 
                    min[i] = dp[i][j]; 
                } 
                else if (dp[i][j] <= secondMin[i]) { 
                    secondMin[i] = dp[i][j]; 
                } 
            } 
        } 
        return min[m]; 
    } 
}