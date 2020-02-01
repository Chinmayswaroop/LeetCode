/* 
Problem :: 
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Example 1:
Input: preorder = [3,9,20,15,7]
	   inorder = [9,3,15,20,7]
Output: 
	3
   / \
  9  20
    /  \
   15   7

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
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
    int preIndex=0;
    
    public TreeNode helper(int [] pre, int [] in, Map<Integer, Integer> store, int start, int end){
        
        if(start > end){
            return null;
        }
        
        TreeNode node = new TreeNode(pre[preIndex++]);
        
        if(start == end){
            return node;
        }
        
        int index = store.get(node.val);
        node.left = helper(pre, in, store, start, index-1);
        node.right = helper(pre, in, store, index+1, end);
        return node;   
    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> store = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            store.put(inorder[i], i);    
        }
        return helper(preorder, inorder, store,  0, inorder.length-1);
        
        
    }
}