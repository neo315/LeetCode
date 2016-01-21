public class Solution2 { 
    public int longestValidParentheses(String s) { 
        if (s ==  null || s.length() == 0) { 
            return 0; 
        } 
        int N = s.length(); 
        int result = 0; 
        int[] dp = new int[N]; 
        for (int i = 0; i < N; i++) { 
            char c = s.charAt(i); 
            if (c == '(') { 
                dp[i] = 0; 
            } 
            else if (i > 0 && s.charAt(i-1) == '(') { 
                dp[i] = i == 1 ? 2 : dp[i-2] + 2; 
                result = Math.max(result, dp[i]); 
            } 
            else if (i > 0 && s.charAt(i-1) == ')') { 
                if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') { 
                    dp[i] = 2 + dp[i-1]; 
                    if (i-dp[i-1] - 2 >= 0) { 
                        dp[i] += dp[i-dp[i-1] - 2]; 
                    } 
                    result = Math.max(result, dp[i]); 
                } 
            } 
        } 
        return result; 
    } 
}