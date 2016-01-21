import java.util.Stack;
import java.lang.StringBuilder;
import java.util.Stack;
public class Solution { 
    public int calculate(String s) { 
        if (s == null || s.length() == 0) { 
            return 0; 
        } 
        int number = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>(); 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (int)(c - '0');
            }
            else if (c == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            }
            else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            }
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }
            else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        result += sign * number;
        return result; 
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calculate(args[0]));
    }
}