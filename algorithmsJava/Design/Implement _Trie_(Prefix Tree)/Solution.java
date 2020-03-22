/* 
Problem :: Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

/* with HashMap */
class Trie {
    
    private final TrieNode root;
    
    /* Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();    
    }
    
    /* nested class inside the trie class */
    private class TrieNode {
        Map<Character,TrieNode> children;
        boolean eof; /*stands for end of word */
        
        public TrieNode(){
            children = new HashMap<>();
            eof=false;
        }   
    }
    
    /* Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.eof = true;
    }
    
    /* Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
           char ch = word.charAt(i);
           TrieNode node = current.children.get(ch);
           if(node == null){
               return false;
           }
           current = node;        
        }
        return current.eof;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0;i<prefix.length();i++){
           char ch = prefix.charAt(i);
           TrieNode node = current.children.get(ch);
           if(node ==null){
               return false;
           }
           current = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


/* with Arrays */

class Trie {
	class TrieNode {
		char data;
		private boolean endOfWord;
		private TrieNode[] childrens;

		public TrieNode(char data) {
			this.data = data;
			endOfWord = false;
			childrens = new TrieNode[26];
		}

		public TrieNode() {
			childrens = new TrieNode[26];
		}
	}

	private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
    root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		if (word == null || word.isEmpty())
			return;
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (curr.childrens[index] == null) {
				curr.childrens[index] = new TrieNode(c);
			}
			// move to next pointer
			curr = curr.childrens[index];
		}
		curr.endOfWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		if (word == null || word.isEmpty())
			return false;
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (curr.childrens[index] == null) {
				return false;
			}
			curr = curr.childrens[index];
		}
		return curr.endOfWord;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.isEmpty())
			return false;
		TrieNode curr = root;
		for (char c : prefix.toCharArray()) {
			int index = c - 'a';
			if (curr.childrens[index] == null) {
				return false;
			}
			curr = curr.childrens[index];
		}
		return curr != null;

	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */