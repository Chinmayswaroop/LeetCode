/* 
Problem :: Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//       List<List<Integer>> result = new ArrayList<>();
//       if(nums.length<=0 ){
//         return result;
//       }
//       /* add empty set in result */
//       result.add(new ArrayList<>());
      
//       for(int i=0;i<nums.length; i++){  
//         List<List<Integer>> temp = new ArrayList();
//         int size = result.size();
        
//         /* copy the present result deep copy is imp other if a reference is copied problems will
//         occur later */
//         for(int j=0;j<size;j++){
//             temp.add(new ArrayList<>(result.get(j)));
//           }
        
//         /* adding present index of nums to every List */
//         for(List<Integer> copy : temp){
//           copy.add(nums[i]);
//           result.add(new ArrayList<>(copy));
//         }
//       }
//       return result;
//     }        
// }


class Solution {
  private void helper(int [] nums, int pos, List<List<Integer>> result, List<Integer> subset){
    result.add(new ArrayList<>(subset));
    for(int i=pos;i<nums.length;i++){
      subset.add(nums[i]);
      helper(nums,i+1,result,subset);
      subset.remove(subset.size()-1);
    }
  }
    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> result = new ArrayList<>();
     // result.add(new ArrayList<Integer>());

      if(nums.length<=0 ){
        return result;
      }
      /* add empty set in result */
      helper(nums,0,result,new ArrayList<Integer>());
      return result;
    }
}