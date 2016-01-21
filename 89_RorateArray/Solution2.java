public class Solution2 { 
    public void rotate(int[] nums, int k) { 
         
        int n = nums.length; 
        int i, j, d, temp; 
        k = k % n; 
        reverse(nums, 0, n - 1); 
        reverse(nums, 0, k - 1); 
        reverse(nums, k, n - 1); 
    } 
     
     private void reverse(int[] A, int left, int right) 
        { 
            int temp; 
            while (left < right) 
            { 
                temp = A[left]; 
                A[left] = A[right]; 
                A[right] = temp; 
                left++; 
                right--; 
            } 
        } 
 
} 
