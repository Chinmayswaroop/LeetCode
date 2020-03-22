/* 
Problem :: 
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    private boolean dfs(int row, int col, char [][] board, String word, int index){
        /* when we are going out of the matrix then return false */
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || word.charAt(index)!=board[row][col])
            return false;
       
        /* since we found the word so return true*/
       if(word.length()-1==index){
           return true;
       }   
       char temp = board[row][col];
       board[row][col] = '*';
        
      boolean found = 
      dfs(row-1,col,board,word,index+1)|| /*top*/
      dfs(row,col+1,board,word,index+1) || /*right*/
      dfs(row+1,col,board,word,index+1) || /*bottom*/
      dfs(row,col-1,board,word,index+1); /* left */
    
    /* will cause TLE as every condition will be checked here
       
       boolean top = dfs(row-1,col,board,word,index+1); 
       boolean right = dfs(row,col+1,board,word,index+1); 
       boolean bottom = dfs(row+1,col,board,word,index+1); 
       boolean left = dfs(row,col-1,board,word,index+1);
       if(top|| right || bottom || left)
           return true;
     */
        
       board[row][col] = temp;
       if(found){
           return true;
       }
        
       return false;
    }
    
    public boolean exist(char[][] board, String word) {
       for(int row=0;row<board.length;row++){
           for(int col=0; col<board[0].length;col++){
               if(word.charAt(0) == board[row][col]){
                   if(dfs(row,col,board,word,0)){
                       return true;
                   }
               }
           }
       }
    return false;
    }
}
