// 259 3Sum Smaller
//Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//
//For example, given nums = [-2, 0, 1, 3], and target = 2.
//
//Return 2. Because there are two triplets which sums are less than 2:
//
//[-2, 0, 1]
//[-2, 0, 3]
//Follow up:
//Could you solve it in O(n2) runtime?
public class Solution { 
    public int threeSumSmaller(int[] nums, int target) { 
        if (nums == null || nums.length == 0) { 
            return 0;     
        }  
        int cnt = 0; 
        Arrays.sort(nums); 
        for (int i = 0; i < nums.length; i++) { 
            int negate = target - nums[i]; 
            int left = i + 1, right = nums.length - 1; 
            while (left < right) { 
                if (nums[left] + nums[right] >= negate) { 
                    right--; 
                } 
                else { 
                    cnt += right - left; 
                    left++; 
                } 
            } 
        } 
        return cnt; 
    } 
}