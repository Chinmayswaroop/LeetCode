/* 
Problem :: 
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


Example 1:
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int [] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int [] temp : prerequisites){
            /* if vertex is u->v then temp[1] = u and temp[0] = v */
            if(adj.containsKey(temp[1])){
                adj.get(temp[1]).add(temp[0]);
            }else{
                List<Integer> node = new ArrayList<>();
                node.add(temp[0]);
                adj.put(temp[1],node);
            }
            inDegree[temp[0]]++;

        }     
        Queue<Integer> q = new LinkedList<>();
        /* add all the nodes that have indegree = 0 */
        
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        
        int count =0;
        while(!q.isEmpty()){
            int top = q.poll();
            count++;
            if(!adj.containsKey(top))
                continue;
            /* check for all its neighbours */
            List<Integer> tempL = adj.get(top);
            for(int neighbour : tempL){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    q.add(neighbour);
                }
                    
             }
        }
    return count == numCourses;
    }
}