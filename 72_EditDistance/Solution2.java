public class Solution2 { 
    public int minDistance(String word1, String word2) { 
        if (word1 == null && word2 == null) { 
            return 0; 
        } 
        if (word1 == null) { 
            return word2.length(); 
        } 
        if (word2 == null) { 
            return word1.length(); 
        } 
        int m = word1.length(), n = word2.length(); 
         
        int[] dp = new int[n+1]; 
        for (int j = 0; j <= n; j++) { 
            dp[j] = j; 
        } 
 
        for (int i = 1; i <= m; i++) { 
            int prev = i; 
            for (int j = 1; j <= n; j++) { 
                int cur = 0; 
                if (word1.charAt(i-1) == word2.charAt(j-1)) { 
                    cur = dp[j-1]; 
                } 
                else { 
                    cur = Math.min(prev, Math.min(dp[j-1], dp[j])) + 1; 
                } 
                dp[j-1] = prev; 
                prev = cur; 
            } 
            dp[n] = prev; 
        } 
        return dp[n]; 
    } 
}