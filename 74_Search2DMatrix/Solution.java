// #74 Search a 2D Matrix 
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// Tags: Array Binary Search

public class Solution { 
    public boolean searchMatrix(int[][] matrix, int target) { 
        int m = matrix.length; 
        int n = matrix[0].length; 
        int lo = 0; 
        int hi = m * n - 1; 
         
        while (lo <= hi) 
        { 
            int mid = lo + (hi - lo) / 2; 
            int i = mid / n; 
            int j = mid % n; 
            if (matrix[i][j] < target) lo = mid + 1; 
            else if (matrix[i][j] > target) hi = mid - 1; 
            else return true; 
        } 
        return false; 
    } 
}