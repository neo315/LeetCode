//// #152 Maximum Product Subarray 
//Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//For example, given the array [2,3,-2,4],
//the contiguous subarray [2,3] has the largest product = 6.
//// Tags:  Array, Dynamic Programming

public class Solution { 
    public int maxProduct(int[] A) { 
        if (A.length == 0) return 1; 
        if (A.length == 1) return A[0]; 
        int n = A.length; 
        int local_max = A[0]; 
        int local_min = A[0]; 
        int global_max = A[0]; 
         
        for (int i = 1; i < n; i++) 
        { 
            int copy_local_max = local_max; 
            local_max = Math.max(Math.max(A[i], A[i]*local_max), A[i]*local_min); 
            local_min = Math.min(Math.min(A[i], A[i]*local_min), A[i]*copy_local_max); 
            global_max = Math.max(global_max, local_max); 
        } 
        return global_max; 
    } 
}