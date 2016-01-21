// # 4 Median of Two Sorted Arrays
//There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. 
//The overall run time complexity should be O(log (m+n)).
//
//Tags: Divide and Conquer, Array, Binary Search

public class Solution { 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
       int len = nums1.length + nums2.length; 
       if (len % 2 == 0)  
            return (findKth(nums1, 0, nums2, 0, len/2) + findKth(nums1, 0, nums2, 0, len/2+1))/2.0; 
        else  
            return findKth(nums1, 0, nums2, 0, len/2+1); 
    } 
     
    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) 
    { 
        if (nums1.length <= start1) return nums2[start2+k-1]; 
        if (nums2.length <= start2) return nums1[start1+k-1]; 
        if (k <= 1) return Math.min(nums1[start1+0], nums2[start2+0]); 
         
        int key1 = start1 + k/2 - 1 < nums1.length ? nums1[start1 + k/2 - 1]  
            : Integer.MAX_VALUE; 
        int key2 = start2 + k/2 - 1 < nums2.length ? nums2[start2 + k/2 - 1] 
            : Integer.MAX_VALUE; 
         
        if (key1 < key2) 
                return findKth(nums1, start1+k/2, nums2, start2, k-k/2); 
        else 
                return findKth(nums1, start1, nums2, start2+k/2, k-k/2); 
    } 
}