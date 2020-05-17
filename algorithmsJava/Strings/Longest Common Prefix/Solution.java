/* 
Problem :: 
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/

/*
Analysis ::
If the input is very very long then we can go for TRIE solution
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        
        Arrays.sort(strs);
        
/* sorting ensures that we dont have to care about the array out of bound exception because  the one with smallest length will be at the start of the array*/
        int pos = 0;
        while(pos < strs[0].length()){
            for(int i = 1; i < strs.length; i++) {
                if(strs[0].charAt(pos) != strs[i].charAt(pos)){
                    return strs[0].substring(0, pos);
                }  
            }   
            pos++;
        }
        return strs[0].substring(0, pos);
    }
}    