// #35 Search Insert Position 
// Given a sorted array and a target value, return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order.
// You may assume no duplicates in the array.
// Array, Binary Search

public class Solution { 
    public int searchInsert(int[] A, int target) { 
     
    int lo, hi; 
    lo = 0; 
    hi = A.length-1; 
 
    int cmp = 0; 
     
    while (lo <= hi) 
    { 
        int mid = lo + (hi - lo) / 2; 
        cmp = target - A[mid]; 
        if (cmp > 0) lo = mid + 1; 
        else if (cmp < 0) hi = mid - 1; 
        else return mid; 
    } 
     
    if (cmp > 0) return  lo; 
    else return hi + 1; 
         
    } 
}