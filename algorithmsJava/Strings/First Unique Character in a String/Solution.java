/* 
Problem :: Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.


*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public int firstUniqChar(String s) {
        int result =-1;
        if(s.length()==0 || s==null)
            return result;
        int [] store = new int[26];
        for(char c : s.toCharArray())
            store[c-'a']++;
        for(int i=0;i<s.length();i++){
            if(store[s.charAt(i)-'a']==1){
                result=i;
                break;
            }
        }
        return result;
           
    }
}
