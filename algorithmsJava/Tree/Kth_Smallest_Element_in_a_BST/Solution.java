/* 
Problem :: 
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.




Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
Note: "aba" is also a valid answer.

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

*/

/*
Analysis ::
Time Complexity :: O(H+k) 
Space Complexity :: O(H+k)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
       
       /* iteratice approach is better so that we donot have to 
       traverse the entire tree and can stop iteration when ever we get kth element*/
       Stack<TreeNode> stack = new Stack<>();
       TreeNode top =null; 
       while(k!=0){
           while(root!=null){
                stack.add(root);
               root = root.left;
            }
           top = stack.pop();
           k--;
           root=top.right;
           
       }
     return top.val;
    }
}
