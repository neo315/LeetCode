// #129 Sum Root to Leaf Numbers 
// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.
//
//For example,
//
//    1
//   / \
//  2   3
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//
//Return the sum = 12 + 13 = 25.

// Tags:  Tree, Depth-first Search

/** 
 * Definition for binary tree 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */ 
 
public class Solution { 
    public int sumNumbers(TreeNode root) { 
       int sum = 0; 
       return sumNumbers(root, sum); 
    } 
     
    private int sumNumbers(TreeNode x, int sum) 
    { 
        if (x == null) return 0; 
         
        if (x.left == null && x.right == null)  
            return sum * 10 + x.val; 
        else 
            return sumNumbers(x.left, 10 * sum + x.val) + 
            sumNumbers(x.right, 10 * sum + x.val); 
    }    
}