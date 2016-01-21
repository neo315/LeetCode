// # 213 House Robber II 
//Note: This is an extension of House Robber.
//
//After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//Credits:
//Special thanks to @Freezen for adding this problem and creating all test cases.
//
//Tags: Dynamic Programming


public class Solution { 
    public int rob(int[] nums) { 
        if (nums == null || nums.length == 0) return 0; 
        int N = nums.length; 
        if (N == 1) return nums[0]; 
        return Math.max(robLinear(nums, 0, N-1), robLinear(nums, 1, N)); 
    } 
     
    private int robLinear(int[] nums, int start, int end) 
    { 
        if (start > end) return 0; 
         
        int odd = 0; 
        int even = 0; 
         
        for (int i = start; i < end; i++) 
        { 
            if (i % 2 == 0) even = Math.max(even + nums[i], odd); 
            else odd = Math.max(odd + nums[i], even); 
        } 
        return Math.max(odd, even); 
    } 
}