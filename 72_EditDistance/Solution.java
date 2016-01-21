// # 72 Edit Distance
//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character
//Tags: Dynamic Programming, String

public class Solution { 
    public int minDistance(String word1, String word2) { 
        if (word1 == null && word2 == null || word1 == word2) return 0; 
        if (word1 == null || word1.length() == 0) return word2.length(); 
        if (word2 == null || word2.length() == 0) return word1.length(); 
         
        int[][] minD = new int[word1.length()+1][word2.length()+1]; 
         
        for (int i = 0; i <= word1.length(); i++) 
            minD[i][0] = i; 
        for (int j = 0; j <= word2.length(); j++) 
            minD[0][j] = j; 
         
        for (int i = 1; i <= word1.length(); i++) 
            for (int j = 1; j <= word2.length(); j++) 
            { 
                if (word1.charAt(i-1) == word2.charAt(j-1)) minD[i][j] = minD[i-1][j-1]; 
                else 
                    minD[i][j] = Math.min(Math.min(minD[i-1][j-1], minD[i][j-1]), minD[i-1][j])+1; 
            } 
        return minD[word1.length()][word2.length()]; 
    } 
}