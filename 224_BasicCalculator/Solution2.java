import java.lang.StringBuilder;
import java.util.Stack;
public class Solution2 { 
    public int calculate(String s) { 
        if (s == null || s.length() == 0) { 
            return 0; 
        } 
        Stack<Character> operator = new Stack<Character>(); 
        Stack<Integer> operand = new Stack<Integer>(); 
        s = s.trim(); 
        int i = 0; 
        while (i < s.length()) { 
            if (isDigit(s.charAt(i))) { 
                StringBuilder sb = new StringBuilder(); 
                while (i < s.length() && isDigit(s.charAt(i))) { 
                    sb.append(s.charAt(i)); 
                    i++; 
                    //System.out.println(s.charAt(i));
                } 
                int num = Integer.parseInt(sb.toString()); 
                operand.push(num); 
            } 
            else if (s.charAt(i) == ')') { 
                int val2 = operand.pop(); 
                int val1 = operand.pop(); 
                switch(operator.pop()) { 
                    case '+': operand.push(val1 + val2); break; 
                    case '-': operand.push(val1 - val2); break;  
                } 
                i++; 
            } 
            else if (s.charAt(i) == ' ' || s.charAt(i) == '(') { 
                i++; 
            } 
            else { 
                operator.push(s.charAt(i)); 
                i++; 
            } 
        } 
        return operand.pop(); 
    } 
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.calculate(args[0]));
    }   
}