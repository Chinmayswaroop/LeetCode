/* 
Problem :: A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

1) val: an integer representing Node.val
2) random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.

For better descripton of problem visit link ::  https://leetcode.com/problems/copy-list-with-random-pointer/

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]


*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n) reduce this to O(1) 
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      if (head == null) return null;

      Map<Node, Node> map = new HashMap<>();

      // loop 1. copy all the nodes
      Node node = head;
      while (node != null) {
        map.put(node, new Node(node.val));
        node = node.next;
      }

      // loop 2. assign next and random pointers
      node = head;
      while (node != null) {
        map.get(node).next = map.get(node.next);
        map.get(node).random = map.get(node.random);
        node = node.next;
      }

      return map.get(head);
        
    }
}