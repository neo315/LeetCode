/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
// 298 Binary Tree Longest Consecutive Sequence
//Given a binary tree, find the length of the longest consecutive sequence path.
//
//The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
//    
public class Solution { 
    public int longestConsecutive(TreeNode root) { 
        if (root == null) { 
            return 0; 
        } 
        int[] max = {1}; 
        maxPath(root, max); 
        return max[0]; 
    } 
     
    private int maxPath(TreeNode node, int[] max) { 
        if (node == null) { 
            return 0; 
        } 
        int left = maxPath(node.left, max); 
        int right = maxPath(node.right, max); 
        int result = 1; 
        if (node.left != null && node.val == node.left.val - 1) { 
            result = Math.max(result, left + 1); 
        } 
        if (node.right != null && node.val == node.right.val - 1) { 
            result = Math.max(result, right + 1); 
        } 
        max[0] = Math.max(max[0], result); 
        return result; 
    } 
}