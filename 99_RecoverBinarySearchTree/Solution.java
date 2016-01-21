// #99 Recover Binary Search Tree
//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.
//
//Note:
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
        TreeNode mistake1; 
        TreeNode mistake2; 
        TreeNode pre; 
         
    public void recoverTree(TreeNode root) { 
        recursive_traversal(root); 
        if (mistake1 != null && mistake2 != null) 
        { 
            int temp = mistake1.val; 
            mistake1.val = mistake2.val; 
            mistake2.val = temp; 
        } 
            return; 
    } 
     
    private void recursive_traversal(TreeNode x) 
    { 
        if (x == null) return; 
         
        if (x.left != null) recursive_traversal(x.left); 
         
        if (pre != null && pre.val > x.val) 
        { 
            if (mistake1 == null) 
            { 
                mistake1 = pre; 
                mistake2 = x; 
            } 
            else mistake2 = x; 
        } 
        pre = x; 
        if (x.right != null) recursive_traversal(x.right); 
        return; 
    } 
}