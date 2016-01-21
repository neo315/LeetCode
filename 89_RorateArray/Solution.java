// #189 Rotate Array

// Rotate an array of n elements to the right by k steps.
// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
// Tags:  Array

public class Solution { 
    public void rotate(int[] nums, int k) { 
         
        int n = nums.length; 
        for (int j = 0; j < k; j++) 
            rotateRightByOne(nums, n); 
    }     
     
      private void rotateRightByOne(int[] a, int n) 
        { 
            int temp = a[n - 1]; 
            for (int i = n - 1; i > 0; i--) 
                a[i] = a[i - 1]; 
                a[0] = temp; 
        } 
         
} 
