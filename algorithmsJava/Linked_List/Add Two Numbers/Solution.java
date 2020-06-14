/* 
Problem :: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes 
contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/*
Analysis ::
Time Complexity :: O(max(size l1, size l2))
Space Complexity :: O(m+n)
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy = new ListNode(0);
        ListNode head  = dummy;
        
        while(l1!=null && l2!=null){
            int no = l1.val + l2.val + carry;
            carry = no/10;
            ListNode temp = new ListNode(no%10);
            head.next=temp;
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null){
            int no = l1.val + carry;
            carry = no/10;
            ListNode temp = new ListNode(no%10);
            head.next=temp;
            head=head.next;
            l1=l1.next;
        }
        
         while(l2!=null){
            int no = l2.val + carry;
            carry = no/10;
            ListNode temp = new ListNode(no%10);
            head.next=temp;
            head=head.next;
            l2=l2.next;
        }
        
        if(carry!=0)
            head.next = new ListNode(carry);
        
        return dummy.next;
    }
}

