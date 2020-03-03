/* 
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

/*
Analysis ::
Time Complexity 
			- Get :: O(1), 
			- Put :: O(1)
Space Complexity :: O(Cache Capacity)
*/

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(){
        
    }
    
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    
    final int cacheCapacity;
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer,Node> nodeMap;
    
    public LRUCache(int capacity) { /* constructor */
        /* this will be called first so intialise the map */
        nodeMap = new HashMap<>();
        this.cacheCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(nodeMap.containsKey(key)){
            Node temp = nodeMap.get(key);
            removeFromCache(temp);
            addToCache(temp);
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
   
      /* if key is already present make update it's value and make it most recent */
        if(nodeMap.containsKey(key)){
            Node temp = nodeMap.get(key);
            temp.val = value;
            removeFromCache(temp);
            addToCache(temp);
        }else {
            if(nodeMap.size()==cacheCapacity) {
                nodeMap.remove(tail.prev.key);
                removeFromCache(tail.prev);
            }
            Node addNode = new Node(key,value);
            nodeMap.put(key,addNode);
            addToCache(addNode);	
        }
    }
    
    
    /* customs methods we are using Doubly linked list as it add and removes
    in constant time. Also head and tail are just dummy nodes to keep track */
    
    public void addToCache(Node mostRecent){
     /* we add new node that is most recent in front */
        Node recent = head.next;
        recent.prev = mostRecent;
        mostRecent.prev = head;
        mostRecent.next = recent;
        head.next = mostRecent;
    }
    
    public void removeFromCache(Node node){
        Node nodeBefore = node.prev;
	    Node nodeAfter = node.next;    
	    nodeBefore.next = nodeAfter;
	    nodeAfter.prev = nodeBefore;
        
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */