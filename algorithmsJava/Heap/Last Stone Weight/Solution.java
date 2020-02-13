/* 
Problem :: 
We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

*/

/*
Analysis ::
Time Complexity :: O(nlogn)
Space Complexity :: O(n)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
     for(int stone : stones){
         pq.add(stone);
     }
     while(pq.size() >= 2){
         int top1 = pq.poll();
         int top2 = pq.poll();
         int diff = Math.abs(top1-top2);

         if(top1!=top2 && diff!=0)
             pq.add(diff);
         
     }
     if(pq.size()!=0){
         return pq.poll();
     }else{
         return 0;
     }
    }
}


