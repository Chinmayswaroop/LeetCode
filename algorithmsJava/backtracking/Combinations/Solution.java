/* 
Problem :: 

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    /* to return only those combinations that are infront */
      private void helper(int n, int size,int pos, List<List<Integer>> result, List<Integer>tempList){
        
          if(tempList.size()==size){
            result.add(new ArrayList<>(tempList));
            return;
          }
        for(int i=pos; i<=n;i++){
          tempList.add(i);
          helper(n,size,i+1,result,tempList);
          tempList.remove(tempList.size()-1);
        }
      }
    
      public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n,k,1,result,new ArrayList<Integer>());
        return result;
        
      }
  }