// #125 Valid Palindrome
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome.

public class Solution { 
    public boolean isPalindrome(String s) { 
        if (s.length() <= 1) return true; 
        String copy = s.toLowerCase(); 
        
        int head = 0; 
        int end = copy.length() - 1; 
         
        while (true) 
        { 
            while (!Character.isAlphabetic(copy.charAt(head)) && !Character.isDigit(copy.charAt(head))) 
            { 
                if (head == copy.length() - 1) break; 
                head++; 
            } 
             
            while (!Character.isAlphabetic(copy.charAt(end)) && !Character.isDigit(copy.charAt(end))) 
            { 
                if (end == 0) break; 
                end--; 
            } 
             
            if (head >= end) break; 
            if (copy.charAt(head) != copy.charAt(end)) return false; 
            head++; 
            end--; 
        } 
        return true; 
    } 
}