// # 145 Binary Tree Postorder Traversal
//Given a binary tree, return the postorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [3,2,1].
//
//Note: Recursive solution is trivial, could you do it iteratively?
//
//Tags: Tree, Stack

/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
public class Solution { 
    public List<Integer> postorderTraversal(TreeNode root) { 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode lastvisited = null; 
        TreeNode node = root; 
        while (!stack.empty() || node != null) 
        { 
            if (node != null) 
            { 
                stack.push(node); 
                node = node.left; 
            } 
            else 
            { 
                TreeNode peeknode = stack.peek(); 
                if (peeknode.right != null && lastvisited != peeknode.right) 
                    node = peeknode.right; 
                else  
                { 
                    result.add(peeknode.val); 
                    lastvisited = stack.pop(); 
                } 
            } 
        } 
        return result; 
    } 
}