//// #107 Binary Tree Level Order Traversal II 
//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]
//confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
// Tags: Tree, Breadth-first Search
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (root == null) return result; 
         
        LinkedList<TreeNode> level = new LinkedList<TreeNode>(); 
        LinkedList<Integer> item = new LinkedList<Integer>(); 
         
        int curNum = 0; 
        int lastNum = 1; 
         
        level.add(root); 
         
        while (!level.isEmpty()) 
        { 
            TreeNode temp = level.poll(); 
            lastNum--; 
            item.add(temp.val); 
             
            if (temp.left != null) 
            { 
                level.add(temp.left); 
                curNum++; 
            } 
            if (temp.right != null) 
            { 
                level.add(temp.right); 
                curNum++; 
            } 
             
            if (lastNum == 0) 
            { 
                lastNum = curNum; 
                curNum = 0; 
                result.add(item); 
                item = new LinkedList<Integer>(); 
            } 
        } 
        Collections.reverse(result); 
        return result; 
    } 
}
