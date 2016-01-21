//// #106 Construct Binary Tree from Inorder and Postorder Traversal 
//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
// Tags:  Tree, Array, Depth-first Search

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
    public TreeNode buildTree(int[] inorder, int[] postorder) { 
        if (inorder == null || postorder == null) return null; 
        if (inorder.length != postorder.length) return null; 
         
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i); 
        return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map); 
    } 
     
    private TreeNode build(int[] post, int postL, int postR, int[] in, int inL, int inR, HashMap<Integer, Integer> map) 
    { 
        if (postL > postR || inL > inR) return null; 
        TreeNode root = new TreeNode(post[postR]); 
        int index = map.get(post[postR]); 
         
        root.left = build(post, postL, postR-inR+index-1, in, inL, index-1, map); 
        root.right = build(post, postR-inR+index, postR-1, in, index+1, inR, map); 
        return root; 
    } 
}