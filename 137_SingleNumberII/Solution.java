// #137 Single Number II
// Given an array of integers, every element appears three times except for one. 
// Find that single one.
// Note: Your algorithm should have a linear runtime complexity. 
// Could you implement it without using extra memory?
//  Bit Manipulation

public class Solution { 
    public int singleNumber(int[] A) { 
         
        int result = 0; 
        int n = A.length; 
 
        for (int i = 0; i < 32; i++) 
        { 
            int count = 0;
            for (int j = 0; j < n; j++) 
            { 
                if (((A[j] >> i) & 1) != 0)
                    count++; //count[i]++; 
            }
            result |= ((count % 3)) << i; // result |= ((count[i] % 3)) << i; 
        } 
        return result; 
    } 
}