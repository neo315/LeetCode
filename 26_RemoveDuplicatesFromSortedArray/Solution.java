// #26 Remove Duplicates from Sorted Array 
//// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//For example,
//Given input array A = [1,1,2],
//
//Your function should return length = 2, and A is now [1,2].
// Tags: Array, Two Pointers

public class Solution { 
    public int removeDuplicates(int[] A) { 
        if (A.length <= 1) return A.length; 
        int n = A.length; 
        int current = 0; 
        int next = 0; 
         
        while (current < n - 1)  
        { 
            next++; 
            while (next < A.length && A[current] == A[next])  
            { 
                next++; 
                n--; 
            } 
        if (next == A.length) break; 
        exch(A, next, ++current);    
        } 
         
        return n; 
    } 
        private void exch(int[] A, int i, int j) 
        { 
            if (i >= A.length || j >= A.length) return; 
            if (i == j) return; 
            int temp = A[i]; 
            A[i] = A[j]; 
            A[j] = temp; 
            return; 
        } 
}