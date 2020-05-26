/* 
Problem :: 
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public int titleToNumber(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
       if(s.length()==1)
           return s.charAt(0)-'A'+1;
        
        int result=0;
        int power=0;
        for(int i=s.length()-1;i>=0;i--){
            result+=(s.charAt(i)-'A'+1)*((int)Math.pow(26,power++));
            
        }
        
        return result;
    }
}
