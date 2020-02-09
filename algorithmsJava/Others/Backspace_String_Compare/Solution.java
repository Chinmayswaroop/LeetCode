/* 
Problem :: 
Given two strings S and T, return if they are equal when both are typed into empty text editors. 
# means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        String newS = "";
        String newT = "";
        
        for(int i=0;i<S.length();i++){
            char temp = S.charAt(i);
            if(temp=='#'){
                if(newS.length()>0){
                    newS = newS.substring(0,newS.length()-1);    
                }
            }else{
                newS = newS+ String.valueOf(temp);
            }
            
        }
        
        for(int i=0;i<T.length();i++){
            char temp = T.charAt(i);
            if(temp =='#'){
                if(newT.length()>0){
                    newT = newT.substring(0,newT.length()-1);    
                }
            }else{
                newT = newT+ String.valueOf(temp);
            }
            
        }
      
        return newS.equals(newT) ? true : false;
    }
}

	