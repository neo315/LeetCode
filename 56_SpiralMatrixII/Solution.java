// # 56 Spiral Matrix II 
//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//For example,
//Given n = 3,
//
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
//Tags: Array

public class Solution { 
    public int[][] generateMatrix(int n) { 
        if (n < 0) return null; 
         
        int[][] result = new int[n][n]; 
        int levelNum = n / 2; 
        int num = 1; 
        for (int level = 0; level < levelNum; level++) 
        { 
            for (int i = level; i < n-level; i++) 
                result[level][i] = num++; 
            for (int i = level+1; i < n-level; i++) 
                result[i][n-level-1] = num++; 
            for (int i = n-level-2; i >= level; i--) 
                result[n-level-1][i] = num++; 
            for (int i = n-2-level; i > level; i--) 
                result[i][level] = num++; 
        } 
        if (n%2 == 1) 
            result[levelNum][levelNum] = num; 
        return result;    
    } 
}