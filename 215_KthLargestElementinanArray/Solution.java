// # 215 Kth Largest Element in an Array
//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.
//
//Note: 
//You may assume k is always valid, 1 ² k ² array's length.
//
//Tags: Divide and Conquer Heap

public class Solution { 
    public int findKthLargest(int[] nums, int k) { 
 
        return KthLargest(nums, 0, nums.length-1, nums.length-k); 
    } 
    private int KthLargest(int[] nums, int lo, int hi, int k) 
    { 
    
        
        int i = lo; 
        int j = hi; 
        int v = nums[lo]; 
         
        while (i <= j) 
        { 
            while (i <= j && nums[i] <= v) i++; 
            while (i <= j && v <= nums[j]) j--; 
            if (i < j) swap(nums, i, j); 
        } 
        swap(nums, lo, j); 
         
        if (k == j) 
            return nums[j]; 
        else if (k > j) 
            return KthLargest(nums, j+1, hi, k); 
        else return KthLargest(nums, lo, j-1, k); 
    } 
     
    private void swap(int[] a, int i, int j) 
    { 
        int temp = a[i]; 
        a[i] = a[j]; 
        a[j] = temp; 
    } 
}