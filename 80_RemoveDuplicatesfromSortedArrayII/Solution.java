//// #80 Remove Duplicates from Sorted Array II 
////Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array A = [1,1,1,2,2,3],
//
//Your function should return length = 5, and A is now [1,1,2,2,3].
// Tags:  Array, Two Pointers

public class Solution { 
    public int removeDuplicates(int[] A) { 
       int n = A.length; 
       if (n < 3) return n; 
        
       int occur = 1; 
       int index = 0; 
        
       for (int i = 1; i < n; i++) 
       { 
           if (A[index] == A[i]) 
           { 
               if (occur == 2) continue; 
               occur++; 
           } 
           else occur = 1; 
           A[++index] = A[i]; 
       } 
       return index + 1; 
    } 
}