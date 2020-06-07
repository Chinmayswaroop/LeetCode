/* 
Problem :: 
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

/*
Analysis ::
Time Complexity :: O(n) //Since we visit every node once
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
    public int [] modifiedDFS(TreeNode root){
        if(root == null)
            return new int[2];
        
/* 0 index = that node is not robbed :: 1 index =  it is robbed */        
        int [] left = modifiedDFS(root.left);
        int [] right = modifiedDFS(root.right);
        int [] result = new int[2];
        
        /* if that node is not robbedd */
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result[1] = root.val +left[0]+right[0];
        
        return result;
    }
    public int rob(TreeNode root) {
         int [] result =  modifiedDFS(root);
         return Math.max(result[0],result[1]);
    }
}