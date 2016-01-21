// 229 Majority Element II
public class Solution { 
    public List<Integer> majorityElement(int[] nums) { 
        List<Integer> result = new ArrayList<Integer>(); 
        if (nums == null || nums.length == 0) { 
            return result; 
        } 
        Integer candidate1 = null; 
        Integer candidate2 = null; 
        int cnt1 = 0, cnt2 = 0; 
        for (int i = 0; i < nums.length; i++) { 
            if (cnt1 == 0) { 
                candidate1 = nums[i]; 
                cnt1++; 
            } 
            else if (nums[i] == candidate1) { 
                cnt1++; 
            } 
            else if (cnt2 == 0) { 
                candidate2 = nums[i]; 
                cnt2++; 
            } 
            else if (nums[i] == candidate2) { 
                cnt2++; 
            } 
            else { 
                cnt1--; 
                cnt2--; 
                //System.out.println(candidate1 + " " + candidate2); 
            } 
        } 
        cnt1 = 0; 
        cnt2 = 0; 
        for (int i = 0; i < nums.length; i++) { 
            if (candidate1 != null && nums[i] == candidate1) { 
                cnt1++; 
            } 
            if (candidate2 != null && nums[i] == candidate2) { 
                cnt2++; 
            } 
        } 
        if (cnt1 > nums.length / 3) { 
            result.add(candidate1); 
            //System.out.println(candidate1); 
        } 
        if (candidate1 != candidate2 && cnt2 > nums.length / 3) { 
            result.add(candidate2); 
            //System.out.println(candidate2); 
        } 
        return result; 
    } 
}