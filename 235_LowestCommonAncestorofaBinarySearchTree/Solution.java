// 235 Lowest Common Ancestor of a Binary Search Tree

/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
public class Solution { 
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) { 
        if (p == null && q == null || node == null) { 
            return null; 
        } 
        if (p.val > q.val) { 
            return lowestCommonAncestor(node, q, p); 
        } 
         
        if (node ==  p) { 
            return p; 
        } 
        if (node == q) { 
            return q; 
        } 
        if (p. val < node.val && q.val > node.val) { 
            return node; 
        } 
        else if (p.val < node.val && q.val < node.val) { 
            return lowestCommonAncestor(node.left, p, q); 
        } 
        else { 
            return lowestCommonAncestor(node.right, p, q); 
        } 
    } 
}