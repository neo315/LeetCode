// #34 Search for a range
// Given a sorted array of integers, find the starting and ending position of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
// Tags: Array, Binary Search

public class Solution { 
    public int[] searchRange(int[] A, int target) { 
       int lo = 0; 
       int hi = A.length - 1; 
       int lt = 0; 
       int rt = A.length - 1; 
       int[] result = {-1, -1}; 
        
       while(lo <= hi) 
       { 
           int mid = lo + (hi - lo) / 2; 
           if (A[mid] < target) lo = mid + 1; 
           else if (A[mid] > target) hi = mid - 1; 
           else 
           { 
               lt = mid; 
               rt = mid; 
               result[0] = mid; 
               result[1] = mid; 
               break; 
           } 
       } 
       
       while (lo <= lt) 
       { 
           int lb = lo + (lt - lo) / 2; 
           if (A[lb] == target)  
           { 
               result[0] = lb; 
               lt = lb - 1; 
           } 
           else lo = lb + 1; 
       } 
        
       while (rt <= hi) 
       { 
           int rb = rt + (hi - rt) / 2; 
           if (A[rb] == target)  
           {        
               result[1] = rb; 
               rt = rb + 1; 
           } 
           else hi = rb - 1; 
       } 
        
       return result; 
    } 
}
