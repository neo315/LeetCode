// #73 Set Matrix Zeroes
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
// Tags: Array

public class Solution { 
    public void setZeroes(int[][] matrix) { 
       int m = matrix.length; 
       int n = matrix[0].length; 
       boolean zerorow = false; 
       boolean zerocolumn = false; 
        
       for (int j = 0; j < n; j++) 
       { 
           if (matrix[0][j] == 0) zerorow = true; 
       } 
       for (int i = 0; i < m; i++) 
       { 
           if (matrix[i][0] == 0) zerocolumn = true; 
       } 
        
       for (int i = 1; i < m; i++) 
        for (int j = 1; j < n; j++) 
        { 
            if (matrix[i][j] == 0) { 
                matrix[0][j] = 0; 
                matrix[i][0] = 0; 
            } 
        } 
         
        for (int i = 1; i < m; i++) 
        for (int j = 1; j < n; j++) 
        { 
            if ( matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0; 
        } 
         
        if (zerorow) 
        { 
            for (int j = 0; j < n; j++) matrix[0][j] = 0; 
        } 
        if (zerocolumn) 
        { 
            for (int i = 0; i < m; i++) matrix[i][0] = 0; 
        } 
    } 
}