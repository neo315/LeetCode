public class Solution2 { 
    public int[] productExceptSelf(int[] nums) { 
        if (nums == null || nums.length == 0) { 
            return null; 
        } 
        int N = nums.length; 
        int[] result = new int[N]; 
        result[0] = 1; 
        for (int i = 1; i < N; i++) { 
            result[i] = result[i-1] * nums[i-1]; 
        } 
        int right = 1; 
        for (int i = N - 1; i >= 0; i--) { 
            result[i] *= right; 
            right *= nums[i]; 
        } 
        return result; 
    } 
}