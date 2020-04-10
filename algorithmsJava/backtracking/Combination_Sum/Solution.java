/* 
Problem :: Given a set of candidate numbers (candidates) (without duplicates) and a 
target number (target), find all unique combinations in candidates where the candidate numbers 
sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
] 

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    private void helper(int [] candidates, List<List<Integer>> result,List<Integer> tempList,int pos, int sumLeft){
        /* base condition here */
        if(sumLeft==0){
          result.add(new ArrayList<Integer>(tempList));
          return;
        }
        for(int i=pos;i<candidates.length;i++){
          if(sumLeft-candidates[i]<0)
            continue;
          
          tempList.add(candidates[i]);
          helper(candidates,result, tempList, i, sumLeft-candidates[i]);
          tempList.remove(tempList.size()-1);
        }
      }
  
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      if(candidates.length==0 || candidates==null){
        return result;
      }
      helper(candidates, result, new ArrayList<Integer>(),0,target);
      return result;
    }
}