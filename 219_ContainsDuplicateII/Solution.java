// # 219 Contains Duplicate II 
//Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
//
//Tags: Array, Hash Table

public class Solution { 
    public boolean containsNearbyDuplicate(int[] nums, int k) { 
        if (nums == null || nums.length == 0) return false; 
        HashMap<Integer, Integer> firstIndex = new HashMap<Integer, Integer>(); 
 
        for (int i = 0; i < nums.length; i++) 
        { 
            if (!firstIndex.containsKey(nums[i])) firstIndex.put(nums[i], i); 
            else   
            { 
                if (i - firstIndex.get(nums[i]) <= k) return true; 
                else firstIndex.put(nums[i], i); 
            } 
        } 
        return false; 
    } 
}