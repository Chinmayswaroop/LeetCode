/* 
Problem :: 
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
Now given all the cities and flights, together with starting city src and the destination dst, 
your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

For better descripton of problem visit link ::  https://leetcode.com/problems/cheapest-flights-within-k-stops/ 

Example 1:
Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.


*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
      
        Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
        for(int [] nums : flights){
                if(!graph.containsKey(nums[0]))
                    graph.put(nums[0],new HashMap());    
                graph.get(nums[0]).put(nums[1],nums[2]);
                
        }
        
        PriorityQueue<int []> pq = new PriorityQueue<>((int [] a, int [] b) -> (a[1]-b[1]));
        /* array(dest, price, stops) */
        pq.add(new int [] {src,0,K+1});
        Set<Integer> visited = new HashSet<>();
        while(!pq.isEmpty()){
            
            
            int [] top = pq.poll();
            int city = top[0];
            int price = top[1];
            int stops = top[2];
            if(city==dst)
                return price;
            
            if(stops>0){
                /* empty Hashmap is considered because of case if a vertex is not connected to some vertex but it has no outgoing edges */
                Map<Integer,Integer> edges = graph.getOrDefault(city,new HashMap());
                for( Integer key: edges.keySet()){
                    pq.add(new int []{key,price+edges.get(key),stops-1});
                    }
                }
        }
    return -1;
    }
}

