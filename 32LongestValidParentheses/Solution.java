// # 32 Longest Valid Parentheses
//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
//
//Tags: Dynamic Programming, String

public class Solution { 
    public int longestValidParentheses(String s) { 
        if (s == null || s.length() == 0) return 0; 
        int max = 0; 
        int start = -1; 
        Stack<Integer> stack = new Stack<Integer>(); 
         
        for (int i = 0; i < s.length(); i++) 
        { 
            if (s.charAt(i) == '(')  
                stack.push(i); 
            else if (s.charAt(i) == ')') 
            { 
                if (!stack.empty())  
                { 
                    stack.pop(); 
                    if (stack.empty()) 
                        max = Math.max(max, i - start); 
                    else max = Math.max(max, i - (int)stack.peek()); 
                } 
                else start = i; 
            } 
        } 
        return max; 
    } 
}