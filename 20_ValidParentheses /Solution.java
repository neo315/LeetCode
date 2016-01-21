// #20 Valid Parentheses 
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
// Tags:  Stack String
// remember to put "break" after "case:" in the switch staement

import java.util.Stack; 
public class Solution { 
    public boolean isValid(String s) { 
        if (s == null || s.length() == 0);
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) 
    {
        switch(s.charAt(i))
        {
        case ')': if (stack.empty() || stack.pop() != '(') 
                    return false; 
                    break;
        case '}': if (stack.empty() || stack.pop() != '{') 
                    return false; 
                    break;
        case ']':  if (stack.empty() || stack.pop() != '[') 
                    return false; 
                    break;
        case '(':
        case '{':
        case '[': stack.push(s.charAt(i)); break;
        default: break;
        }
    }
    return stack.empty();
    }
    public static void main(String[] args)
    {
        String s = args[0];
        Solution solution = new Solution();
        StdOut.println(solution.isValid(s));
    }
}