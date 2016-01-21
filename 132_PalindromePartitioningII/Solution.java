// # 132 Palindrome Partitioning II 
//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return the minimum cuts needed for a palindrome partitioning of s.
//
//For example, given s = "aab",
//Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
//
// Tags: Dynamic Programming

public class Solution { 
    public int minCut(String s) { 
        if (s == null || s.length() <= 1) return 0; 
        int[] res = new int[s.length()+1]; 
        boolean[][] palindrome = isPalindrome(s); 
        for (int i = 0; i < s.length(); i++) 
        { 
            res[i+1] = i+1; 
            for (int j = 0; j <= i; j++) 
            { 
                if (palindrome[j][i])  
                    res[i+1] = Math.min(res[i+1], res[j]+1); 
            } 
        } 
        return res[s.length()] - 1; 
    } 
     
    private boolean[][] isPalindrome(String s) 
    { 
        boolean[][] result = new boolean[s.length()][s.length()]; 
         
        for (int i = s.length()-1; i >= 0; i--) 
        { 
            for (int j = i; j < s.length(); j++) 
            { 
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || result[i+1][j-1])) 
                    result[i][j] = true; 
            } 
        } 
        return result; 
 
    } 
}