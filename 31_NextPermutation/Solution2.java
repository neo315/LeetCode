public class Solution2 { 
    public void nextPermutation(int[] nums) { 
        if (nums == null || nums.length <= 1) { 
            return; 
        } 
        int pivot = -1; 
        for (int i = nums.length - 1; i > 0; i--) { 
            if (nums[i-1] < nums[i]) { 
                pivot = i-1; 
                break; 
            } 
        } 

        if (pivot != -1) { 
            int swap = pivot; 
            for (int i = pivot + 1; i < nums.length && nums[i] > nums[pivot]; i++) { 
                    swap = i;
            }
            swap(nums, pivot, swap);
        }
        reverse(nums, pivot+1); 
        return; 
    } 
    private void reverse(int[] nums, int i) { 
        if (i >= nums.length) { 
            return; 
        } 
        int j = nums.length - 1; 
        while (i < j) { 
            swap(nums, i, j); 
            i++; 
            j--; 
        } 
        return; 
    } 
    private void swap(int[] nums, int i, int j) { 
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }
    public static void main(String[] args) {
        int[] nums = new int[args[0].length()];
        for (int i = 0; i < args[0].length(); i++) {
            nums[i] = args[0].charAt(i) - '0';
        }
        Solution2 s = new Solution2();
        s.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }
}