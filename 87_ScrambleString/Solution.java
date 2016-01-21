// # 87 Scramble String 
//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
//
//Below is one possible representation of s1 = "great":
//
//    great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
//To scramble the string, we may choose any non-leaf node and swap its two children.
//
//For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
//
//    rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
//We say that "rgeat" is a scrambled string of "great".
//
//Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
//
//    rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
//We say that "rgtae" is a scrambled string of "great".
//
//Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
//
//Tags: Dynamic Programming, String

public class Solution { 
    public boolean isScramble(String s1, String s2) { 
        if (s1 == null || s2 == null || s1.length() != s2.length()) 
            return false; 
        int len = s1.length(); 
         
        boolean[][][] isScramble = new boolean[len][len][len+1]; 
         
        for (int i = 0; i < len; i++) 
            for (int j = 0; j < len; j++) 
                isScramble[i][j][1] = s1.charAt(i) == s2.charAt(j); 
                 
        for (int L = 2; L < len+1; L++) 
            for (int i = 0; i < len-L+1; i++) 
                for (int j = 0; j < len-L+1; j++) 
                    for (int k = 1; k < L; k++) 
                    { 
                        isScramble[i][j][L] = isScramble[i][j][L] || (isScramble[i][j][k] && isScramble[i+k][j+k][L-k])  
                            || (isScramble[i][j+L-k][k] && isScramble[i+k][j][L-k]); 
                    } 
        return isScramble[0][0][len]; 
    } 
}
