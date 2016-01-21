// #124 Binary Tree Maximum Path Sum 
// Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.
//
//For example:
//Given the below binary tree,
//
//       1
//      / \
//     2   3
//Return 6.

// Tags: Tree, Depth-first Search

/** 
 * Definition for binary tree 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
public class Solution { 
    public int maxPathSum(TreeNode root) { 
        int[] max ={Integer.MIN_VALUE}; 
        getMax(root, max); 
        return max[0]; 
    } 
     
    private int getMax(TreeNode x, int[] max) 
    { 
        if (x == null) return 0; 
         
        int leftMax = getMax(x.left, max); 
        int rightMax = getMax(x.right, max); 
        int arch = leftMax + rightMax + x.val; 
         
        int maxPathToRoot = Math.max(x.val, Math.max(leftMax, rightMax) + x.val); 
         
        max[0] = Math.max(max[0], Math.max(arch, maxPathToRoot)); 
         
        return maxPathToRoot; 
    } 
}