// 250 Count Univalue Subtrees
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
    public int countUnivalSubtrees(TreeNode root) { 
        int[] result = {0}; 
        allSameValue(root, result); 
        return result[0]; 
    } 
    private boolean allSameValue(TreeNode node, int[] result) { 
        if (node == null) { 
            return true; 
        } 
        //System.out.println("Current: " + node.val); 
        boolean leftSame = allSameValue(node.left, result); 
        boolean rightSame = allSameValue(node.right, result); 
        if (!leftSame || (node.left != null && node.left.val != node.val)) { 
                return false; 
        } 
        if (!rightSame || (node.right != null && node.right.val != node.val)) { 
                return false; 
        } 
        result[0]++; 
        return true; 
    } 
}
