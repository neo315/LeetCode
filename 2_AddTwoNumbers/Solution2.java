/** 
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { 
 *         val = x; 
 *         next = null; 
 *     } 
 * } 
 */ 

public class Solution { 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
        
        if (l1 == null) return l2; 
        else if (l2 == null) return l1; 
     
        int carry = 0; 
          
        ListNode output = new ListNode(0); 
        ListNode current = output; 
         
        ListNode p1 = l1; 
        ListNode p2 = l2; 
         
        while (p1 != null || p2 != null) 
        { 
            int a, b; 
            a = p1 == null ? 0 : p1.val; 
            b = p2 == null ? 0 : p2.val; 
            current.val = (a + b + carry) % 10; 
            carry = (a + b + carry) / 10; 
 
            p1 = p1 == null ? null : p1.next; 
            p2 = p2 == null ? null : p2.next; 
             
            if (p1 == null && p2 == null) break; 
            current.next = new ListNode(0); 
            current = current.next; 
        } 
         
        if (carry == 1)  
        { 
            current.next = new ListNode(carry); 
            current = current.next; 
        } 
        return output; 
    } 
}
