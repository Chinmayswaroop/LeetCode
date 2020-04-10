/* 
Problem :: 
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> store = new HashMap<>();
        for(String each : strs){
            char [] eachArr = each.toCharArray();
            Arrays.sort(eachArr);
            String sortEach = new String(eachArr);
            store.putIfAbsent(sortEach,new ArrayList<String>());  
            store.get(sortEach).add(each);
        }       
        
        return new ArrayList<List<String>>(store.values());
            
    }

}