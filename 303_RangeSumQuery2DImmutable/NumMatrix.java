// 303 Range Sum Query 2D - Immutable
// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
public class NumMatrix { 
    private int[][] sum = null; 
    public NumMatrix(int[][] matrix) { 
         
        if (matrix != null && matrix.length != 0) { 
            int m = matrix.length, n = matrix[0].length; 
            sum = new int[m][n]; 
            sum[0][0] = matrix[0][0]; 
            for (int j = 1; j < n; j++) { 
                sum[0][j] = sum[0][j-1] + matrix[0][j]; 
            } 
            for (int i = 1; i < m; i++) { 
                int row = 0; 
                for (int j = 0; j < n; j++) { 
                    row += matrix[i][j]; 
                    sum[i][j] = row + sum[i-1][j]; 
                } 
            } 
        } 
    } 
 
    public int sumRegion(int row1, int col1, int row2, int col2) { 
        if (sum == null || sum.length == 0 || sum[0].length == 0) { 
            return 0; 
        }  
        int total = sum[row2][col2]; 
        int top = 0, left = 0, topLeft = 0; 
        if (row1 == 0 && col1 == 0) { 
            return total; 
        } 
        if (col1 != 0) { 
            left = sum[row2][col1-1]; 
        } 
        if (row1 != 0) { 
            top = sum[row1-1][col2]; 
        } 
        if (col1 != 0 && row1 != 0) { 
            topLeft = sum[row1-1][col1-1]; 
        } 
        return total - top - left + topLeft; 
    } 
} 
