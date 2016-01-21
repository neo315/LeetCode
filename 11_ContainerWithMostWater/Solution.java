// # 11 Container With Most Water
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//Note: You may not slant the container.
//
// Tags: Array, Two Pointers
public class Solution { 
    public int maxArea(int[] height) { 
        if (height == null || height.length == 0) return 0; 
         
        int area = 0; 
        int lh = 0; 
        int rh = height.length - 1 ; 
         
        while (lh < rh) 
        { 
            area = Math.max(area, Math.min(height[lh], height[rh])*(rh - lh)); 
            if (height[lh] < height[rh]) lh++; 
            else rh--; 
        } 
        return area; 
    } 
}