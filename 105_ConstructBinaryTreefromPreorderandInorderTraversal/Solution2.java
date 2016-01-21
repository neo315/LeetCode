//http://blog.csdn.net/linhuanmars/article/details/24389549
/** 
 * Definition for binary tree 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
import java.util.HashMap; 
public class Solution2 { 
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        if (preorder.length == 0) return null; 
        if (preorder.length != inorder.length) return null; 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i); 
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map); 
    } 
     
    private TreeNode build(int[] pre, int preL, int preR, int[] in, int inL, int inR, HashMap<Integer, Integer> map) 
    { 
        if (preL > preR || inL > inR) return null; 
        TreeNode root = new TreeNode(pre[preL]); 
         
        int index = map.get(pre[preL]); 
        root.left = build(pre, preL+1, index-inL+preL, in, inL, index-1, map); 
        root.right = build(pre, index-inL+preL+1, preR, in, index+1, inR, map); 
        return root; 
    } 
}