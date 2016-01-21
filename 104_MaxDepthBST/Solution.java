// #104 Maximum Depth of Binary Tree 
// Given a binary tree, find its maximum depth.
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//  Tree, Depth-first Search

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
    public int maxDepth(TreeNode root) { 
        if (root ==  null) return 0; 
        int leftDepth = maxDepth(root.left); 
        int rightDepth = maxDepth(root.right); 
        if (leftDepth < rightDepth) return 1 + rightDepth; 
        else return 1+ leftDepth; 
        } 
}

