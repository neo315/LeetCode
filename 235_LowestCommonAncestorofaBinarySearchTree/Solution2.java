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
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) { 
        if (node == null) { 
            return null; 
        } 
        if (node ==  p) { 
            return p; 
        } 
        if (node == q) { 
            return q; 
        } 
        TreeNode left = lowestCommonAncestor(node.left, p, q); 
        TreeNode right = lowestCommonAncestor(node.right, p, q); 
        if (left == null && right == null) { 
            return null; 
            } 
        else if (left == null) { 
            return right; 
        } 
        else if (right == null) { 
            return left; 
        } 
        else { 
            return node; 
        } 
    } 
}