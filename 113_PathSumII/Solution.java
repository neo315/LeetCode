// #113 path Sum II
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// Tags:  Tree Depth-first Search

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
 
public class Solution { 
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
            results.add((List<Integer>)result); 
            } 
            return; 
        } 
        LinkedList<Integer> clone = new LinkedList<Integer>(result); 
 
        pathSum(x.left, sum, path, result, results); 
        pathSum(x.right, sum, path, clone, results); 
         
    } 
}