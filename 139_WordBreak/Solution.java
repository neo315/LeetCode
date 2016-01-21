// #139 Word Break 
//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code".
//
// Tags: Dynamic Programming

public class Solution { 
    public boolean wordBreak(String s, Set<String> wordDict) { 
        if (s == null || s.length() == 0) return true; 
        boolean [] result = new boolean[s.length() + 1]; 
         
        result[0] = true; 
        for (int i = 0; i < s.length(); i++) 
            for (int j = 0; j <= i; j++) 
                if (result[j] && wordDict.contains(s.substring(j, i+1))) 
                    { 
                        result[i+1] = true; 
                        break; 
                    } 
        return result[s.length()]; 
    } 
}