/* 
Problem :: 
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(1)
*/

class Solution {
    public int helper(String s , int left, int right){
       
        while( left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1; 
             
    }
    
    public String longestPalindrome(String s) {
         if(s.length()==0 || s.length()==1){
            return s;
        } 
        
        int start =0;
        int end=0;
        
        for(int i=0;i<s.length();i++){
            
            int odd = helper(s,i,i);
            int even = helper(s,i,i+1);
            int length = Math.max(odd,even);
            if(length > end -start){
                start = i-((length-1)/2);
                end = i+(length)/2;
            }
            
        }
    return s.substring(start,end+1);
  }
}

