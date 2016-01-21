// # 202 Happy Number
//Write an algorithm to determine if a number is "happy".
//
//A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//Example: 19 is a happy number
//
//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 8^2 = 100
//1^2 + 0^2 + 0^2 = 1

public class Solution { 
    public boolean isHappy(int n) { 
    HashSet<Integer> set = new HashSet<Integer>(); 
    int item = 0; 
     
    while (!set.contains(item)) 
    { 
        while (n != 0) 
        { 
            int digit = n % 10; 
            item += digit * digit; 
            n /= 10; 
        } 
        if (item == 1) return true; 
        if (set.contains(item)) return false; 
        set.add(item); 
        n = item; 
        item = 0; 
    } 
    return false; 
    } 
}