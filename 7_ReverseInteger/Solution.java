// #7 Reverse Integer
// Reverse digits of an integer.
//
//Example1: x = 123, return 321
//Example2: x = -123, return -321
//Have you thought about this?
//Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
//
//If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
//
//Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
//
//For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//
//Update (2014-11-10):
//Test cases had been added to test the overflow behavior.
// Tags: Math

import java.util.LinkedList;
public class Solution { 
    public static int reverse(int x) { 
         
        if (x == 0) return 0; 
        if (x == -2147483648) return 0; 
         
        int num = x; 
        int digit = 0; 
        boolean negativeSign = false; 
 
        LinkedList<Integer> digits = new LinkedList<Integer>(); 
        
        
        if (x < 0)  
        { 
            negativeSign = true; 
            num = - num; 
        } 
         
        while (num != 0) 
        { 
            digit = num % 10; 
            digits.add(digit); 
            num = num / 10; 
        } 
               
        int result = 0; 
        while (!digits.isEmpty()) 
        { 
            digit = digits.pollFirst(); 
            if (result > 214748364 || (result == 214748364 && digit >7)) return 0; 
            result = result * 10 + digit; 
        } 
         
        if (negativeSign) result = - result; 
         
        return result; 
    } 
    
    public static void main(String[] args)
    {
        int x = Integer.parseInt(args[0]);
        System.out.printf("%d\n", reverse(x));
    }
}