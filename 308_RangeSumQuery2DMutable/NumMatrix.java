// 308 Range Sum Query 2D - Mutable
public class NumMatrix { 
    private int[][] matrix; 
    private int[][] tree; 
    private int m; 
    private int n;
    public NumMatrix(int[][] matrix) { 
        this.matrix = matrix; 
        if (matrix != null && matrix.length != 0) { 
            m = matrix.length; 
            n = matrix[0].length; 
            this.matrix = new int[m][n]; 
            tree = new int[m+1][n+1]; 
            for (int i = 0; i < m; i++) { 
                for (int j = 0; j < n; j++) { 
                    update(i, j, matrix[i][j]); 
                } 
            } 
        } 
    } 
 
    public void update(int row, int col, int val) { 
        if (matrix == null || row < 0 || row >= m || col < 0 || col >= n) { 
            return; 
        } 
        int diff = val - matrix[row][col]; 
        matrix[row][col] = val; 
        for (int idx = row+1; idx <= m; idx += (idx & -idx)) { 
            for (int idy = col+1; idy <= n; idy += (idy & -idy)) { 
                tree[idx][idy] += diff; 
            } 
        } 
    } 
 
    public int sumRegion(int row1, int col1, int row2, int col2) { 
        if (matrix == null || row1 >= m || row2 < 0 || col1 >= n || col2 < 0) { 
            return 0; 
        } 
        return sum(row2+1, col2+1) - sum(row1, col2+1) - sum(row2+1, col1) + sum(row1, col1); 
    } 
     
    private int sum(int i, int j) { 
        int sum = 0; 
        for (int idx = i; idx > 0; idx -= (idx & -idx)) { 
            for (int idy = j; idy > 0; idy -= (idy & -idy)) { 
                sum += tree[idx][idy]; 
            } 
        } 
        return sum; 
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix); 
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); 
        numMatrix.update(3, 2, 2); 
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
        
} 