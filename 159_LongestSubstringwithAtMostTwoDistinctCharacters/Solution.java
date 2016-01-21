// 159 Longest Substring with At Most Two Distinct Characters
//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
//For example, Given s = “eceba”,
//
//T is "ece" which its length is 3.

public class Solution { 
    public int lengthOfLongestSubstringTwoDistinct(String s) { 
        if (s == null || s.length() == 0) { 
            return 0; 
        } 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
        int left = 0, right = 0; 
        int result = 0; 
        while (right < s.length()) { 
            while (right < s.length() && map.size() <= 2) { 
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
            if (right == s.length()) { 
                break; 
            } 
            while (left < right && map.size() > 2) { 
                char c = s.charAt(left); 
                if (map.containsKey(c)) { 
                    map.put(c, map.get(c) - 1); 
                    if (map.get(c) == 0) { 
                        map.remove(c); 
                    } 
                } 
                left++; 
            } 
        } 
        return result; 
    } 
}