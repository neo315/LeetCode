// # 25 Reverse Nodes in k-Group 
//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//You may not alter the values in the nodes, only nodes itself may be changed.
//
//Only constant memory is allowed.
//
//For example,
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5
//
//Tags: Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode pre = newhead;
        ListNode cur = head;
        int cnt = 0;
        
        while (cur != null)
        {
            cnt++;
            ListNode next = cur.next;
            if (cnt == k) 
            {
                pre = reverse(pre, next);
                cnt = 0;
            }
            cur = next;
        }
        return newhead.next;
    }
    
    private ListNode reverse(ListNode pre, ListNode end)
    {
        if (pre == null || pre.next == null) return pre;
        ListNode head = pre.next;
        ListNode cur = head.next;

        while (cur != end)
        {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }
}