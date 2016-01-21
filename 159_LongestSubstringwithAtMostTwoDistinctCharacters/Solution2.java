public class Solution2 { 
    public int lengthOfLongestSubstringTwoDistinct(String s) { 
        if (s == null || s.length() == 0) { 
            return 0; 
        } 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
        int left = 0, right = 0; 
        int result = 0; 
        while (right < s.length() && left <= right) { 
            if (map.size() <= 2) { 
                char c = s.charAt(right); 
                if (map.containsKey(c)) { 
                    map.put(c, map.get(c) + 1); 
                } 
                else { 
                    map.put(c, 1); 
                } 
                if (map.size() <= 2) result = Math.max(result, right - left + 1); 
                right++; 
            } 
            else { 
                char c = s.charAt(left); 
                map.put(c, map.get(c) - 1); 
                if (map.get(c) == 0) { 
                    map.remove(c); 
                } 
                left++; 
            } 
        } 
        return result; 
    } 
}