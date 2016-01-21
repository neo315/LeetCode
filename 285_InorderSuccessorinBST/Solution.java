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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) { 
        if (p.right != null) { 
            TreeNode cur = p.right; 
            while (cur.left != null) { 
                cur = cur.left; 
            } 
            return cur; 
        } 
        TreeNode candidate = null; 
        TreeNode node = root; 
        while (node != p) { 
            int cmp = p.val - node.val; 
            if (cmp > 0) { 
                node = node.right; 
            } 
            else if (cmp < 0) { 
                candidate = node; 
                node = node.left; 
            } 
        } 
        return candidate; 
    } 
}