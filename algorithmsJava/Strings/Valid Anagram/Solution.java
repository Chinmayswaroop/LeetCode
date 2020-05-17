/* 
Problem :: Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public boolean isAnagram(String s, String t) {
   
        int[] arr=new int[26];
        
        for(char i:s.toCharArray())
        {
            arr[i-'a']++;
        }
        for(char i:t.toCharArray())
            arr[i-'a']--;
        for(int i=0;i<26;i++)
        {
            if(arr[i]!=0)
                return false;
        }
        return true;
    }
}

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length())
//             return false;
        
//         Map<Character,Integer> h1 = new HashMap<>();
//         for(int i=0,j=0; i<s.length();i++,j++){
//             char a =s.charAt(i);
//             char b =t.charAt(j); 
//             h1.put(a,h1.getOrDefault(a,0)+1);
//             h2.put(b,h2.getOrDefault(b,0)+1);   
//         }
       
//         if(h1.equals(h2)){
//             return true;
//         }
//         return false;
//     }
// }