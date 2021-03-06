/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
public class Solution2 { 
    private TreeNode prev = null; 
    public void flatten(TreeNode root) { 
        if (root == null) { 
            return; 
        } 
        flatten(root.right); 
        flatten(root.left); 
        root.right = prev; 
        root.left = null; 
        prev = root; 
        return; 
    } 
}