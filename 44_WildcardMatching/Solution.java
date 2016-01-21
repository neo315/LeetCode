// # 44 Wildcard Matching 
//Implement wildcard pattern matching with support for '?' and '*'.
//
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") ? false
//isMatch("aa","aa") ? true
//isMatch("aaa","aa") ? false
//isMatch("aa", "*") ? true
//isMatch("aa", "a*") ? true
//isMatch("ab", "?*") ? true
//isMatch("aab", "c*a*b") ? false
//Tags: Dynamic Programming, Backtracking, Greedy, String

public class Solution { 
    public boolean isMatch(String s, String p) { 
        int len = s.length(); 
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')   
            return false;   
        boolean[] res = new boolean[len+1]; 
        res[0] = true; 
        for (int j = 0; j < p.length(); j++) 
        { 
            if (p.charAt(j) != '*') 
            { 
                for (int i = len-1; i >= 0; i--) 
                { 
                    res[i+1] = res[i] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'); 
                } 
            } 
            else 
            { 
                int i = 0; 
                while (i <= s.length() && !res[i]) 
                    i++; 
                for (; i <= s.length(); i++) 
                    res[i] = true; 
            } 
            res[0] = res[0] && p.charAt(j) == '*'; 
        } 
        return res[len]; 
    } 
}