public class Solution { 
    public int missingNumber(int[] nums) { 
        if (nums == null || nums.length == 0) { 
            return 0; 
        } 
        int result = nums.length; 
        int i = 0; 
        for (int num : nums) { 
           result = result^num; 
           result = result^i; 
           i++; 
        } 
        return result; 
    } 
}