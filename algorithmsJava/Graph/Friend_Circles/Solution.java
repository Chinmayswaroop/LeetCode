/* 
Problem :: 
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input: 
    [[1,1,0],
    [1,1,0],
    [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.

Example 2:
Input: 
    [[1,1,0],
    [1,1,1],
    [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

//Union Find Approach to the problem

class Solution {
    
    public int find(int vertex, int [] sets){
        if(sets[vertex]==vertex){
            return vertex;
        }
        return find(sets[vertex],sets);
    }
    
    public int findCircleNum(int[][] M) {
        int m = M.length;
        if(m==0){
            return 0;
        }
        int [] sets = new int[m];
        
/* everybody is a friend of themselves i.e form a set of there own */        
        for(int i=0;i<m;i++)
             sets[i]=i;
        
        int count =m;
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                /* u(i)--->v(j) */
                if(M[i][j]==1){
                    int findU = find(i,sets);
                    int findV = find(j,sets);
                
                    if(findU != findV){
                        /* that is both element belong to different set */
                        sets[findV]=findU;
                        count-- ;
                    }   
                }
            }
        }
        return count;      
    }
 }

//DFS Solution

public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
/* passing i so that while doing DFS we iterate over that row( which contains node/friends connected to */
                count++;
            }
        }
        return count;
    }
}