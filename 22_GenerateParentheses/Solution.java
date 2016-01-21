// # 22 Generate Parentheses
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//"((()))", "(()())", "(())()", "()(())", "()()()"
//
// Tags: Backtracking, String

public class Solution { 
    public List<String> generateParenthesis(int n) { 
        ArrayList<String> result = new ArrayList<String>(); 
        if (n <= 0) return result; 
         
        int left = 0; 
        int right = 0; 
         
        generate(n, 0, 0, new String(), result); 
        return result; 
    } 
     
    private void generate(int n, int left, int right, String item, ArrayList<String> result) 
    { 
        if (left < right) return; 
        if (left == n && right == n)  
        { 
            result.add(item); 
            return; 
        } 
         
        if (left == n) 
        { 
            generate(n, left, right+1, item+")", result); 
            return; 
        } 
         
        generate(n, left+1, right, item+"(", result); 
        generate(n, left, right+1, item+")", result); 
        return; 
         
    } 
}