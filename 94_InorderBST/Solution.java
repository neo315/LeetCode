// #94 Binary Tree Inorder Traversal 
// Given a binary tree, return the inorder traversal of its nodes' values.
//  Tree, Hash Table, Stack

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
    public List<Integer> inorderTraversal(TreeNode root) { 
         
        Stack<Integer> output = new Stack<Integer>(); 
        inorderTraversal(root, output); 
        return output; 
    } 
     
    private void inorderTraversal(TreeNode node, Stack<Integer> output) 
    { 
        if (node == null) return; 
        inorderTraversal(node.left, output); 
        output.push(node.val); 
        inorderTraversal(node.right, output); 
    } 
}


public class Solution { 
    public List<Integer> inorderTraversal(TreeNode root) { 
         
        LinkedList<Integer> output = new LinkedList<Integer>(); 
        Stack<TreeNode> nodestack = new Stack<TreeNode>(); 
         
        TreeNode current = root; 
        
        while (!nodestack.empty() || current != null)  
        { 
             
            if (current != null)  
            { 
                nodestack.push(current); 
                current = current.left; 
 
            } 
            else 
            { 
                current = nodestack.pop(); 
                output.add(current.val); 
                current = current.right; 
 
                } 
        } 
        return output; 
    } 
}
