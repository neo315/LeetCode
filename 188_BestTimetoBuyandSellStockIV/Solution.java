// 188 Best Time to Buy and Sell Stock IV
public class Solution { 
    public int maxProfit(int k, int[] prices) { 
        if (prices == null || prices.length <= 1) { 
            return 0; 
        } 
        int N = prices.length; 
        if (k > N / 2) { 
           return quickSolve(prices); 
        } 
        int[][] dp = new int[k+1][N]; 
        int maxProfit = 0; 
        dp[0][0] = 0; 
        for (int i = 1; i <= k; i++) { 
            int tmpMax = dp[i-1][0] - prices[0]; 
            for (int j = 1; j < N; j++) { 
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + tmpMax); 
                tmpMax = Math.max(tmpMax, dp[i-1][j] - prices[j]); 
                maxProfit = Math.max(maxProfit, dp[i][j]);  
            } 
        } 
        return maxProfit; 
    } 
    private int quickSolve(int[] prices) { 
        int profit = 0; 
        for (int i = 1; i < prices.length; i++) { 
            if (prices[i] - prices[i-1] > 0) { 
                profit += prices[i] - prices[i-1]; 
            } 
        } 
        return profit; 
    } 
}