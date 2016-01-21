// # 123 Best Time to Buy and Sell Stock III
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//
//Tags: Array, Dynamic Programming

public class Solution { 
    public int maxProfit(int[] prices) { 
        if (prices == null || prices.length <= 1) 
            return 0; 
        int res = 0;     
        int[] left = new int[prices.length]; 
        int[] right = new int[prices.length]; 
         
        process(prices, left, right); 
         
        for (int i = 0; i < prices.length; i++) 
            res = Math.max(res, left[i] + right[i]); 
        return res; 
    } 
     
    private void process(int[] prices, int[] left, int[] right) 
    { 
        int min = prices[0]; 
        left[0] = 0; 
         
        for (int i = 1; i < left.length; i++) 
        { 
            left[i] = Math.max(left[i-1], prices[i]-min); 
            min = Math.min(min, prices[i]); 
        } 
         
        int max = prices[prices.length-1]; 
        right[right.length-1] = 0; 
         
        for (int i = right.length-2; i>=0; i--) 
        { 
            right[i] = Math.max(right[i+1], max-prices[i]); 
            max = Math.max(prices[i], max); 
        } 
        return; 
    } 
}