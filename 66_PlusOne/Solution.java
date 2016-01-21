// #66 Plus One 
//Given a non-negative number represented as an array of digits, plus one to the number.
//
//The digits are stored such that the most significant digit is at the head of the list.
// Tags:  Array, Math
public class Solution { 
    public int[] plusOne(int[] digits) { 
        int carry = 0; 
        int n = digits.length; 
        if (n == 0) return digits; 
         
        digits[n - 1] += 1; 
         
     for (int i = n - 1; i >= 0; i--) 
     { 
        digits[i] += carry; 
        if (digits[i] == 10)  
        { 
            carry = 1; 
            digits[i] = 0; 
        } 
        else carry = 0; 
    } 
        if (carry == 1)  
        { 
            int[] result = new int[n + 1]; 
            result[0] = 1; 
            for (int i = 1; i < n + 1; i++) 
                result[i] = digits[i - 1]; 
            return result; 
        } 
        else return digits; 
    } 
}