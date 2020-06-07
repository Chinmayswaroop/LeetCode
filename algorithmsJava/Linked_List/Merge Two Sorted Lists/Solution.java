/* 
Problem :: 
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

/*
Analysis ::
Time Complexity :: O(m+n) :: Imagine this by that we eventually end up making a m+n length which we have to fill
Space Complexity :: O(1)
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;        
        while(l1!=null && l2!=null){            
            if(l1.val >= l2.val){
                head.next=l2;
                head=head.next;
                l2=l2.next;
            }else{
                head.next=l1;
                head=head.next;
                l1=l1.next;
            }
           
        }
        while(l1!=null){
          head.next=l1;
          head=head.next;
          l1 = l1.next;
        }
        
        while(l2!=null){
            head.next = l2;
            head = head.next;
            l2=l2.next;
        }
        return dummy.next;
    }
}