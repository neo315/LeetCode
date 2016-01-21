// 283 Move Zeroes

public class Solution { 
    public void moveZeroes(int[] nums) { 
        if (nums == null || nums.length == 0) { 
            return; 
        } 
        int N = nums.length; 
        int slow = 0; 
        for (int fast = 0; fast < N; fast++) { 
            if (nums[fast] == 0) { 
                continue; 
            } 
            exch(nums, slow, fast); 
            slow++; 
        } 
        return; 
    } 
    private void exch(int[] nums, int i, int j) { 
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    } 
}