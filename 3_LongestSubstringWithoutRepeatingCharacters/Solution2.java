// #3 Longest Substring Without Repeating Characters
//Given a string, find the length of the longest substring without
//repeating characters. For example, the longest substring without
//repeating letters for "abcabcbb" is "abc", which the length is 3. For
//"bbbbb" the longest substring is "b", with the length of 1.
// Tags:  Hash Table, Two Pointers, String

public class Solution { 
    public int lengthOfLongestSubstring(String s) { 
        if (s == null || s.length() == 0) return 0; 
        int n = s.length(); 
        if (n == 1) return 1; 
        char[] ch = s.toCharArray(); 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
         
        int fast = 1; 
        int slow = 0; 
        int max = 1; 
        map.put(ch[slow], slow); 
         
        while (fast < n) 
        { 
            if (map.containsKey(ch[fast]))  
            { 
                if (fast-slow > max) max = fast-slow; 
                if (slow <= map.get(ch[fast])) slow = map.get(ch[fast]) + 1; 
                map.put(ch[fast], fast); 
            } 
            else map.put(ch[fast], fast); 
            fast++; 
        } 
        return Math.max(max, fast - slow); 
    } 
}