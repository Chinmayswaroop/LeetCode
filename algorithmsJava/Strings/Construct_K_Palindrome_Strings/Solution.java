/* 
Problem :: Given a string s and an integer k. You should construct k non-empty palindrome 
strings using all the characters in s.
Return True if you can use all the characters in s to construct k palindrome strings or 
False otherwise.

 

Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"

Example 2:
Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.

Example 3:
Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.

Example 4:
Input: s = "yzyzyzyzyzyzyzy", k = 2
Output: true
Explanation: Simply you can put all z's in one string and all y's in the other string. Both strings will be palindrome.

Example 5:
Input: s = "cr", k = 7
Output: false
Explanation: We don't have enough characters in s to construct 7 palindromes.

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

/*
Main intiution about this question is that only count of odd characters matter to us as we know that there can be only one character whose count is odd in an odd palindrome.

So if 'c' occurs 5 times we will 5%2 =1, we know remaining group of even c's can be adjusted anywhere.So now if we have K=3 and we have 4 odd frequency characters say
Consider example :

a a b b c c c b b a a
a d d c d d a
a c a
c
(Character :: frequency)
a::5, b::7, c::3, d::1
effectively we will see as
a::1, b::1, c::1, d::1

Since count of odd is greater than k we cannot adjust them
elsewhere whereas remaing a's b's c's appear in pair and wont affect us. So return false.
*/

class Solution {
    public boolean canConstruct(String s, int k) {
        int size = s.length();
        
        /* trivial cases */
        if(size<k)
            return false;
        
        /* count the frequency of each letter in the string */
        /* since it is given s is lower case alphabets only we do by array */
        char [] arr = new char[26];
        for(char each : s.toCharArray())
            arr[each -'a']++;
        
        /* Only we are interested in odd count of the letters as they
        are the ones that affect because tere can only be one odd character 
        in a palindrome */
        
        /* a a b b c c c b b a a*/
        /* a b a */
        
        /* even group of letters of a particular character wont matter */
        
        int oddCount=0;
        for(int frequency : arr){
            if(frequency%2==1){
                oddCount++;
            }
        }
        /* if oddcount characters are more than K(i.e the no of string we need to make)
        then since we know we can have only one odd per character than we will not be 
        able to adjust so return false */
        
        return oddCount<=k;
          
    }
}