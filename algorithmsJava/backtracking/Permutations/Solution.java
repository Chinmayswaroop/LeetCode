/* 
Problem :: 

Given a collection of distinct integers, return all possible permutations.

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
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
            return;
         }else{
            for(int i = 0; i < nums.length; i++){ 
               if(visit[i]) continue; // element already exists, skip
                 visit[i] = true;
                 tempList.add(nums[i]);
                 backtrack(list, tempList, nums, visit);
                 tempList.remove(tempList.size() - 1);
                 visit[i] = false;  
             }
          }
 }
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();
      Arrays.sort(nums); // not necessary
      boolean [] visit = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums,visit);
      return list;  
    }
}

/* or by using contains method of the list so no need of the boolean array.*/
// class Solution {
//     private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
//          if(tempList.size() == nums.length){
//             list.add(new ArrayList<>(tempList));
//             // return;
//          }else{
//             for(int i = 0; i < nums.length; i++){ 
//                if(tempList.contains(nums[i])) continue; // element already exists, skip
//                  tempList.add(nums[i]);
//                  backtrack(list, tempList, nums);
//                  tempList.remove(tempList.size() - 1);
//              }
//           }
//  }
//     public List<List<Integer>> permute(int[] nums) {
//       List<List<Integer>> list = new ArrayList<>();
//       Arrays.sort(nums); // not necessary
//         backtrack(list, new ArrayList<>(), nums);
//       return list;  
//     }
// }

