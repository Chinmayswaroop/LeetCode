/* 
Problem :: 
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group. 
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/


/* DFS solution for finding out if a graph is bipartite or not */
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
         
        Map<Integer,List<Integer>> adjL = new HashMap<>();
        boolean [] visited = new boolean[N+1];           
        boolean [] color = new boolean[N+1];           

        /* populating adjacency list */
        for(int [] pair : dislikes){
            adjL.putIfAbsent(pair[0],new ArrayList<>());
            adjL.putIfAbsent(pair[1],new ArrayList<>());
            adjL.get(pair[0]).add(pair[1]);
            adjL.get(pair[1]).add(pair[0]);           
        }
        
        
        for(int j=1;j<=N;j++){
            if(!visited[j]){
                color[j] = true;
                visited[j] = true;
                if(isGraphBipartiteDFS(visited, color, adjL, j) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isGraphBipartiteDFS(boolean[] visited, boolean []                        color,Map<Integer,List<Integer>> adjL , int v){
     
     if(!adjL.containsKey(v)){
         return true;
     }
        
     for(int nbh : adjL.get(v)){
         
         if(visited[nbh]){
             /*check it doesnot have color same to parent */
             if(color[nbh]==color[v])
                return false;
         }else{
             /* visiting for the first time */
             color[nbh]=!color[v];
             visited[nbh]=true;
             if(isGraphBipartiteDFS(visited, color, adjL,nbh) == false)
                return false;
            }
            
      }
    return true;
     
    }
    
    
}