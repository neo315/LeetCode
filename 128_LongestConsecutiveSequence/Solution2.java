public class Solution2 { 
    public int longestConsecutive(int[] nums) { 
        if (nums == null || nums.length == 0) { 
            return 0; 
        } 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        int max = 0; 
        for (int i = 0; i < nums.length; i++) { 
            int temp = nums[i]; 
            if (map.containsKey(temp)) continue; 
            int left = map.containsKey(temp - 1) ? map.get(temp - 1) : 0; 
            int right = map.containsKey(temp + 1) ? map.get(temp + 1) : 0; 
            int cur = left + right + 1; 
            map.put(temp, cur); 
            max = Math.max(cur, max); 
            map.put(temp - left, cur); 
            map.put(temp + right, cur); 
        } 
        return max; 
    } 
}