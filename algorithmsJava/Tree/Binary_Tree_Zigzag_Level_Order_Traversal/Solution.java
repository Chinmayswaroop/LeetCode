/* 
Problem :: 
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, 
then right to left for the next level and alternate between).

For better descripton of problem visit link ::  

Example 1:
Input: Given binary tree [3,9,20,null,null,15,7]
Output: 
		[
		  [3],
		  [20,9],
		  [15,7]
		] 


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> inner = new ArrayList<>();
            
            while(!s1.isEmpty()){
                root = s1.pop();
                inner.add(root.val);    
                
                if(root.left!=null){
                    s2.push(root.left);    
                }
                if(root.right!=null){
                    s2.push(root.right);
                }
            
            }
            if(!inner.isEmpty()){
                result.add(inner);
                inner = new ArrayList<>();
            }
            
            
            
            while(!s2.isEmpty()){
                root = s2.pop();
                inner.add(root.val);    
                
                if(root.right!=null){
                    s1.push(root.right);    
                }
                if(root.left!=null){
                    s1.push(root.left);
                }
            }
            
            if(!inner.isEmpty()){
                result.add(inner);
            }
        }
    return result;
    }
}
