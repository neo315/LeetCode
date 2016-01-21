 
public class Solution2 { 
    public ListNode rotateRight(ListNode head, int k) { 
        ListNode dummy = new ListNode(-1); 
        dummy.next = head; 
        int cnt = 0; 
        while (head != null) { 
            head = head.next; 
            cnt++; 
        } 
        if (cnt == 0 || k % cnt == 0) return dummy.next; 
        k = k % cnt; 
        ListNode cur = dummy, pre = dummy; 
        for (int i = 0; i < k; i++) { 
            cur = cur.next; 
        } 
        while (cur.next != null) { 
            cur = cur.next; 
            pre = pre.next; 
        } 
        ListNode oldHead = dummy.next; 
        dummy.next = pre.next; 
        pre.next = null; 
        cur.next = oldHead; 
        return dummy.next; 
    } 
}