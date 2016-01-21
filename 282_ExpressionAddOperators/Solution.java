// 282 Expression Add Operators
import java.util.List;
import java.util.ArrayList;
public class Solution { 
    public List<String> addOperators(String num, int target) { 
        List<String> result = new ArrayList<String>(); 
        if (num == null || num.length() == 0) { 
            return result; 
        } 
        helper(num, target, "", result, 0, 0, 0); 
        return result; 
    } 
    private void helper(String num, int target, String path, List<String> result, int pos, long eval, long multed) { 
        if (pos == num.length()) { 
            if (eval == target) { 
                result.add(path); 
            } 
            return; 
        } 
        for (int i = pos; i < num.length(); i++) { 
            if (i != pos && num.charAt(pos) == '0') { 
                break; 
            } 
            long cur = Long.parseLong(num.substring(pos, i+1)); 
            if (pos == 0) { 
                helper(num, target, path + cur, result, i+1, cur, cur); 
            } 
            else { 
                helper(num, target, path + "+" + cur, result, i+1, eval + cur, cur); 
                helper(num, target, path + "-" + cur, result, i+1, eval - cur, -cur); 
                helper(num, target, path + "*" + cur, result, i+1, eval - multed + multed*cur, multed*cur); 
            } 
        } 
    } 
    public static void main(String[] args) {
        Solution s = new Solution();
        int target = Integer.parseInt(args[1]);
        List<String> result = s.addOperators(args[0], target);
        for (String x : result) {
            System.out.println(x);
        }
    }
}