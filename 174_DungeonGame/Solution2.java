public class Solution2 { 
    public int calculateMinimumHP(int[][] dungeon) { 
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) { 
            return 0; 
        } 
        int m = dungeon.length, n = dungeon[0].length; 
        int[] dp = new int[n]; 
        dp[n-1] = (dungeon[m-1][n-1] > 0) ? 0 : -dungeon[m-1][n-1]; 
        for (int j = n - 2; j >= 0; j--) { 
            if (dungeon[m-1][j] < dp[j+1]) { 
                dp[j] = dp[j+1] - dungeon[m-1][j]; 
            } 
            else { 
                    dp[j] = 0; 
            } 
        } 
        for (int i = m - 2; i >= 0; i--) { 
            dp[n-1] = dungeon[i][n-1] > dp[n-1] ? 0 : (dp[n-1] -dungeon[i][n-1]); 
            for (int j = n - 2; j >= 0; j--) { 
                int cost = Math.min(dp[j+1], dp[j]); 
                if (dungeon[i][j] < cost) { 
                    dp[j] = cost - dungeon[i][j]; 
                } 
                else { 
                    dp[j] = 0; 
                } 
            } 
        } 
        return dp[0] + 1; 
    } 
}