import java.util.List;
import java.util.ArrayList;
public class Solution2 { 
    public List<Integer> majorityElement(int[] nums) { 
        List<Integer> result = new ArrayList<Integer>(); 
        if (nums == null || nums.length == 0) { 
            return result; 
        } 
        int n = nums.length; 
        int rank1 = n / 3; 
        int rank2 = 2 * n / 3; 
        Integer candidate1 = findKthSmall(nums, rank1, 0, n-1); 
        Integer candidate2 = findKthSmall(nums, rank2, 0, n-1); 
         
        int cnt1 = 0; 
        int cnt2 = 0; 
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
        } 
        //System.out.println(candidate1 - candidate2);
        if (candidate1 - candidate2 != 0 && cnt2 > nums.length / 3) { 
            result.add(candidate2); 
        } 
        return result; 
    } 
    public Integer findKthSmall(int[] nums, int k) {
        return findKthSmall(nums, k, 0, nums.length-1);
    }
    private Integer findKthSmall(int[] nums, int k, int lo, int hi) { 
        if (k < 0 || k >= nums.length) { 
            return null; 
        } 
        int gt = hi, lt = lo, i = lo + 1; 
        int v = nums[lo]; 
        while (i <= gt) { 
            if (nums[i] < v) { 
                exch(nums, lt++, i++); 
            } 
            else if (nums[i] > v) { 
                exch(nums, gt--, i); 
            } 
            else { 
                i++; 
            } 
        } 
        //System.out.println("lt= " + lt + " gt=" + gt);
        if (k >= lt && k <= gt) { 
            return nums[k]; 
        } 
        else if (k < lt) { 
            return findKthSmall(nums, k, lo, lt-1); 
        } 
        else { 
            return findKthSmall(nums, k, gt+1, hi); 
        } 
    } 
      private void exch(int[] nums, int i, int j) { 
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }
    public static void main(String[] args) {
        int[] nums = {2147483647};
        Solution2 s = new Solution2();
        List<Integer> result = s.majorityElement(nums);
        for (int x : result) {
            System.out.print(x + " ");
        }
        //System.out.println(s.findKthSmall(nums,2));
    }
}