public class Solution2 { 
    public String minWindow(String s, String t) { 
        if (t == null || s == null || t.length() == 0 || s.length() == 0) { 
            return ""; 
        } 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
        for (int i = 0; i < t.length(); i++) { 
            char c = t.charAt(i); 
            if (!map.containsKey(c)) { 
                map.put(c, 1); 
            } 
            else { 
                map.put(c, map.get(c) + 1); 
            } 
        } 
         
        int count = 0; 
        int left = 0; 
        int right = 0; 
        int minLen = Integer.MAX_VALUE; 
        String result = ""; 
        while (right < s.length()) { 
            while (count != t.length() && right < s.length()) { 
                char c = s.charAt(right); 
                if (map.containsKey(c)) { 
                    map.put(c, map.get(c) - 1); 
                    if (map.get(c) >= 0) { 
                        count++; 
                    } 
                } 
                right++; 
            } 
            while (count == t.length() && left <= right) { 
                if (right - left + 1 <= minLen) { 
                    minLen = right - left + 1; 
                    result = s.substring(left, right); 
                } 
                char c = s.charAt(left); 
                if (map.containsKey(c)) { 
                    map.put(c, map.get(c) + 1); 
                    if (map.get(c) > 0) { 
                        count--; 
                    } 
                } 
                left++; 
            } 
        } 
        return result; 
    } 
}