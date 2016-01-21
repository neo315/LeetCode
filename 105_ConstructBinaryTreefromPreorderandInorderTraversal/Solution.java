//// #105 Construct Binary Tree from Preorder and Inorder Traversal 
//// Given preorder and inorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.

/** 
 * Definition for binary tree 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
import java.util.HashMap; 
public class Solution { 
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        if (preorder.length == 0) return null; 
        if (preorder.length != inorder.length) return null; 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i); 
        TreeNode root = new TreeNode(preorder[0]); 
        for (int i = 1; i < preorder.length; i++) 
            root = build(root, preorder[i], map); 
        return root; 
    } 
     
    private TreeNode build(TreeNode x, int value, HashMap<Integer, Integer> map) 
    { 
        if (x == null) return new TreeNode(value); 
        int cmp = map.get(value) - map.get(x.val); 
        if (cmp < 0)  x.left = build(x.left, value, map); 
        else  x.right = build(x.right, value, map); 
        return x; 
    } 
}