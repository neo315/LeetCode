// #110 Balanced Binary Tree 
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree,
//in which the depth of the two subtrees of every node never differ by more than 1.
// Tags:  Tree, Depth-first Search

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
    public boolean isBalanced(TreeNode root) { 
        if (root == null) return true; 
         
        int cmp = height(root.left) - height(root.right); 
        if (cmp > 1 || cmp < -1) return false; 
        else if (!isBalanced(root.left)) return false; 
        else if (!isBalanced(root.right)) return false; 
        else return true; 
    } 
     
    private int height(TreeNode x) 
    { 
        if (x == null) return 0; 
        else return Math.max(height(x.left), height(x.right)) + 1; 
    } 
}