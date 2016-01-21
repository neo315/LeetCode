/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
public class Solution3 { 
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        if (preorder == null || inorder == null || preorder.length != inorder.length) { 
            return null; 
        } 
        int N = preorder.length; 
        return build(preorder, 0, N - 1, inorder, 0, N - 1); 
    } 
    private TreeNode build(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2) { 
        if (L1 > R1) { 
            return null; 
        } 
        // search the root element value in the inorder array 
        int target = 0; 
        for (target = L2; target <= R2; target++) { 
            if (inorder[target] == preorder[L1]) break; 
        } 
        int leftLen = target - L2; 
        int rightLen = R2 - target; 
        TreeNode node = new TreeNode(preorder[L1]); 
        node.left = build(preorder, L1 + 1, L1 + leftLen, inorder, L2, target - 1); 
        node.right = build(preorder,L1 + leftLen + 1, L1 + leftLen + rightLen, inorder, target + 1, R2); 
        return node; 
    } 
}