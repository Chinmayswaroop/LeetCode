/* 
Problem :: Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:
Input: nums = 
    [
    [9,9,4],
    [6,6,8],
    [2,1,1]
    ] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:
Input: nums = 
    [
    [3,4,5],
    [3,2,6],
    [2,2,1]
    ] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

*/

/*
Analysis ::
Time Complexity :: O(n^2)
    Time complexity : . Each vertex/cell will be calculated once and only once, 
    and each edge will be visited once and only once. The total time complexity is then . is the total number of vertices and is the total number of edges. In our problem,
Space Complexity :: O(n^2)
*/


/*
So for those who are solving this problem without solving:

Number of Islands
Word Search
Consider solving them as they will tell you how to move in a matrix in all directions(This is the major part of the problem) If we figure this then you are almost through such movement realted problems.
Approach For this Problem ::
Comments in my code explain code the approach is mentioned in the below points.

We need to move in all direction so how do we avoid moving when we are at first row/col and last row/col
Think over it.
How can we mask. ( As we move in all direction so we donot want to come back to parent from which we moved towards neighbour so we need masking this is particularly necessary in Number of Islands and Word Search problems.
Also think about how if we have found max length from one index what if it falls in path while travesing a different element in the same matrix
Code is below.
P.S also the best submission in this problem doesnot use a good coding practice while traversing in all directions(direction array).

Time Complexity :: O(n^2)
Each vertex/cell will be calculated once and only once, and each edge will be visited once and only once. The total time complexity is then is the total number of vertices and is the total number of edges in our problem. Since we use a cache matrix we keep storing max length of each element. So when in the main function we come to that element we return length directly from the cache.
Space Complexity :: O(n^2)
*/

class Solution {
    
    /* order wise :: bottom, top, right, left */
    /* this is a good coding practice*/
    public final int [][] directions = { {-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
               
        /* no need of matrix[0].length because if no row then no column also */         
        if(matrix.length ==0 )
            return 0;
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] cache = new int[row][col];
        
        /* traversing through all the elements */
        for(int i=0; i<row; i++){
            for(int j=0;j<col; j++){
                int temp = dfs(matrix, cache, i, j);
                max = Math.max(temp,max);
            }
        }
        return max;
    }
    
    
    
    private int dfs(int [][] matrix, int [][] cache, int row, int col){
        
        /* if we have pre-calculated that matrix element already then return from cache */
        if(cache[row][col]!=0)
            return cache[row][col];

        /* by default max will we one as we count that element/index in matrix*/
        int max = 1;
        for(int [] direction : directions){
            
            int dx = row + direction[0];
            int dy = col + direction[1];
            /* condition for the which we donot traverse neighbours */
            if(dx<0 || dx >= matrix.length || dy<0 || dy>= matrix[0].length || matrix[dx][dy]<= matrix[row][col] )
                continue;
            int length = 1+dfs(matrix, cache, dx, dy);
            max = Math.max(max,length);
        }
        cache[row][col] = max;
        return max;
        }
}