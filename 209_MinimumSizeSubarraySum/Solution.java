// # 209 Minimum Size Subarray Sum 
//Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ³ s. If there isn't one, return 0 instead.
//
//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
//
//Tags: Array, Two Pointers, Binary Search

public class Solution { 
    public int minSubArrayLen(int s, int[] nums) { 
        int min = Integer.MAX_VALUE; 
        int left = 0; 
        int right = 0; 
        int sum = 0; 
         
        while (right < nums.length) 
        { 
            while (sum < s && right < nums.length)  
            { 
                sum += nums[right]; 
                right++; 
            } 
            while (sum >= s && left <= right) 
            { 
                if (right - left < min) min = right - left; 
                sum -= nums[left]; 
                left++; 
            } 
        } 
         
        if (min == Integer.MAX_VALUE) return 0; 
        else return min; 
    } 
}