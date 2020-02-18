/* 
Problem :: 
Given an array of characters, compress it in-place.
The length after compression must always be smaller than or equal to the original array.
Every element of the array should be a character (not int) of length 1.
After you are done modifying the input array in-place, return the new length of the array.

Example 1:
Input:
	["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Input:
 ["a"]
Output: Return 1, and the first 1 characters of the input array should be: ["a"]

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/


/* Solution 2 better */
/* Remarks :: Important to learn how wisely the last index condition has been included in the if loop */

public int compress(char[] chars) {        
        int start = 0;
        for(int end = 0, count = 0; end < chars.length; end++) {
            count++;
            if(end == chars.length-1 || chars[end] != chars[end + 1] ) {
                //We have found a difference or we are at the end of array
                chars[start] = chars[end]; // Update the character at start pointer
                start++;
                if(count != 1) {
                    // Copy over the character count to the array
                    char[] arr = String.valueOf(count).toCharArray();
                    for(int i=0;i<arr.length;i++, start++)
                        chars[start] = arr[i];
                }
                // Reset the counter
                count = 0;
            }
        }
        return start;
    }

/* Solution 1 that can be avoided */
class Solution {
    public int compress(char[] chars) {
        int count=1;
        int mark=-1;
        int length = chars.length;
        if(length<=1){
            return length;
        }
        for(int i=1;i<length;i++){
            
            if(chars[i]!=chars[i-1]){
                if(count ==1){
                    chars[++mark]=chars[i-1];
                }else{
                    chars[++mark]=chars[i-1];
                    String counter = String.valueOf(count);
                    for(int j=0;j<counter.length();j++){
                        chars[++mark] = counter.charAt(j);
                    }
                }
                count=1;
            }else{
                count ++;
            }
        }
        if(count ==1){
            chars[++mark]=chars[length-1];
        }else{
            chars[++mark]=chars[length-1];
            String counter = String.valueOf(count);
            for(int j=0;j<counter.length();j++){
                chars[++mark] = counter.charAt(j);
            }
            
        }
        return mark+1;
    }
}