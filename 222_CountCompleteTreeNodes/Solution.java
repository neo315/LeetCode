// # 222 Count Complete Tree Nodes
//Given a complete binary tree, count the number of nodes.
//
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
// Tags: Tree, Binary Search

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
    public int countNodes(TreeNode root) { 
        int height = rightHeight(root); 
        int count = 0; 
        if (root == null) return 0; 
        for (int temp = 0; temp < height; temp++) 
            count += 1 << temp; 
        if (height == leftHeight(root)) return count; 
        int lo = 1; 
        int hi = 1 << height; 
         
        while (lo <= hi) 
        { 
            int mid = lo + (hi - lo) / 2; 
            if (leftHeight(root.left) != rightHeight(root.left)) 
            { 
                hi = mid; 
                root = root.left; 
            } 
            else if (leftHeight(root.right) != rightHeight(root.right)) 
            { 
                lo = mid + 1; 
                root = root.right; 
            } 
            else return count + mid; 
        } 
        return -1; 
    } 
     
    private int leftHeight(TreeNode node) 
    { 
        int leftCount = 0; 
        TreeNode left = node; 
        while (left != null) 
        { 
            leftCount++; 
            left = left.left; 
        } 
        return leftCount; 
    } 
     
    private int rightHeight(TreeNode node) 
    { 
        int rightCount = 0; 
        TreeNode right = node; 
        while (right != null) 
        { 
            rightCount++; 
            right = right.right; 
        } 
        return rightCount; 
    } 
}