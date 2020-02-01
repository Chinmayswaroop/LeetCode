/* 
Problem :: 
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

For better descripton of problem visit link :: https://leetcode.com/problems/intersection-of-two-linked-lists/

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

/*
Analysis ::
Time Complexity :: O(m+n)
Space Complexity :: O(1)
*/


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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int size1=0,size2=0;
        ListNode h1=headA;
        ListNode h2 = headB;
        
        while(h1!=null){
            size1++;
            h1=h1.next;
        }
        
        while(h2!=null){
            size2++;
            h2=h2.next;
        }
        
        h1 = headA;
        h2 = headB;
        
        int diff = Math.abs(size1-size2);
        
        while(diff!=0){
            if(size1>size2){
                h1=h1.next;
            }else{
                h2=h2.next;
            }
            diff--;
        }
        
        while(h1 != h2){
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
        
    }
}
