public class Solution2 { 
    public int largestRectangleArea(int[] height) { 
        if (height == null || height.length == 0) return 0; 
         
        int area = 0; 
        Stack<Integer> stack = new Stack<Integer>(); 
         
        for (int i = 0; i < height.length; i++) 
        { 
            if (stack.isEmpty() || height[stack.peek()] < height[i]) 
                stack.push(i); 
            else 
            { 
                int start = stack.pop(); 
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; 
                area = Math.max(area, height[start] * width); 
                i--; 
            } 
        } 
            while (!stack.isEmpty()) 
            { 
                int start  = stack.pop(); 
                int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1; 
                area = Math.max(area, height[start] * width); 
            } 
                
        return area; 
    } 
}