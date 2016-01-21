public class Solution2 {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if (s == null || s.length() == 0) {
            return true;
        }
        if (dict == null || dict.size() == 0) {
            return false;
        }
        int maxlength = 0;
        for (String x : dict) {
            maxlength = Math.max(maxlength, x.length());
        }
        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0 && j >= i-maxlength+1; j--) {
                if (dp[j] && dict.contains(s.substring(j, i+1))) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
