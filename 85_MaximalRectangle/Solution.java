// # 85 Maximal Rectangle 
//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
//
// Tags: Array, Hash Table, Stack,public class Solution { 
    public int maximalRectangle(char[][] matrix) { 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return 0; 
        int[] height = new int[matrix[0].length]; 
        int max = 0; 
        for (int i = 0; i < matrix.length; i++) 
        {     
            for (int j = 0; j < matrix[0].length; j++) 
            { 
                height[j] = matrix[i][j] == '0' ? 0 : height[j]+1; 
            } 
             
            max = Math.max(max, largestRectangleArea(height)); 
        } 
        return max; 
    } 
     
    private int largestRectangleArea(int[] height) 
    { 
        if (height == null || height.length == 0) 
            return 0; 
        int area = 0; 
        Stack<Integer> stack = new Stack<Integer>(); 
         
        for (int i = 0; i < height.length; i++) 
        { 
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) 
            { 
                int index = stack.pop(); 
                int curArea = stack.isEmpty() ? i*height[index] : (i - stack.peek() - 1)*height[index]; 
                area = Math.max(area, curArea); 
            } 
            stack.push(i); 
        } 
        while (!stack.isEmpty()) 
        { 
            int index = stack.pop(); 
            int curArea = stack.isEmpty() ? height.length*height[index] : (height.length - stack.peek() - 1)*height[index]; 
            area = Math.max(area, curArea); 
        } 
        return area; 
    } 
}
