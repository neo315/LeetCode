public class Solution2 { 
    public List<String> restoreIpAddresses(String s) { 
        List<String> result = new ArrayList<String>(); 
        if (s == null || s.length() < 4) { 
            return result; 
        } 
        helper(0, 0, s, "", result); 
        return result; 
    } 
    private void helper(int start, int step, String s, String item, List<String> result) { 
        if (step == 3) { 
            if (check(s.substring(start))) { 
                result.add(item + s.substring(start)); 
            } 
            return; 
        } 
        for (int i = start; i < s.length(); i++) { 
            String numStr = s.substring(start, i+1); 
            if (check(numStr)) { 
                helper(i+1, step+1, s, item + numStr + ".", result); 
            } 
        } 
        return; 
    } 
    private boolean check(String s) { 
        if (s == null || s.length() == 0 || s.length() > 3) { 
            return false; 
        } 
        if (s.charAt(0) == '0' && s.length() != 1) { 
            return false; 
        } 
        int num = Integer.parseInt(s); 
        return num >= 0 && num < 256; 
    } 
}