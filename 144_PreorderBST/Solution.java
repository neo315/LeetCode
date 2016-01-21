// #144 Binary Tree Preorder Traversal 
// Given a binary tree, return the preorder traversal of its nodes' values.
// Note: Recursive solution is trivial, could you do it iteratively?
// Tree, Stack

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
    public List<Integer> preorderTraversal(TreeNode root) { 
        Stack<Integer> output = new Stack<Integer>(); 
        preorderTraversal(root, output); 
        return output; 
    } 
     
    private void preorderTraversal(TreeNode node, Stack<Integer> s) 
    { 
        if (node == null) return; 
         
        s.push(node.val); 
        preorderTraversal(node.left, s); 
        preorderTraversal(node.right,s); 
    } 
}

// Iterative
public class Solution { 
    public List<Integer> preorderTraversal(TreeNode root) { 
         
        LinkedList<Integer> output = new LinkedList<Integer>(); 
         
        Stack<TreeNode> nodestack = new Stack<TreeNode>(); 
         
        if (root != null) nodestack.push(root); 
         
        TreeNode current; 
         
        while (!nodestack.empty()) 
        { 
            current = nodestack.pop(); 
            output.add(current.val); 
            if (current.right != null) nodestack.push(current.right); 
            if (current.left != null) nodestack.push(current.left); 
        } 
         
        return output; 
    } 
}