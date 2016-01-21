// #42 Trapping Rain Water 
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//For example, 
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
//
//
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. 
// Tags: Dynamic programming

public class Solution { 
    public int trap(int[] height) { 
        if (height == null || height.length == 0) return 0; 
        int N = height.length; 
        int[] leftHeight = new int[N]; 
        int[] rightHeight = new int[N]; 
        int volume = 0; 
         
        leftHeight[0] = height[0]; 
        for (int i = 1; i < N; i++) 
            leftHeight[i] = Math.max(leftHeight[i-1], height[i-1]); 
         
        rightHeight[N-1] = height[N-1]; 
        for (int i = N-2; i > 0; i--) 
        { 
            int cur = 0; 
            rightHeight[i] = Math.max(rightHeight[i+1], height[i+1]); 
            cur = Math.min(rightHeight[i], leftHeight[i]) - height[i]; 
            if (cur > 0) volume += cur; 
        } 
        return volume; 
    } 
}