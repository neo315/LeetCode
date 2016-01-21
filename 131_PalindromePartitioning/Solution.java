// # 131 Palindrome Partitioning
//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s = "aab",
//Return
//
//  [
//    ["aa","b"],
//    ["a","a","b"]
//  ]
//Tags: Backtracking

public class Solution { 
    public List<List<String>> partition(String s) { 
        ArrayList<List<String>> result = new ArrayList<List<String>>(); 
        if (s == null || s.length() == 0) return result; 
         
        helper(s, new ArrayList<String>(), result); 
        return result; 
    } 
     
    private void helper(String s, ArrayList<String> item, ArrayList<List<String>> result) 
    { 
        if (s.length() ==0) 
        { 
            result.add(new ArrayList<String>(item)); 
            return; 
        } 
         
        for (int i = 1; i <= s.length(); i++) 
        { 
            String str = s.substring(0, i); 
            if (isPalindrome(str)) 
            { 
                item.add(str); 
                helper(s.substring(i), item, result); 
                item.remove(item.size()-1); 
            } 
        } 
        return; 
    } 
     
    private boolean isPalindrome(String s) 
    { 
        if (s.length() == 1) return true; 
        int left = 0; 
        int right = s.length()-1; 
        while (left < right) 
        { 
            if (s.charAt(left) != s.charAt(right)) return false; 
            left++; 
            right--; 
        } 
        return true; 
    } 
}