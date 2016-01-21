// #69 Sqrt(x) 
// Implement int sqrt(int x).
// Compute and return the square root of x.
// Math, Binary Search


public class Solution { 
    public int sqrt(int x) { 
     
    int lo = 0; 
    int hi = x; 
    int mid = 0; 
    long square = 0; 
    while (lo <= hi) 
    { 
        mid = lo + (hi - lo) / 2; 
        square = (long)mid * (long)mid; 
        if (square > x) hi = mid - 1; 
        else if (square < x) lo = mid + 1; 
        else return mid; 
    } 
       if (square > x) return mid - 1; 
       else return mid; 
    } 
}