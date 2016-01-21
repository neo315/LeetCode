// #81 Search in Rotated Sorted Array II 
// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?
// Would this affect the run-time complexity? How and why?
// Write a function to determine if a given target is in the array.
//  Tags: Array Binary Search

public class Solution { 
    public boolean search(int[] A, int target) { 
        int lo = 0; 
        int hi = A.length - 1; 
         
        while (lo <= hi) 
        { 
            int mid = lo + (hi - lo) / 2; 
            if (A[mid] > target) 
            { 
                if (A[mid] == A[lo]) lo++; 
               else if (A[mid] > A[lo] && A[lo] > target) lo = mid + 1; 
                else hi = mid - 1; 
            } 
            else if (A[mid] < target) 
            { 
                if (A[mid] == A[lo]) lo++; 
                else if (A[mid] < A[lo] && A[hi] < target) hi = mid - 1; 
                else lo = mid + 1; 
            } 
            else return true; 
        } 
        return false; 
    } 
}