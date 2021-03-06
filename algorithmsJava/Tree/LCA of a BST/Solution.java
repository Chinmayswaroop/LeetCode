/* 
Problem :: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]


 

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

For better descripton of problem visit link ::  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

*/

/*
Analysis ::
Time Complexity :: O(n) in the worst case as in case of BST-skewed we will visit every node
Space Complexity :: O(n) implicit stack
*/

//Time :: 3ms , Better than 100% submissions

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val == p.val || root.val ==q.val || (root.val > Math.min(p.val,q.val)) && (root.val < Math.max(p.val,q.val)) ){
            return root;
        }else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return lowestCommonAncestor(root.left,p,q);
        }
            
    }
}

//Time :: 4ms , Better than 70.57% submissions

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null){
            return null;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p,q);
        }else if(root.val <p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p,q);
        }
        
        return root;
    }
}