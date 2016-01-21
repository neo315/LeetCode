// #108 Convert Sorted Array to Binary Search Tree 
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
// Tags:  Tree Depth-first Search

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
    public TreeNode sortedArrayToBST(int[] num) { 
        TreeNode root; 
        root = sortedArrayToBST(num, 0, num.length - 1); 
        return root; 
    } 
     
    private TreeNode sortedArrayToBST(int[] num, int lo, int hi) 
    { 
        int mid = lo + (hi - lo) / 2; 
        if (lo > hi) return null; 
        TreeNode x = new TreeNode(num[mid]); 
        x.left = sortedArrayToBST(num, lo, mid - 1); 
        x.right = sortedArrayToBST(num, mid + 1, hi); 
        return x; 
    } 
}