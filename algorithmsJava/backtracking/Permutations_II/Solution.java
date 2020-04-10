/* 
Problem :: Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] visit)      {
     if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
     } else{
        for(int i = 0; i < nums.length; i++){ 
           if(visit[i] || i>0 && nums[i] ==nums[i-1] && !visit[i-1] ) continue; // element already exists, skip
             visit[i] = true;
             tempList.add(nums[i]);
             backtrack(list, tempList, nums, visit);
             tempList.remove(tempList.size() - 1);
             visit[i] = false;  
         }
      }
   } 
  
      public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // not necessary
        boolean [] visit = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums,visit);
        return list;  
      }
  }
  
  