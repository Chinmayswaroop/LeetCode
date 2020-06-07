/* 
Problem :: Find the kth largest element in an unsorted array. Note that it is the kth largest 
element in the sorted order, not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

/*
Analysis ::
Time Complexity :: O(NlogK)
Space Complexity :: O(K)
*/


/*
Prioirity Queue approach
Instead of using sorting which will O(NlogN) + O(1) complexity. We do a tradeoff 
with space and improve upon the time. Heapify takes log(size of queue time). We are adding 
N element and maintain the size of Queue as min as possible that i.e to k. So time is O(Nlogk)

*/
 public int findKthLargest(int[] nums, int k) {
        
        /* Trade off for better time(N*lok) for space */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer each : nums){  //foreach works on array also
            pq.add(each);
            if(pq.size() > k)
                pq.poll(); //here we are maintaining minimum height required to get the ans     
            }
        return pq.poll();
    }
/* Working of how Heap actually works */

class Solution {
    
        public void max_heapify(int [] nums, int index, int size){   
         /*soln 2 is array implementation
        1) build heap O(n)
        2) call heapfiy k time(extract max)
        O(n+klogn)
        */
        int l=2*index+1;
        int r=2*index+2;
        int max = index;
        if(l< size && nums[l]>nums[index]){
            max=l;
        }
        if(r<size && nums[r]>nums[max]){
            max=r;
        }
        
        if(max!=index){
            int temp = nums[index];
            nums[index] = nums[max];
            nums[max] = temp;
            max_heapify(nums,max,size);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
    int size = nums.length;
       
     //build heap   
    for(int i=(int)Math.floor((size/2)-1); i>=0 ;i--){
        max_heapify(nums,i,size);
    }
    
        for (int element: nums) {
            System.out.println(element);
        }
    int kLargest=0;
    //got max heap till here
    for(int j=0;j<k;j++){
        kLargest = nums[0];
        nums[0]=nums[size-1];
        size--; //this decreases the size of the array
        max_heapify(nums,0,size);
    }
    return kLargest;
        
    }
