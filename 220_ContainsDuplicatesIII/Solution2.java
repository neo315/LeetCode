public class Solution2 { 
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { 
        if (nums == null || t < 0) { 
            return false; 
        } 
        final TreeSet<Integer> set = new TreeSet<Integer>(); 
        for (int i = 0; i < nums.length; i++) { 
            if (i > k) { 
                set.remove(nums[i - k - 1]); 
            } 
            final Integer floor = set.floor(nums[i] + t); 
            final Integer ceiling = set.ceiling(nums[i] - t); 
            if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) { 
                return true; 
            } 
            set.add(nums[i]); 
        } 
        return false; 
    } 
}