// # 14 Longest Common Prefix 
//Write a function to find the longest common prefix string amongst an array of strings.
//
// Tags: String

public class Solution { 
    public String longestCommonPrefix(String[] strs) { 
        StringBuilder result = new StringBuilder(); 
        if (strs == null || strs.length == 0) return result.toString(); 
        int minLength = Integer.MAX_VALUE; 
        for (int i = 0; i < strs.length; i++) 
           minLength = Math.min(minLength, strs[i].length()); 
        if (minLength == 0) return result.toString();    
         
         for (int index = 0; index < minLength; index++) 
            { 
                for (int i = 0; i < strs.length; i++) 
                { 
                    if (strs[i].charAt(index) != strs[0].charAt(index))            
                        return result.toString(); 
                } 
                result.append(strs[0].charAt(index)); 
            } 
        return result.toString(); 
    } 
}