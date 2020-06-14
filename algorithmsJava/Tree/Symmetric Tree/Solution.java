/* 
Problem :: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.
*/

/*
Analysis ::
Time Complexity :: O(n) :: because we traverse the entire tree once
Space Complexity :: O(n)
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        else
            return symhelper(root,root);    
    }

    public boolean symhelper(TreeNode n1, TreeNode n2){
        
        /* condition to be checked
           
           1) root nodes same
           2) left tree ka leftsubtree  = right tree ka rightsubtree
           3) left tree ka rigthsubtree = right tree ka leftsubtree
        
        */
        //base coniditon
        if(n1 == null &&  n2 == null){
            return true;
        }
        
        if(n1!=null && n2!=null && n1.val == n2.val){
            return ( symhelper(n1.left,n2.right) && 
                     symhelper(n1.right, n2.left) );
            
        }
        return false;
        
    }
}