// # 29 Divide Two Integers 
//Divide two integers without using multiplication, division and mod operator.
//
//If it is overflow, return MAX_INT.
//
//Tags: Math Binary Search

public class Solution { 
    public int divide(int dividend, int divisor) { 
        if (divisor == 0) return Integer.MAX_VALUE; 
        boolean negative = (dividend ^ divisor) >>> 31 == 1; 
         
        int result = 0; 
         
         
        if (dividend == Integer.MIN_VALUE) 
        { 
            dividend += Math.abs(divisor); 
            if (divisor == -1) 
                return Integer.MAX_VALUE; 
            result++; 
        } 
        if (divisor == Integer.MIN_VALUE) 
            return result; 
         
        dividend = Math.abs(dividend); 
        divisor = Math.abs(divisor); 
        int digit = 0; 
         
        while (divisor <= (dividend>>1)) 
        { 
            divisor <<= 1; 
            digit++; 
        } 
         
        while (digit >= 0) 
        { 
            if (dividend >= divisor) 
            { 
                result += 1 << digit; 
                dividend -= divisor; 
            } 
            divisor >>= 1; 
            digit--; 
        } 
        return negative ? -result : result; 
    } 
}