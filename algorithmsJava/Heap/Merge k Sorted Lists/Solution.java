/* 
Problem :: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0){
            return null;
        }
        /* ListNode [] lists means it is array of type ListNode */
        
        ListNode result = null;
        ListNode tail = null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<>((ListNode l1, ListNode l2)->(l1.val- l2.val));
        for(ListNode list : lists){
            if(list!=null)
                heap.add(list);
        }
        while(!heap.isEmpty()){
            ListNode top = heap.poll();
            
            if(result==null){
                /* this is the case when a node will be added for the first time */
                ListNode temp = new ListNode(top.val);
                result = top;
                tail = top;
            }else{
                tail.next = top;
                tail = tail.next;
            }
            
            if(top.next!=null){
                heap.add(top.next);
            }
        }
        return result;
    }
}