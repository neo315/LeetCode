//241 Different Ways to Add Parentheses
import java.util.List;
import java.util.ArrayList;
public class Solution { 
    public List<Integer> diffWaysToCompute(String input) { 
        List<Integer> result = new ArrayList<Integer>(); 
        if (input == null || input.length() == 0) { 
            return result; 
        } 
        
        boolean hasOperator = false; 
        for (int i = 0; i < input.length(); i++) { 
            char c = input.charAt(i); 
            if (c >= '0' && c <= '9') { 
                continue; 
            } 
            else { 
                hasOperator = true; 
                String sub1 = input.substring(0, i); 
                String sub2 = input.substring(i+1); 
                List<Integer> list1 = diffWaysToCompute(sub1); 
                List<Integer> list2 = diffWaysToCompute(sub2); 
                for (int x : list1) { 
                    for (int y : list2) { 
                        switch(c) { 
                            case '+': result.add(x+y); break; 
                            case '-': result.add(x-y); break; 
                            case '*': result.add(x*y); break; 
                        } 
                    } 
                } 
            } 
        } 
        if (!hasOperator) { 
            result.add(Integer.parseInt(input)); 
        } 
        return result; 
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> result = s.diffWaysToCompute(args[0]);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}