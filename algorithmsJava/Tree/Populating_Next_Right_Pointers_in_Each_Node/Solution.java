/* 
Problem :: 
You are given a perfect binary tree where all leaves are on the same level, and every parent has two 
children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
 
For better description visit link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null){
            return null;
        }
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            while(size>0){
                Node top = q.poll();
                if(size-1!=0){
                    top.next = q.peek();
                }
                if(top.left!=null && top.right!=null){
                    q.add(top.left);
                    q.add(top.right);
                }
                size--;
            }
        }
        return root;
    }
}