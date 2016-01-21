// #153 Find Minimum in Rotated Sorted Array 
// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// Find the minimum element.
// You may assume no duplicate exists in the array.
// Array Binary Search

public class Solution { 
    public int findMin(int[] num) { 
         
        int lo = 0; 
        int hi = num.length - 1; 
        int min = 0; 
         
        while (lo < hi - 1) 
        { 
            int mid = lo + (hi - lo) / 2; 
             
            if (num[lo] < num[mid]) 
            { 
                if (num[lo] < num[min]) min = lo; 
                lo = mid + 1; 
            } 
            else if (num[lo] > num[mid]) 
            { 
                if (num[mid] < num[min]) min = mid; 
                hi = mid - 1; 
            } 
            else 
            { 
                lo++; 
            } 
        } 
         if (num[lo] < num[min]) min = lo; 
        if (num[hi] < num[min]) min = hi; 
 
 
        return num[min]; 
         
    } 
}