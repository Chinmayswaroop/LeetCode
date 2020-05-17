/* 
Problem :: 
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

/*
Analysis ::
Time Complexity :: O(n) :: n/2 comparisons
Space Complexity :: O(1)
*/

class Solution {
    public boolean isPalindrome(String s) {
        
        int left=0;int right=s.length()-1;
        while(left<right){
                    /* will move left or right till both left and right are not valid characters */ 
                    if(!isValid(s.charAt(left))) {left++;continue;}
                    if(!isValid(s.charAt(right))) {right--; continue;}
                    
                    char lChar=Character.toLowerCase(s.charAt(left++));
                    char rChar=Character.toLowerCase(s.charAt(right--));
                    
            if(lChar!=rChar){
                return false;
            }
               
        }
        return true;
    }
    
    boolean isValid(char ch){
        return ch>='0' && ch<='9' || ch>='a'&& ch<='z' || ch>='A' && ch<='Z';
    }
}


// class Solution {
//     public boolean isPalindrome(String s) {
//         s= s.replaceAll("[^a-zA-Z0-9]","");
//         s= s.toLowerCase();
//         int j=s.length()-1;
//         int i=0;
//         while(j>i){
//             if(s.charAt(i++)!=s.charAt(j--)){
//                 return false;
//             }
            
//         }
//     return true;
//     }
// }