public class Solution2 { 
    public int trap(int[] height) { 
        if (height == null || height.length == 0) { 
            return 0; 
        } 
        int N = height.length; 
        int leftHeight = 0, rightHeight = 0; 
        int left = 0, right = N -1; 
        int area = 0; 
        while (left <= right) { 
            leftHeight = Math.max(leftHeight, height[left]); 
            rightHeight = Math.max(rightHeight, height[right]); 
            if (leftHeight < rightHeight) { 
                area += leftHeight - height[left]; 
                left++; 
            } 
            else { 
                area += rightHeight - height[right]; 
                right--; 
            } 
        } 
        return area; 
    } 
}