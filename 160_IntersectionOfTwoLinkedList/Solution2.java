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
public class Solution2 { 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { 
      
     if (headA == null || headB == null) return null; 
      
     ListNode p1 = headA; 
     ListNode p2 = headB; 
     ListNode endA = headA; 
     ListNode endB = headB; 
      
     int sizeA = 0; 
     int sizeB = 0; 
     int d = 0; 
      
     while (p1 != null) 
     { 
         endA = p1; 
         p1 = p1.next; 
         sizeA++; 
     } 
      
     while (p2 != null) 
     { 
         sizeB++; 
         endB = p2; 
         p2 = p2.next; 
     } 
     if (endA != endB) return null; 
      
     d = sizeA - sizeB; 
     p1 = headA; 
     p2 = headB; 
          
     if (d > 0) 
     {   
         for (int i = 0; i < d; i++) 
             p1 = p1.next; 
     } 
     else 
     { 
         for (int i = 0; i < -d; i++) 
             p2 = p2.next; 
     } 
      
     while (p1 != null && p2 != null) 
     { 
         if (p1 == p2) return p1; 
         p1 = p1.next; 
         p2 = p2.next; 
     } 
      
     return null; 
    } 
}