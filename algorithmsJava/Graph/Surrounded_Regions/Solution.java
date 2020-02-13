/* 
Problem :: 
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: 
      X X X X
      X O O X
      X X O X
      X O X X

Output: 
      X X X X
      X X X X
      X X X X
      X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the 
border of the board are not flipped to 'X'. Any 'O' that is not on the border and 
it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected 
if they are adjacent cells connected horizontally or vertically.
*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(1)
*/


class Solution {
    
    public void dfs(int row, int col, char[][] board){
        /* if the base condition fail like row or columns becomes out of bound */
        if( row<0 || col<0 || row>=board.length || col>=board[0].length )
            return;
        if(board[row][col]=='X' || board[row][col]=='*') return;
        if(board[row][col]=='O') board[row][col]='*';
        
       
        dfs(row-1,col,board);
        dfs(row+1,col,board);
        dfs(row,col-1,board);
        dfs(row,col+1,board);
        
    }
    public void solve(char[][] board) {
      if(board.length!=0){
         int r = board.length;
         int c = board[0].length;
        
       for(int row=0;row<r;row++){
           /* row variable so column constant */
           if(board[row][0]=='O') dfs(row,0,board);
           if(board[row][c-1]=='O') dfs(row,c-1,board);
       }
      
       for(int col=0;col<c;col++){
           /* col variable so row constant */
          if(board[0][col]=='O') dfs(0,col,board);
          if(board[r-1][col]=='O') dfs(r-1,col,board);
        }
        
       for(int row=0;row<r;row++){
          for(int col=0;col<c;col++){
              if(board[row][col]=='O') board[row][col]='X';
              else if(board[row][col]=='*') board[row][col]='O';
          }
       }       
    }   
  }       
}