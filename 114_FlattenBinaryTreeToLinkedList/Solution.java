// #117 Flatten Binary Tree to Linked List 
//Given a binary tree, flatten it to a linked list in-place.
//
//For example,
//Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
////             6
//Hints:
//If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
// Tags: Tree, Depth-first Search
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
    public void flatten(TreeNode root) { 
        root = flattened(root); 
    } 
     
    private TreeNode flattened(TreeNode x) 
    { 
        if (x == null) return x; 
        if (x.left == null && x.right == null) return x; 
        else if (x.left == null) x.right = flattened(x.right); 
        else if (x.right == null) x.right = flattened(x.left); 
        else 
        { 
            TreeNode temp = flattened(x.left); 
            TreeNode leftEnd = findEnd(temp); 
            leftEnd.right = flattened(x.right); 
            x.right = temp; 
        } 
            x.left = null; 
             
        return x; 
    } 
     
    private TreeNode findEnd(TreeNode x) 
    { 
        if (x == null) return null; 
        TreeNode end = x; 
        while(end.right != null) 
            end = end.right; 
        return end; 
    } 
}