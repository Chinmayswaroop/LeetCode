/* 
Problem :: 
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the 
values along the path equals the given sum.
Note: A leaf is a node with no children.

Example 1:
Input: Given the below binary tree and sum = 22,


	 			  5
			     / \
			    4   8
			   /   / \
			  11  13  4
			 /  \      \
			7    2      1
Output: return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

*/

/*
Analysis ::
Time Complexity :: O(N) where N: is the no of nodes in the tree
Space Complexity :: O(N)
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
    public boolean DFS(TreeNode node, int parentSum, int target){
        if(node ==null)
            return false;
        
        if(node.val+parentSum == target && (node.left==null && node.right==null) )
            return true;
        
        if(DFS(node.left,node.val+parentSum, target) || DFS(node.right,node.val+parentSum, target) )
           return true;
        
        return false;
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        
            
        return DFS(root,0,sum);
    }
}