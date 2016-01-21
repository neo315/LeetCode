// #191 Number of 1 Bits 
// Write a function that takes an unsigned integer and returns the number of Õ1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer Õ11' has binary representation 00000000000000000000000000001011, so the function should return 3.
// Bit Manipulation

public class Solution { 
    // you need to treat n as an unsigned value 
    public int hammingWeight(int n) { 
        int count = 0; 
         
        for (int i = 0; i < 32; i++) 
            if (((n >> i) & 1) == 1) count++; 
             
        return count; 
    } 
}
