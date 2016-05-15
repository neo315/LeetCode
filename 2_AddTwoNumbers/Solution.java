// #2 Add Two Numbers
//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Tags:  Linked List, Math

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
         ListNode current; 
          
         current = output; 
         
        ListNode p1 = l1; 
        ListNode p2 = l2; 
         
        while (p1 != null || p2 != null) 
        { 
            if (p1 == null) 
            { 
                current.val = (p2.val + carry) % 10; 
                carry = (p2.val + carry) / 10; 
                p2 = p2.next; 
                if (p2 == null) break; 
                current.next = new ListNode(0); 
                current = current.next; 
            } 
            else if (p2 == null) 
            { 
                current.val = (p1.val + carry) % 10; 
                carry = (p1.val + carry) / 10; 
                p1 = p1.next; 
                if (p1 == null) break; 
                current.next = new ListNode(0); 
                current = current.next; 
            } 
            else{ 
            current.val = (p1.val + p2.val + carry) % 10; 
            carry = (p1.val + p2.val + carry) / 10; 
            p1 = p1.next; 
            p2 = p2.next; 
            if (p1 == null && p2 == null) break; 
            current.next = new ListNode(0); 
            current = current.next; 
            } 
        } 
         
        if (carry == 1)  
        { 
            current.next = new ListNode(0); 
            current = current.next; 
            current.val = carry; 
        } 
        return output; 
    } 
}
