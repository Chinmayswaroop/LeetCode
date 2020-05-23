/* 
Problem :: On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting 
from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, 
the numbers are written as follows:

You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:

You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
(This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations, regardless of the size of the board.)
If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].

Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)

Return the least number of moves required to reach square N*N.  If it is not possible, return -1.
For better descripton of problem visit link ::  https://leetcode.com/problems/snakes-and-ladders/

Example 1:
IInput: [
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
At the beginning, you start at square 1 [at row 5, column 0].
You decide to move to square 2, and must take the ladder to square 15.
You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
You then decide to move to square 14, and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.

*/

/*
Analysis ::
N = where N is the no of the elements in the matrix that is N^2
Time Complexity :: O(N^2 + 6* N^2) == O(N^2)
Space Complexity :: O(N^2)
*/

class Qentry {
    int vertex;
    int moves;
    
    public Qentry(){
    }
    
    public Qentry(int vertex,int moves){
        this.vertex = vertex;
        this.moves=moves;
    }
}
class Solution {
    
    public int snakesAndLadders(int[][] board) {
        /* convert into 1D array first */
        int N = board.length;
        int totalSquares = N*N;
        if(N==0)
            return 0;
        
        int[] nBoard = new int[N*N + 1];
        int k = 1;
        boolean left2right = true;
        for(int i = N - 1; i >= 0; i--) { /* no of rows time */
            if (left2right) {
                for(int j = 0; j < N; j++) nBoard[k++] = board[i][j];
            }else {
                for(int j = N - 1; j >= 0; j--) nBoard[k++] = board[i][j];
            }
            left2right = !left2right;
        }
        
        int [] visited = new int[N*N +1];
        Queue<Qentry> q = new LinkedList<>();
        
        /* intially add we are out of board so v=0 moves=0 */
        Qentry entry = new Qentry(1,0);
        q.add(entry);
        
        while(!q.isEmpty()){
            
            entry = q.poll();
            int v  = entry.vertex;
            
            if(v == totalSquares) 
                break;
            
            for(int j=v+1;j<=v+6 && j<=totalSquares; j++ ){
              if(visited[j] == 0){
                Qentry temp = new Qentry();
                temp.moves = entry.moves+1;
                visited[j]=1;

                if(nBoard[j]!=-1){
                    temp.vertex = nBoard[j];
                }else{
                    temp.vertex=j;
                }
                q.add(temp);
              }
            }
            
        }
        if(entry.vertex!=totalSquares){
            return -1;
        }
    return entry.moves;
    }
}