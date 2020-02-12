/* 
Problem :: 
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by 
water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of 
the grid are all surrounded by water.

Example 1:
Input:
	11110
	11010
	11000
	00000
Output: 1

Example 2:
Input: 
	11000
	11000
	00100
	00011

Output: 3

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(1)
*/

class Solution {
    public void dfs(int row, int col, char [][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] =='0'){
            return;
        }          
        grid[row][col]='0';
        
        dfs(row-1,col,grid); //up
        dfs(row+1,col,grid); //down
        dfs(row,col-1,grid); //left
        dfs(row,col+1,grid); //right
    }
    
    public int numIslands(char[][] grid) {
        int islands =0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='1'){
                    islands++;
                    dfs(row,col,grid);
                }
            }
        }
    return islands;
    }
}
