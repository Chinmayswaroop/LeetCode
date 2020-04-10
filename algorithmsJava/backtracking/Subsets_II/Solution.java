/* 
Problem :: 
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
  
    private void helper(int [] nums, int pos, List<List<Integer>> result, List<Integer> subset){
     result.add(new ArrayList<>(subset));
     for(int i=pos;i<nums.length;i++){
       if(i>pos && nums[i]==nums[i-1]) continue; /* removing duplicates */
         subset.add(nums[i]);
         helper(nums,i+1,result,subset);
         subset.remove(subset.size()-1);
       }
   }
     public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
      // result.add(new ArrayList<Integer>());
 
       if(nums.length<=0 ){
         return result;
       }
       Arrays.sort(nums);
       /* add empty set in result */
       helper(nums,0,result,new ArrayList<Integer>());
       return result;  
     }
 }
 
 
 
 