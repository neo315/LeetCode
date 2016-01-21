/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
public class Solution2 { 
    TreeNode firstElement = null; 
    TreeNode secondElement = null; 
    TreeNode pre = new TreeNode(Integer.MIN_VALUE); 
    public void recoverTree(TreeNode root) { 
        traversal(root); 
        int temp = firstElement.val; 
        firstElement.val = secondElement.val; 
        secondElement.val = temp; 
        return; 
    } 
    private void traversal(TreeNode node) { 
        if (node == null) { 
            return; 
        } 
        traversal(node.left); 
        if (firstElement == null && pre.val >= node.val) { 
            firstElement = pre; 
        } 
        if (firstElement != null && pre.val >= node.val) { 
            secondElement = node; 
        }  
        pre = node; 
        traversal(node.right); 
        return; 
    } 
}