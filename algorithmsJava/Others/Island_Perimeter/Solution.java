/* 
Problem :: 
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, 
and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

For better descripton of problem visit link ::https://leetcode.com/problems/island-perimeter/  

Example 1:
Input:
    [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
     [1,1,0,0]]
Output: 16

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(1)
*/


class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int row=0;row<grid.length ;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    perimeter+=4;

                
                    if(col>0 && grid[row][col-1]==1){
                    /* this ensures that when 1 is at the start of array, array doesnot 
                    go out of bound*/
                        perimeter-=2;

                    }
                    if(row>0 && grid[row-1][col]==1){
                        /* first cannot have an element above it */
                        perimeter-=2;

                    }
                
                }
            }
        }
        return perimeter;
    }
}