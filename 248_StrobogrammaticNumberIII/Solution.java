//248 Strobogrammatic Number III

public class Solution { 
    public int strobogrammaticInRange(String low, String high) { 
        if (low.length() > high.length() || (low.length() == high.length() && low.compareTo(high) > 0)) { 
            return 0; 
        } 
        int[] result = {0}; 
        helper(low, high, "", result); 
        helper(low, high, "0", result); 
        helper(low, high, "1", result); 
        helper(low, high, "8", result); 
        return result[0]; 
    } 
    private void helper(String low, String high, String item, int[] result) {
        //System.out.println("low: " + low + " high: " + high + " item: " + item);
        int len = item.length();
        if (len >= low.length() && len <= high.length()) {
            if (!(len == low.length() && item.compareTo(low) < 0) && !(len == high.length() && item.compareTo(high) > 0)) {
                if (len == 1 || item.charAt(0) != '0') { 
                    result[0]++; 
                } 
            }
        }
        if (item.length() > high.length() || (item.length() == high.length() && item.compareTo(high) > 0)) { 
            return; 
        } 
        helper(low, high, "0" + item + "0", result); 
        helper(low, high, "1" + item + "1", result); 
        helper(low, high, "6" + item + "9", result); 
        helper(low, high, "8" + item + "8", result); 
        helper(low, high, "9" + item + "6", result); 
    } 
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strobogrammaticInRange(args[0], args[1]));
    }
}