/* 
Problem :: Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/*
Analysis ::
Time Complexity :: O(n) as we are visting every node
Space Complexity :: O(w) where w is the maximum nodes at that level
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //at any point of time there are nodes of all level.
        if(root == null){
            return (new ArrayList<>());
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> result = new ArrayList<>();        
        while(!q.isEmpty()){
            List<Integer> templ = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.peek();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                templ.add(temp.val);
                q.poll();
            }
        result.add(templ);
    }
        return result;
 }
}