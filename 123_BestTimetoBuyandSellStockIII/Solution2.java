public class Solution2 { 
    public int maxProfit(int[] prices) { 
        if (prices == null || prices.length == 0) { 
            return 0; 
        } 
        int N = prices.length; 
        int[] left = new int[N]; 
        int[] right = new int[N]; 
        left[0] = 0; 
        int profit = 0; 
        for (int i = 1; i < N; i++) { 
            int diff = prices[i] - prices[i-1]; 
            profit += diff; 
            if (profit < 0) { 
                profit = 0; 
            } 
            left[i] = Math.max(left[i-1], profit); 
        } 
        profit = 0; 
        right[N-1] = 0; 
        for (int i = N - 2; i >= 0; i--) { 
            int diff = prices[i+1] - prices[i]; 
            profit += diff; 
            if (profit < 0) { 
                profit = 0; 
            } 
            right[i] = Math.max(right[i+1], profit); 
        }
//        for (int x : left) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
//        for (int x : right) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
        int result = 0; 
        for (int i = 0; i < N; i++) { 
            result = Math.max(left[i] + right[i], result); 
        } 
        return result; 
    }
    public static void main(String[] args) {
        int[] prices = {2,1,2,0,1};
        Solution2 s = new Solution2();
        System.out.println(s.maxProfit(prices));
    }
}