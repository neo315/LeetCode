public class Solution { 
    public int findDuplicate(int[] nums) { 
        if (nums == null || nums.length == 0) { 
            return -1; 
        } 
        int n = nums.length - 1; 
        int lo = 1, hi = n; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2;
            int larger = 0, smaller = 0, equal = 0; 
            for (int i = 0; i < nums.length; i++) { 
                if (nums[i] < mid) { 
                    smaller++; 
                } 
                else if (nums[i] > mid) { 
                    larger++; 
                }
                else {
                    equal++;
                }
            }
            //System.out.println("mid: " + mid + " larger: " + larger + " smaller: " + smaller + " equal: " + equal);
            if (equal > 1) {
                return mid;
            }
            else { // larger + smaller != n - 1
                if (larger > n - mid) { 
                    lo = mid + 1; 
                } 
                else if (smaller > mid - 1) { 
                    hi = mid - 1; 
                }
            }
        } 
        return -1; 
    } 
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[args[0].length()];
        for (int i = 0; i < args[0].length(); i++) {
            nums[i] = args[0].charAt(i) - '0';
        }
        System.out.println(s.findDuplicate(nums));
    }
        
}