// # 201 Bitwise AND of Numbers Range 
//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
//For example, given the range [5, 7], you should return 4.
// Tags: Bit Manipulation
//
//
//The only bits that will be 1 will be bits that are common to the upper bits of A and B. 
//Everything else will have at least one instance of a 0 in that range. So just start from the high order bit downwards.
//Output the matching bits. 
//As soon as you hit a disagreement between the binaries of A and B (which will be 0 in A and 1 in B) output zeros until you get to the length of B.

public class Solution { 
    public int rangeBitwiseAnd(int m, int n) { 
        if (m == n) return m; 
         
        int x = m ^ n; 
        int s = x >> 1; 
         
        while (s != 0) // Set all the zero bits after the first 1 to 1 in xor 
        { 
            x = x|s; 
            s >>= 1; 
        } 
         
        return m & n & ~x; // use x as a selector of m&n to selectr the range of 1s
    } 
}