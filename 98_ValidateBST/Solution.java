//// #98 Validate Binary Search Tree
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

// Tags: Tree Depth-first Search  
// Note: remember to check the max of left subtree is less than root, and the min of right subtree is larger than root.
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
    public boolean isValidBST(TreeNode root) { 
     if (root == null) return true; 
     if (root.left != null && max(root.left) >=  root.val) return false; 
     if (root.right != null && min(root.right) <= root.val) return false; 
      
     return isValidBST(root.left) && isValidBST(root.right); 
    } 
    private int max(TreeNode x) 
    { 
        while (x.right != null) x = x.right; 
        return x.val; 
    } 
    private int min (TreeNode x) 
    { 
        while (x.left != null) x = x.left; 
        return x.val; 
    } 
}