// # 54 Spiral Matrix
//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].
//
//Tags: Array

public class Solution { 
    public List<Integer> spiralOrder(int[][] matrix) { 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return result; 
        int min = Math.min(matrix.length, matrix[0].length); 
         
        int levelNum = min / 2; 
         
        for (int level = 0; level < levelNum; level++) 
        { 
            for (int i = level; i < matrix[0].length-level-1; i++) 
                result.add(matrix[level][i]); 
            for (int i = level; i < matrix.length-level-1; i++) 
                result.add(matrix[i][matrix[0].length-level-1]); 
            for (int i = matrix[0].length-level-1; i > level; i--) 
                result.add(matrix[matrix.length-level-1][i]); 
            for (int i = matrix.length-level-1; i > level; i--) 
                result.add(matrix[i][level]); 
        } 
         
        if (min%2 == 1) 
        { 
            if (matrix.length < matrix[0].length) 
            { 
                for (int i = levelNum; i < matrix[0].length-levelNum; i++) 
                    result.add(matrix[levelNum][i]); 
            } 
            else 
            { 
                for (int i = levelNum; i < matrix.length-levelNum; i++) 
                    result.add(matrix[i][levelNum]); 
            } 
        } 
        return result; 
    } 
}