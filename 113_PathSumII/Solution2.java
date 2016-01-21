/** 
 * Definition for binary tree 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
import java.util.LinkedList; 
 
public class Solution2 { 
    public List<List<Integer>> pathSum(TreeNode root, int sum) { 
        List<List<Integer>> results = (List<List<Integer>>) new LinkedList<List<Integer>>(); 
        LinkedList<Integer> result = null;  
        pathSum(root, sum, 0, result, results); 
        return results; 
    } 
     
    private void pathSum(TreeNode x, int sum, int path, LinkedList<Integer> result, List<List<Integer>> results) 
    { 
        if (x == null) return; 
        if (result == null) 
             result =  new LinkedList<Integer>(); 
 
        result.add(x.val); 
        path += x.val; 
         
        if (x.left == null && x.right == null)  
        { 
            if (path == sum)  
            { 
            results.add((List<Integer>) new LinkedList<Integer>(result)); 
            } 
            return; 
        } 
        if (x.left != null) 
        { 
            pathSum(x.left, sum, path, result, results); 
            result.remove(result.size() - 1); 
        } 
         
        if (x.right != null) 
        { 
        pathSum(x.right, sum, path, result, results); 
        result.remove(result.size() - 1); 
        } 
         
    } 
}