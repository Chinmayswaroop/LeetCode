/* 
Problem :: 
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.

Example 1:
Input: Given binary tree [3,9,20,null,null,15,7]
Output: 2

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
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
    /* int minDepth=0; */
    public int depth(TreeNode root){
        if(root ==null){
            return 0;
        }
        
        int left = depth(root.left);
        int right = depth(root.right);
        if(left==0 || right==0)     
            return left+right+1;
        else /* both zeros or both non zeroes */
            return Math.min(left,right)+1;  /* minDepth = Math.min(left,right); */
 
    }
    public int minDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
         return depth(root);
    }
}