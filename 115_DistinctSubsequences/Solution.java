// #115 Distinct Subsequences
//Given a string S and a string T, count the number of distinct subsequences of T in S.

//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.
// Tags: Dynamic, Programming String

public class Solution { 
    public int numDistinct(String S, String T) { 
     if (S == null || T == null) return 0; 
     int N = S.length(); 
     int M = T.length(); 
     if (M > N) return 0; 
     int[] match = new int[M + 1]; 
     match[0] = 1; 
     for (int i = 1; i < M; i++) 
        match[i] = 0; 
     for (int i = 1; i <= N; i++) 
        for (int j = M; j >= 1; j--) 
            if (S.charAt(i-1) == T.charAt(j-1)) 
                match[j] += match[j-1]; 
    return match[M]; 
    } 
}