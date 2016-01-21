// #48 Rotate Image 
// You are given an n x n 2D matrix representing an image.
//
//Rotate the image by 90 degrees (clockwise).
//
//Follow up:
//Could you do this in-place?
// Tags: Array

public class Solution { 
    public void rotate(int[][] matrix) { 
         
        int temp; 
        int n = matrix.length; 
         
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n - 1 - i; j++) 
                swap(matrix, i, j, n - 1 - j, n - 1 - i); 
                 
        for (int i = 0; i < n/2; i++) 
            for (int j = 0; j < n; j++) 
                swap(matrix, i, j, n - 1 - i, j); 
    } 
     
    private void swap(int[][] a, int i1, int j1, int i2, int j2) 
    { 
        int temp = a[i1][j1]; 
        a[i1][j1] = a[i2][j2]; 
        a[i2][j2] = temp; 
    } 
}
