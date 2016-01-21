// #27 Remove Element
// Given an array and a value, remove all instances of that value in place and return the new length.
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

//  Array Two Pointers

public class Solution { 
    public int removeElement(int[] A, int elem) { 
         
        int n = A.length; 
        int i = 0; 
         
        if (n == 0) return 0; 
        int j = A.length -1; 
 
        while (i <= j)  
        { 
           if (A[i] == elem)  
            { 
                A[i] = A[j]; 
                j--; 
                n--; 
            } 
            else i++; 
        } 
        return n; 
    } 
}