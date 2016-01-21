// 163 Missing Range
//Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
//
//For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

public class Solution { 
    public List<String> findMissingRanges(int[] nums, int lower, int upper) { 
        List<String> result = new ArrayList<String>(); 
        if (lower > upper) { 
            return result; 
        } 
        StringBuilder sb = new StringBuilder(); 
        if (nums == null || nums.length == 0 || nums[0] > upper || nums[nums.length - 1] < lower) { 
            sb.append(lower); 
            if (lower != upper) { 
                sb.append("->"); 
                sb.append(upper); 
            } 
            result.add(sb.toString()); 
            return result; 
        } 
        int target = lower; 
        for (int x : nums) { 
            if (x > upper) { 
                break; 
            } 
            if (x == target) { 
                target++; 
            } 
            else if (x > target) { // x > target 
                sb = new StringBuilder(); 
                sb.append(target); 
                if (x != target + 1) { 
                    sb.append("->"); 
                    sb.append(x-1); 
                } 
                result.add(sb.toString()); 
                target = x + 1; 
            } 
        } 
        if (target <= upper) { 
            sb = new StringBuilder(); 
            sb.append(target); 
            if (target < upper) { 
                sb.append("->"); 
                sb.append(upper); 
            } 
            result.add(sb.toString()); 
        } 
        return result; 
    } 
}