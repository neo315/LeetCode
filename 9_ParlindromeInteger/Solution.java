// #9 Palindrome Number
//Determine whether an integer is a palindrome. Do this without extra space.
//
//click to show spoilers.
//
//Some hints:
//Could negative integers be palindromes? (ie, -1)
//
//If you are thinking of converting the integer to string, note the restriction of using extra space.
//
//You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
//
//There is a more generic way of solving this problem.
// Tags: Math

public class Solution { 
    public static boolean isPalindrome(int x) { 
        if (x < 0) return false; 
        int base = 1; 
        while (x/base >= 10) 
            base = base * 10; 
        return isPalindrome(x, base); 
    } 
     
    private static boolean isPalindrome(int x, int base) 
    { 
        if (x == 0 || base == 1) return true; 
//        int lastdigit = x/base; 
//        int firstdigit = x%10; 
////        StdOut.println(firstdigit);
//        StdOut.println(lastdigit);
//        StdOut.println((x%base));
        if (x/base != x%10) return false; 
        else return isPalindrome((x%base)/10, base/100); 
    } 
     
    public static void main(String[] args) 
    { 
        int x = Integer.parseInt(args[0]); 
        StdOut.println(Solution.isPalindrome(x)); 
    } 
}