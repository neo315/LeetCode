// # 150 Evaluate Reverse Polish Notation 
//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
//Tags: Stack

public class Solution { 
    public int evalRPN(String[] tokens) { 
        if (tokens == null || tokens.length == 0) return 0; 
         
        Stack<Integer> stack = new Stack<Integer>(); 
        for (int i = 0; i < tokens.length; i++) 
        { 
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) 
            { 
                int v = stack.pop(); 
                switch (tokens[i]) 
                { 
                    case "+": v += stack.pop(); break; 
                    case "-": v = stack.pop() - v; break; 
                    case "*": v *= stack.pop(); break; 
                    case "/": v = stack.pop() / v; break; 
                    default: break; 
                } 
                stack.push(v); 
            } 
            else stack.push(Integer.parseInt(tokens[i])); 
        } 
        return stack.pop(); 
    } 
}