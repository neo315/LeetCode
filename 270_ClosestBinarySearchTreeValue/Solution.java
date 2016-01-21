// 270 Closest Binary Search Tree Value
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
    public int closestValue(TreeNode root, double target) { 
        if (root == null) { 
            return Integer.MAX_VALUE; 
        } 
        int newTarget = (int) target; 
        Integer floor = floor(root, newTarget+1); 
        Integer ceiling = ceiling(root, newTarget); 
        System.out.println("floor: " + floor + " ceiling: " + ceiling); 
        if (floor == null && ceiling == null) { 
            return root.val; 
        } 
        else if (floor == null) { 
            return ceiling; 
        } 
        else if (ceiling == null) { 
            return floor; 
        } 
        else { 
            return Math.abs((double)floor - target) < Math.abs((double)ceiling - target) ? floor : ceiling; 
        } 
    } 
    private Integer floor(TreeNode node, int target) { 
        if (node == null) { 
            return null; 
        } 
        if (target == node.val) { 
            return node.val; 
        } 
        else if (target < node.val) { 
            return floor(node.left, target); 
        } 
        else { 
            Integer t = floor(node.right, target); 
            if (t != null) { 
                return t; 
            } 
            else { 
                return node.val; 
            } 
        } 
    } 
    private Integer ceiling(TreeNode node, int target) { 
        if (node == null) { 
            return null; 
        } 
        if (target == node.val) { 
            return node.val; 
        } 
        else if (target > node.val) { 
            return ceiling(node.right, target); 
        } 
        else { 
            Integer t = ceiling(node.left, target); 
            if (t != null) { 
                return t; 
            } 
            else { 
                return node.val; 
            } 
        } 
    } 
}