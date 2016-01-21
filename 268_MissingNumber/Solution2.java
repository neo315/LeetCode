// # 268 Missing Number 
//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//For example,
//Given nums = [0, 1, 3] return 2.
//
//Note:
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
//
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
//
//Tags Array Math Bit Manipulation


public class Solution2 { 
    public int missingNumber(int[] nums) { 
        if (nums == null || nums.length == 0) { 
            return 0; 
        } 
        for (int i = 0; i < nums.length; i++) { 
            while (nums[i] > 0 && nums[i] != i + 1) { 
                int temp = nums[i]; 
                nums[i] = nums[nums[i]-1]; 
                nums[temp-1] = temp; 
            } 
        } 
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] == 0) { 
                return i+1; 
            } 
        } 
        return 0; 
    } 
}