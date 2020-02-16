/* 
Problem :: 
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(n)
*/

/* Important TestCase 
	[1,2,4,3,5,4,7,2]  
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        
        int [] dpL = new int[nums.length];
        Arrays.fill(dpL,1);
        int [] dpC = new int[nums.length];
        Arrays.fill(dpC,1);

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dpL[j] >= dpL[i]){
                        dpL[i] = dpL[j]+1;
                        dpC[i] = dpC[j];
                    }else if(dpL[j]+1==dpL[i]){
                        dpC[i]+=dpC[j];
                    }
                    
                }
                
            }
        }
       
        int max =0;
        int result =0;
        for(int each : dpL){
            if(each>max) 
                max=each;
         }
        
        for(int i=0;i<dpL.length;i++){
            if(dpL[i] ==max){
                result +=dpC[i];
            }
        }
    return result;
       
    }
    
}