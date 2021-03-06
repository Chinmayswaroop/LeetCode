/* 
Problem :: 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach 
the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(n^2)
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[n][m];
        
        for(int i=0;i<n;i++)
            dp[i][0]=1;
        
        for(int j=0;j<m;j++)
            dp[0][j]=1;
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]= dp[Math.max(0,i-1)][j] + dp[i][Math.max(0,j-1)];
            }
        }
        return dp[n-1][m-1];
    }
}