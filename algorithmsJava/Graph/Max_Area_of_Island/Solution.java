/* 
Problem :: 
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 
4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
Input: 
	[[0,0,1,0,0,0,0,1,0,0,0,0,0],
	 [0,0,0,0,0,0,0,1,1,1,0,0,0],
	 [0,1,1,0,1,0,0,0,0,0,0,0,0],
	 [0,1,0,0,1,1,0,0,1,0,1,0,0],
	 [0,1,0,0,1,1,0,0,1,1,1,0,0],
	 [0,0,0,0,0,0,0,0,0,0,1,0,0],
	 [0,0,0,0,0,0,0,1,1,1,0,0,0],
	 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Note: "aba" is also a valid answer.

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(1)
*/

class Solution {
    public int dfs(int row, int col, int [][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] ==0){
            return 0;
        }          
        grid[row][col]=0;
        
        int temp=1;
        temp += dfs(row-1,col,grid); //up
        temp += dfs(row+1,col,grid); //down
        temp += dfs(row,col-1,grid); //left
        temp += dfs(row,col+1,grid); //right
        return temp;
        
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea =0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    int area = dfs(row,col,grid);
                    maxArea=Math.max(maxArea, area);
                }
            }
        }
        return maxArea;        
    }
}