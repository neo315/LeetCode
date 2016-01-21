// #162 Find Peak Element
// A peak element is an element that is greater than its neighbors.
// Given an input array where num[i] ­ num[i+1], find a peak element and return its index.
// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
// You may imagine that num[-1] = num[n] = -°.
// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
// Note: Your solution should be in logarithmic complexity.

//  Array, Binary Search

public class Solution { 
    public int findPeakElement(int[] num) { 
         
        if (num.length == 1 || num[0] > num[1]) return 0; 
         
        int lo = 1; 
        int hi = num.length - 2; 
         
        while (lo <= hi) 
        { 
            int mid = lo + (hi - lo) / 2; 
            if (num[mid] < num[mid-1]) hi = mid -1; 
            else if (num[mid] < num[mid+1]) lo = mid + 1; 
            else return mid; 
        } 
         
        return num.length - 1; 
    } 
}


/* public class Solution { 
    public int findPeakElement(int[] num) { 
        boolean high = true;   // a boolean to record if the current element is larger than previous one 
        int i; 
         
        for (i = 0; i < num.length - 1; i++) 
        { 
            if (num[i] > num[i+1]) 
            { 
                if (high) return i; 
                else  
                { 
                    high = false; 
                } 
            } 
            else high = true; 
        } 
        return i; 
    } 
}
*/