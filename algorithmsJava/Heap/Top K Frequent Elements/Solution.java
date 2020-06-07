/* 
Problem :: 
Given a non-empty array of integers, return the k most frequent elements.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
*/

/*
Analysis ::
Time Complexity :: O(nlogk) :: as we are restricting the size of the heap.
O(Nlogk) if k < N and O(N) in the particular case of N=k. 

Space Complexity :: O(n)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> store = new HashMap<>();
       for(int each : nums)
           store.put(each, store.getOrDefault(each,0)+1);
       
        Queue<int []> heap  = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int each : store.keySet()){
            int [] temp = new int[2];
            temp[0] = each;
            temp[1] = store.get(each);
            heap.add(temp);
            if(heap.size()>k){
                heap.poll();
            }
        }
        
        int result[] = new int[k];
        int i=0;
        while(!heap.isEmpty())
            result[i++] = heap.poll()[0];
        
        return result;
      
    }
}