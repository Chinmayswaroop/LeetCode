/* 
Problem :: 
Given an unsorted array of integers, find the length of longest increasing subsequence.


Example 1:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

*/


/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(n)
*/


class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int [] store = new int[nums.length];
        Arrays.fill(store,1);
        
        int max=1;
        for(int i=1; i<nums.length;i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                   store[i]=Math.max(store[i],store[j]+1); 
                }
            }
        }
       
        for(int num : store){
            if(num>max){
                max=num;
            }
        }
    return max;
    }
}