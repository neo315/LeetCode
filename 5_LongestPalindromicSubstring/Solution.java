// # 3 Longest Palindromic Substring
//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
//and there exists one unique longest palindromic substring.
//Tags: String

public class Solution { 
    public String longestPalindrome(String s) { 
        if (s == null || s.length() <= 1) return s; 
        int n = s.length(); 
        int maxL = 0; 
        int start = 0; 
        int end = 0; 
         
        boolean[][] isPal = new boolean[n][n]; 
        isPal[0][0] = true; 
         
        for (int i = 1; i < n; i++) 
        { 
            for (int j = 0; j < i; j++) 
            { 
                isPal[j][i] = (s.charAt(i) == s.charAt(j)) && (i - j < 2 || isPal[j+1][i-1]); 
                if (isPal[j][i] && i - j + 1 > maxL) 
                { 
                    maxL = i - j + 1; 
                    start = j; 
                    end = i; 
                } 
            } 
        isPal[i][i] = true; 
        } 
        return s.substring(start, end+1); 
    } 
}