/* 
Problem :: 
here are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is 
the time it takes for a signal to travel from source to target.
Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

For better descripton of problem visit link ::  https://leetcode.com/problems/network-delay-time/ 

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.

*/

/*
Analysis ::
Time Complexity :: O(ElogE) 
Space Complexity :: O(E+V)
*/

/*
Reason to why we need distance and visited array
Explanation :: The need of distance and visited array is that it reduces the number of elements in the Heap. As we know that heap doesnt
have a reduce key operation so if we face a case that we have distance say 10 to V(consider a vertex) we insert this in heap, we later encounter that we have another distance to V with 15 we need not insert this so that is why distance array is needed also if we see a edge with less weight to V say 5 we need to add that to heap and as we know Min Heap will automatically maintain min distance at top.

and if a vertex is visited obviously we have found the shortest way to reach it so we need not consider again. Again this will save us some time
*/

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        /* we will ignore 0th index and index will be assigned on basis of vertex no */
        List<List<int[]>> graph = new ArrayList<>(N + 1);
                
        /* array to keep track of min distance */
        int [] calculatedDistance = new int[N+1];
        Arrays.fill(calculatedDistance,Integer.MAX_VALUE);
        
        Set<Integer> visited = new HashSet<>();
  
        for(int i =0; i <= N; i++)
            graph.add(new ArrayList<>());
            
         
        for(int[] time : times) /* index time[0] is vertex time[1] is weight */
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int [] a, int [] b)->(a[1] - b[1]));
        pq.add(new int[]{K, 0});

        int dist = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            /* if that vertex is visited continue no need to update distance because once   visited that vertex has already the shortest distance required to reach it */
            if(!visited.add(curr[0])) continue; 
            
            dist = curr[1];
            
            for(int[] neighbor : graph.get(curr[0])) {
            /* exploring all the neighbours and adding only those whose distance after relaxation is less than there present distance to be reached and are not visited */
                if(!visited.contains(neighbor[0]) && (dist +  neighbor[1] < calculatedDistance[neighbor[0]]) ) 
                    pq.offer(new int[]{neighbor[0], neighbor[1] + curr[1]});
            }
        }
        
        return visited.size() == N ? dist : -1;
    }
}