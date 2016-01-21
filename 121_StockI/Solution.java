// #121 Best Time to Buy and Sell Stock 
// Say you have an array for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction 
// (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
// Tags, Array Dynamic Programming

public class Solution { 
    public int maxProfit(int[] prices) { 
        int sell = 0; 
        int buy = 0; 
        int finalBuy = 0; 
        int profit = 0; 
 
        for (int i = 0; i < prices.length; i++) 
        { 
            if (prices[i] < prices[buy])  
            { 
                buy = i; 
                continue; 
            } 
            if (prices[i] - prices[buy] >= profit) 
            { 
                profit = prices[i] - prices[buy];   
                sell = i; 
                finalBuy = buy; 
            } 
        } 
        return profit; 
    } 
}

