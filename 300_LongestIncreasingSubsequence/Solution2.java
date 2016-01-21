// The idea is that as you iterate the sequence, 
// you keep track of the minimum value a subsequence of given length might end with, 
// for all so far possible subsequence lengths. So dp[i] is the minimum value a subsequence of length i+1 might end with. 
// Having this info, for each new number we iterate to, 
// we can determine the longest subsequence where it can be appended using binary search. 
// The final answer is the length of the longest subsequence we found so far.
public class Solution2 { 
    public int lengthOfLIS(int[] nums) { 
        if (nums == null || nums.length == 0) { 
            return 0; 
        } 
        int n = nums.length; 
        int[] dp = new int[n]; 
        int result = 1; 
        dp[0] = 1; 
        int len = 0; 
        for (int x : nums) { 
            int i = Arrays.binarySearch(dp, 0, len, x); 
            if (i < 0) { 
                i = - (i + 1); 
            } 
            dp[i] = x; 
            if (i == len) len++; 
        } 
        return len; 
    } 
}