/* 
Problem :: 
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(n^2)
*/

class Solution {
    public int minDistance(String word1, String word2) {
        
        int row = word2.length();
        int col = word1.length();
        if(row==0 || col==0)
            return Math.max(row,col);
        
        int [][] dp = new int[row+1][col+1];
        
        /* filling row */
        for(int i=0;i<dp[0].length;i++)
            dp[0][i] = i;         
        /* filling col */
        for(int i=1;i<dp.length;i++)
            dp[i][0]= i;
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(word2.charAt(i-1)==word1.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}