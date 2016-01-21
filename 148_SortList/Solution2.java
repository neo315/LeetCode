
 
public class Solution { 
     private class ListNode { 
      int val; 
      ListNode next; 
      ListNode(int x) { val = x; } 
  } 
 
    public ListNode sortList(ListNode head) { 
        if (head == null || head.next == null) { 
            return head; 
        } 
        ListNode fast = head; 
        ListNode slow = head; 
        while (fast.next != null && fast.next.next != null) { 
            fast = fast.next.next; 
            slow = slow.next; 
        } 
        ListNode newHead = slow.next; 
        slow.next = null; 
        return merge(sortList(head), sortList(newHead)); 
    } 
    private ListNode merge(ListNode node1, ListNode node2) { 
        ListNode dummy = new ListNode(-1); 
        ListNode head = dummy; 
        while (node1 != null || node2 != null) { 
            if (node1 == null || (node2 != null && node1.val >= node2.val)) { 
                head.next = node2; 
                node2 = node2.next; 
            }  
            else { 
                head.next = node1; 
                node1 = node1.next; 
            } 
            head = head.next; 
        } 
        return dummy.next; 
    } 
}