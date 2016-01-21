public class Solution2 { 
    public int maximalRectangle(char[][] matrix) { 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { 
            return 0; 
        } 
        int m = matrix.length; 
        int n = matrix[0].length; 
        int[] height = new int[n]; 
        int[] left = new int[n]; 
        int[] right = new int[n]; 
        for (int i = 0; i < n; i++) { 
            right[i] = n; 
        } 
        int area = 0; 
        for (int j = 0; j < m; j++) { 
            int curLeft = 0; 
            int curRight = n; 
            // get the curLeft by scanning from left to right, fill the left[i] at the same time 
            for (int i = 0; i < n; i++) { 
                if (matrix[j][i] == '1') { 
                    left[i] = Math.max(left[i], curLeft); 
                } 
                else { 
                    left[i] = 0; 
                    curLeft = i + 1; 
                } 
            } 
            for (int i = 0; i < n; i++) { 
                if (matrix[j][i] == '1') { 
                    height[i]++; 
                } 
                else { 
                    height[i] = 0; 
                } 
            } 
            for (int i = n-1; i >= 0; i--) { 
                if (matrix[j][i] == '1') { 
                    right[i] = Math.min(right[i], curRight); 
                } 
                else { 
                    right[i] = n; 
                    curRight = i; 
                } 
            } 
            for (int i = 0; i < n; i++) { 
                area = Math.max(area, height[i] * (right[i] - left[i])); 
            } 
        } 
        return area; 
    } 
}