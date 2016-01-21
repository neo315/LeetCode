// #199 Binary Tree Right Side View
//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//For example:
//Given the following binary tree,
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//You should return [1, 3, 4].
// Tags: Tree, Depth-first Search, Breadth-first Search

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
    public List<Integer> rightSideView(TreeNode root) { 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        if (root == null) return result; 
        int[] maxlevel = {0}; 
        rightSide(root, 1, maxlevel, result); 
        return result; 
    } 
     
    private void rightSide(TreeNode x, int level, int[] maxlevel, ArrayList<Integer> result) 
    { 
        if (x == null) return; 
        if (maxlevel[0] < level) 
        { 
            maxlevel[0] = level; 
            result.add(x.val); 
        } 
        rightSide(x.right, level + 1, maxlevel, result); 
        rightSide(x.left, level + 1, maxlevel, result); 
        return; 
    } 
}