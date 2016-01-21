// 174 Dungeon Game
//The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room 
//and must fight his way through the dungeon to rescue the princess.
//
//The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//
//Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
//
//In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//
//
//Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
//

public class Solution { 
    public int calculateMinimumHP(int[][] dungeon) { 
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) { 
            return 0; 
        } 
        int m = dungeon.length, n = dungeon[0].length; 
        int[][] dp = new int[m][n]; 
        dp[m-1][n-1] = dungeon[m-1][n-1] > 0 ? 0 : -dungeon[m-1][n-1]; 
        for (int j = n - 2; j >= 0; j--) { 
            if (dungeon[m-1][j] < dp[m-1][j+1]) { 
                dp[m-1][j] = dp[m-1][j+1] - dungeon[m-1][j]; 
            } 
        } 
        for (int i = m - 2; i >= 0; i--) { 
            dp[i][n-1] = dungeon[i][n-1] > dp[i+1][n-1] ? 0 : (dp[i+1][n-1] -dungeon[i][n-1]); 
            for (int j = n - 2; j >= 0; j--) { 
                int cost = Math.min(dp[i][j+1], dp[i+1][j]); 
                if (dungeon[i][j] < cost) { 
                    dp[i][j] = cost - dungeon[i][j]; 
                } 
            } 
        } 
        return dp[0][0] + 1; 
    } 
}
