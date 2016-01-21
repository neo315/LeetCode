// #111 Minimum Depth of Binary Tree 
// Given a binary tree, find its minimum depth.

//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
// Tags: Tree Depth-first Search

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
    public int minDepth(TreeNode root) { 
         
        if (root == null) return 0; 
         
        return findMin(root); 
    } 
     
    private int findMin(TreeNode root) 
    { 
        if (root.left == null && root.right == null) return 1; 
        if (root.left == null) return findMin(root.right) + 1; 
        if (root.right == null) return findMin(root.left) + 1; 
         
        int leftMin = findMin(root.left); 
        int rightMin = findMin(root.right); 
         
        if (leftMin < rightMin) return leftMin + 1; 
        else return rightMin + 1; 
    } 
}