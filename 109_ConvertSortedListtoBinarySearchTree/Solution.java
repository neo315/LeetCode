// #109 Convert Sorted List to Binary Search Tree
//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
// Tags: Depth-first Search, Linked List

/** 
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { val = x; next = null; } 
 * } 
 */ 
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
    static ListNode currenthead = null; 
    public TreeNode sortedListToBST(ListNode head) { 
        if (head == null) return null; 
        int N = 0; 
        ListNode cur = head; 
        while (cur != null) 
            { 
                cur = cur.next; 
                N++; 
            } 
        currenthead = head; 
        return buildTree(0, N-1); 
    } 
     
    private TreeNode buildTree(int start, int end) 
    { 
        if (start > end) return null; 
        int mid = start + (end - start) / 2; 
        TreeNode left = buildTree(start, mid - 1); 
        TreeNode root = new TreeNode(currenthead.val); 
        root.left = left; 
        currenthead = currenthead.next; 
        root.right = buildTree(mid + 1, end); 
        return root; 
    } 
}
