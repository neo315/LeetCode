// 220 Contains Duplicate III
//Given an array of integers, 
// find out whether there are two distinct indices i and j in
// the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
public class Solution { 
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { 
        if (nums == null || t < 0) { 
            return false; 
        } 
        TreeSet<Integer> set = new TreeSet<Integer>(); 
        for (int i = 0; i < nums.length; i++) { 
            if (i > k) { 
                set.remove(nums[i - k - 1]); 
            } 
            int leftBound = nums[i] < Integer.MIN_VALUE + t ? Integer.MIN_VALUE : nums[i] - t; 
            int rightBound = nums[i] > Integer.MAX_VALUE - t ? Integer.MAX_VALUE : nums[i] + t; 
            Set<Integer> subset = set.subSet(leftBound, true, rightBound, true); 
            if (!subset.isEmpty()) { 
                return true; 
            } 
            set.add(nums[i]); 
        } 
        return false; 
    } 
}