/* 
Problem :: 
Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every 
edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  
Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, 
and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.

*/

/*
Analysis ::
Time Complexity :: O(V+E)
Space Complexity :: O(V) where V is the vertices of graph
*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        boolean [] visited = new boolean[graph.length];
        int [] level = new int[graph.length];
        
/* this is done because graph can have many components i.e disconnected components */
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(!check(i, graph, visited, level)){
                    return false;
                }
            }
                
        }
        return true;
    }
    
    public boolean check(int v, int [][] graph , boolean [] visited, int [] level){
       
        Queue<Integer> q = new LinkedList<>();
        q.add(v); 
        level[v]=0;
        visited[v]=true;
    
        while(!q.isEmpty()){
            int top = q.poll(); 
            /* node that is polled out will now be explored i.e we check all its nbs */
            
            /* explore all the nbh */
            for(int nbh : graph[top]){
                if(visited[nbh]){
                /* if nbh is already visited */
                    if(level[top]==level[nbh])
                        return false;
                }else{
                    visited[nbh] = true;
                    level[nbh] = level[top]+1;
                    q.add(nbh);
                }
            }
        }
    return true;
    }
}



/* BFS but this can be adjacency list creation can be avoided */
class Solution {
    public boolean isBipartite(int[][] graph) {
        
        Map<Integer,List<Integer>> adjL = new HashMap<>();
        
        /* populating adjacency list */
        for(int i=0;i<graph.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(Integer edges : graph[i]){
                temp.add(edges);
            }
            adjL.put(i,temp);
        }
        
        boolean [] visited = new boolean[graph.length];
        int [] level = new int[graph.length];
        
        /* this is done because graph can have many components i.e disconnected components */
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(!check(i,adjL, visited, level)){
                    return false;
                }
            }
                
        }
        return true;
    }
    
    public boolean check(int v,Map<Integer,List<Integer>> adjL , boolean [] visited, int [] level){
       
    Queue<Integer> q = new LinkedList<>();
        q.add(v); 
        level[v]=0;
        visited[v]=true;
    
        while(!q.isEmpty()){
            int top = q.poll(); 
            /* node that is polled out will now be explored i.e               we check all its nbs */
            
            /* explore all the nbh */
            for(Integer nbh : adjL.get(top)){
                if(visited[nbh]){
                /* if nbh is already visited */
                    if(level[top]==level[nbh])
                        return false;
                }else{
                    visited[nbh] = true;
                    level[nbh] = level[top]+1;
                    q.add(nbh);
                }
            }
        }
    return true;
    }
}

