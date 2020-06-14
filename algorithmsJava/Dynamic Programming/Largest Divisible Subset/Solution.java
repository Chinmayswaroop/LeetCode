/* 
Problem :: 
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(n)
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length==0)
            return result;
        /* O(nlogn) step */
        Arrays.sort(nums);
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1); /* since every number is divisble by itself */
        int max=1;
        /* this is classic dp logic like longest increasing sequence question and O(n^2) */
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]%nums[i]==0){
                    dp[j]=Math.max(dp[i]+1,dp[j]);
                    max = Math.max(max,dp[j]);
                }
            }
        }
        int prev=-1;
        /* O(n) step */
        for(int i=dp.length-1;i>=0;i--){
            if(dp[i]==max && (prev%nums[i]==0 || prev==-1)){
                result.add(nums[i]);
                prev=nums[i];
                max--;
            }
        }
      return result;
      /* Time complexity is O(nlogn + n^2 + n) i.e O(n^2) */
    }
}