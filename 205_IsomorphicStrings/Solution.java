// # 205 Isomorphic Strings
//Given two strings s and t, determine if they are isomorphic.
//
//Two strings are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//For example,
//Given "egg", "add", return true.
//
//Given "foo", "bar", return false.
//
//Given "paper", "title", return true.
//
//Note:
//You may assume both s and t have the same length.
//
// Tags Hash Table

public class Solution { 
    public boolean isIsomorphic(String s, String t) { 
        if (s == null || t == null) return false; 
        if (s.length() != t.length()) return false; 
         
        int n = s.length(); 
         
        HashMap<Character, Character> map = new HashMap<Character, Character>(); 
        for (int i = 0; i < n; i++) 
        { 
            if (!map.containsKey(s.charAt(i)))  
            { 
                if (map.containsValue(t.charAt(i))) return false; 
                else map.put(s.charAt(i), t.charAt(i)); 
            } 
            else 
            { 
                if (map.get(s.charAt(i)) != t.charAt(i)) return false; 
            } 
        } 
        return true; 
    } 
}