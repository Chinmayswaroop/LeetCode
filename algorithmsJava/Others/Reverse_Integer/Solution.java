/* 
Problem :: 
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed 
integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 
when the reversed integer overflows.
*/

/*
Analysis ::
Time Complexity :: O(n) where n is the length of the number.
Space Complexity :: O(n)
*/

class Solution {
    public int reverse(int x) {
    /* memorizes the formula or technique below to reverse a no */
    /* 123 to 321 */
    /* Integer.MIN_VALUE = -2^31 == -2147483648 */
    /* Intger.MAX_VALUE = 2^31-1 == 2147483647 */
    /* The basic concept here is that reversing a smaller no can lead to a bigger no which can be out of bound ex 36 reversed is 63 */
        boolean check=true;
        if(x<0){
            check=false;
            x*=-1;
        }
        long rev =0;
        while(x > 0){
            int lastDigit = x%10;
            rev = (rev*10) + lastDigit;
            x/=10;
        }
        
     if(rev > Integer.MAX_VALUE){
         return 0;
     }
     
     if(check){
        return  (int) rev;
     }else{
         return (int) (-1*rev); 
     }
        
  }
}