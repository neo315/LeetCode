// #117 Populating Next Right Pointers in Each Node II 
//Follow up for problem "Populating Next Right Pointers in Each Node".
//
//What if the given tree could be any binary tree? Would your previous solution still work?
//
//Note:
//
//You may only use constant extra space.
//For example,
//Given the following binary tree,
//         1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \    \
//    4-> 5 -> 7 -> NULL
// Tags: Tree, Depth-first Search

/** 
 * Definition for binary tree with next pointer. 
 * public class TreeLinkNode { 
 *     int val; 
 *     TreeLinkNode left, right, next; 
 *     TreeLinkNode(int x) { val = x; } 
 * } 
 */ 
 
public class Solution {  
    public void connect(TreeLinkNode root) {  
          
        if (root == null) return;  
        TreeLinkNode cur = root;  
        TreeLinkNode nextlevel = null;  
        TreeLinkNode previousright = root.left; 
 
        while (cur != null)  
        {  
            if (nextlevel == null) nextlevel = cur.left; 
            if (nextlevel == null) nextlevel = cur.right; 
             
            if (cur.left != null) 
            { 
                    cur.left.next = cur.right; 
                    previousright = cur.left; 
            } 
             
            if (cur.right != null) previousright = cur.right; 
             
            cur = cur.next; 
             
            if (cur == null)  
            { 
                cur = nextlevel; 
                if (cur == null) break; 
                nextlevel = cur.left; 
                previousright = cur.left; 
            } 
            else if (previousright != null) 
            { 
                if (cur.left != null) previousright.next = cur.left; 
                else previousright.next = cur.right; 
            } 
        } 
    } 
}