// #112 Path Sum
// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
    public boolean hasPathSum(TreeNode root, int sum) { 
        int path = 0; 
        return hasPathSum(root, sum, path); 
    } 
     
    private boolean hasPathSum(TreeNode x, int sum, int path) 
    { 
        if (x == null) return false; 
        
        path += x.val; 
         
        if (x.left == null && x.right == null)  
            return path == sum; 
         
        return (hasPathSum(x.left, sum, path) || hasPathSum(x.right, sum, path)); 
    } 
}