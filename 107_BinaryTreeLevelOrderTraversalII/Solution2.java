/** 
 * Definition for binary tree 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
public class Solution2 { 
    public List<List<Integer>> levelOrderBottom(TreeNode root) { 
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>(); 
        if (root == null) return result; 
         
        LinkedList<TreeNode> level = new LinkedList<TreeNode>(); 
        LinkedList<Integer> item = new LinkedList<Integer>(); 
         
        int curNum = 0; 
        int lastNum = 1; 
         
        level.add(root); 
         
        while (!level.isEmpty()) 
        { 
            TreeNode temp = level.poll(); 
            lastNum--; 
            item.add(temp.val); 
             
            if (temp.left != null) 
            { 
                level.add(temp.left); 
                curNum++; 
            } 
            if (temp.right != null) 
            { 
                level.add(temp.right); 
                curNum++; 
            } 
             
            if (lastNum == 0) 
            { 
                lastNum = curNum; 
                curNum = 0; 
                result.addFirst(item); 
                item = new LinkedList<Integer>(); 
            } 
        } 
        return result; 
    } 
}