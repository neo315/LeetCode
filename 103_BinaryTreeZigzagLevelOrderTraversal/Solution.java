//// #103 Binary Tree Zigzag Level Order Traversal 
//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]
//confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
// Tags:  Tree, Breadth-first Search, Stack

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { 
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (root == null) return result; 
         
        LinkedList<TreeNode> level = new LinkedList<TreeNode>(); 
        LinkedList<Integer> item = new LinkedList<Integer>(); 
         
        int curNum =0; 
        int lastNum = 1; 
        boolean fromLeft = true; 
         
        level.add(root); 
         
        while (!level.isEmpty()) 
        { 
            TreeNode temp = level.poll(); 
            lastNum--; 
            if (fromLeft) item.add(temp.val); 
            else item.addFirst(temp.val); 
             
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
                fromLeft = !fromLeft; 
            } 
        } 
        return result; 
    } 
}