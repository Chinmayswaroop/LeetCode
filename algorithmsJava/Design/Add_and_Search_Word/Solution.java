/* 
Problem :: Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means 
it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class WordDictionary {
    
    private final TrieNode root;
    
    private class TrieNode{
        char data;
        boolean endOfWord;
        TrieNode [] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
        
        public TrieNode(char data){
            this.data = data;
            children = new TrieNode[26];
            this.endOfWord=false;
        }
    }
    
    /* Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /* Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            TrieNode node = current.children[ch-'a'];
            if(node ==null){
                node = new TrieNode(ch);
                current.children[ch-'a'] = node;
            }
            current  = node;
        }
        current.endOfWord = true;
    }
    
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    
    public boolean search(String word) {
        TrieNode current = root;
        return regexSearch(0,current,word.toCharArray());
    }
    
    /* this is back tracking */
     private boolean regexSearch(int index, TrieNode current, char [] array){
         /* base condition for this loop */
         if(index == array.length){
             if(current.endOfWord){
                 return true;
             }
             return false;
         }
             
         if(array[index]!='.'){
             TrieNode node = current.children[array[index]-'a']; 
             return (node!=null && regexSearch(index+1,node, array));
         }else{
             for(int i=0;i<current.children.length;i++){
                 TrieNode node = current.children[i];
                 if(node!=null){
                     if(regexSearch(index+1,node,array)){
                         return true;
                     }
                 }
             }  
         }
         return false;
     }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
