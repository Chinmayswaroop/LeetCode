/* 
Problem :: Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/

/*
Analysis ::
Time Complexity :: O(M+N)  Think if we ran them individually the as in series so O(m) + O(n) 
Space Complexity :: O(1)
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
      int i=S.length()-1;
      int j = T.length()-1;
      
      int countS=0;
      int countT=0;
      while(i >=0 || j >=0){
            
        while(i>=0 && (S.charAt(i)=='#' || countS > 0)){
          if(S.charAt(i)=='#')
            countS++;
          else
            countS--;
          i--;
        }
        
         while(j>=0 && (T.charAt(j)=='#' || countT > 0)){
          if(T.charAt(j)=='#')
            countT++;
          else
            countT--;
          j--;  
        }
        
        if(i>=0 && j>=0 && S.charAt(i)!=T.charAt(j))
          return false;
        
        if((i>=0) != (j>=0))
          return false;          
          
        i--;j--;

      }
      
      return true;
      
    }
}
