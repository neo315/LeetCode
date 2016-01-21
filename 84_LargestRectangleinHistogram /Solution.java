// # 84 Largest Rectangle in Histogram
//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//For example,
//Given height = [2,1,5,6,2,3],
//return 10.
//
// Tags: Array, Stack

public class Solution { 
    public int largestRectangleArea(int[] height) { 
        if (height == null || height.length == 0) return 0; 
        int area = 0; 
        Stack<Integer> heightStack = new Stack<Integer>(); 
        Stack<Integer> indexStack = new Stack<Integer>(); 
         
        for (int i = 0; i < height.length; i++) 
        { 
            if (heightStack.isEmpty() || heightStack.peek() <= height[i]) 
            { 
                heightStack.push(height[i]); 
                indexStack.push(i); 
            } 
            else if (heightStack.peek() > height[i]) 
            { 
                int j = 0; 
                while (!heightStack.isEmpty() && heightStack.peek() > height[i]) 
                { 
                    j = indexStack.pop(); 
                    int curArea = (i - j) * heightStack.pop(); 
                    if (curArea > area) area = curArea; 
                } 
                heightStack.push(height[i]); 
                indexStack.push(j); 
            } 
        } 
         
        while (!heightStack.isEmpty()) 
        { 
            int curArea = (height.length - indexStack.pop()) * heightStack.pop(); 
            if (curArea > area) area = curArea; 
        } 
        return area; 
    } 
}