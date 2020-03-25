/* 
Problem :: 
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.


Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .

Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
*/

/*
Analysis ::
Time Complexity :: O(V+E)
Space Complexity :: O(V)
*/

/* BFS solution which takes care that graph is DAG or not */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int [] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjL = new HashMap<>();
        
        for(int [] temp : prerequisites){
            /* if vertex is u->v then temp[1] = u and temp[0] = v */
           adjL.putIfAbsent(temp[1], new ArrayList<>());
           adjL.get(temp[1]).add(temp[0]);
            inDegree[temp[0]]++;

        }     
        Queue<Integer> q = new LinkedList<>();
        /* add all the nodes that have indegree = 0 */
        
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0)
                q.add(i);
        }

        int [] order = new int[numCourses];
        int visited=0;
        
        while(!q.isEmpty()){
            int from = q.poll();
            order[visited++]=from;
            if(!adjL.containsKey(from))
                continue;
            
            /* check for all its neighbours */
            List<Integer> tempL = adjL.get(from);
            for(int neighbour : tempL){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    q.add(neighbour);
                }      
             }
        }
        return visited==numCourses ? order : new int[0] ;
    }
}

/* This is the DFS solution from Tushar roys video. Its is not suitable to be used at all the places since it works when the 
graph has no cycle */
class Solution {
    
    public void DFS(int vertex, boolean [] visited, Map<Integer, List<Integer>> adjL, List<Integer> stack){
        
        if(!adjL.containsKey(vertex)){
            stack.add(vertex);
            return; 
            /* this handles the case when the vertex has no nbhs from it */
        }
        for(int nbh : adjL.get(vertex)){
            if(!visited[nbh]){
                visited[nbh] = true;
                DFS(nbh, visited, adjL, stack);
            }
        }
        stack.add(vertex);
        
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjL = new HashMap<>();
        for(int [] temp : prerequisites){
            /* if vertex is u->v then temp[1] = u and temp[0] = v */
           adjL.putIfAbsent(temp[1], new ArrayList<>());
           adjL.get(temp[1]).add(temp[0]);
        }
        
        boolean [] visited = new boolean[numCourses];
        List<Integer> stack = new ArrayList<>();        
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                visited[i]=true;
                DFS(i, visited, adjL, stack);
            }
        }
        int [] arr = {};
        if(stack.size() == numCourses){
            Collections.reverse(stack);
            arr = stack.stream().mapToInt(i -> i).toArray();
        }
    return arr; 

    }
}