/* 
Problem :: 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach 
the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.



For better descripton of problem visit link ::  https://leetcode.com/problems/unique-paths-ii/

Example 1:
Input:
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(n^2)/O(n) - Both solutions present 	
*/


/* Space complexity :: O(n) Solution */
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
    for (int[] row : obstacleGrid) {
        for (int j = 0; j < width; j++) {
            if (row[j] == 1)
                dp[j] = 0;
            else if (j > 0)
                dp[j] += dp[j - 1];
        }
    }
    return dp[width - 1];
}

/* Space complexity :: O(n^2) Solution */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       
        int [][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        
        boolean check =true;
        for(int i=0;i<obstacleGrid[0].length;i++){
            if(obstacleGrid[0][i]==0 && check){
                dp[0][i]=1;
            }else{
                check=false;
                dp[0][i]=0;
            }
        }
        check =true;
        for(int i=0;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==0 && check){
                dp[i][0]=1;
            }else{
                check=false;
                dp[i][0]=0;
            }
        }
        
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
    return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
        
    }
}