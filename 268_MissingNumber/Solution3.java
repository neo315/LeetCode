public class Solution3 { 
    public int missingNumber(int[] nums) { 
        if (nums == null || nums.length == 0) { 
            return 0; 
        } 
        int sum = 0; 
        for (int num : nums) { 
           sum += num; 
        } 
        return nums.length * (nums.length + 1) / 2 - sum; 
    } 
}