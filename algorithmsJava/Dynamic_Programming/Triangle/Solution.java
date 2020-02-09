/* 
Problem :: 
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.


Example 1:
			[
			     [2],
			    [3,4],
			   [6,5,7],
			  [4,1,8,3]
			]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Example 2:

			[
				[-1],
				[2,3],
				[1,-1,-3]
			]

The minimum sum path is -1, 3, -3

*/

/*
Analysis ::
Time Complexity :: O(n^2)
Space Complexity :: O(n)
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

         /* DP Solution 
            no of elements in row is equal to the row no. */
            int [] dp  = new int[triangle.size()+1];
            for(int i=triangle.size()-1;i>=0;i--){
                for(int j=0;j<=i;j++){
                    dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    
        /* not a dp solution but a getter setter approach
            for( int i=1;i<triangle.size();i++){
                for(int j=0;j<triangle.get(i).size();j++){
                    int left = triangle.get(i-1).get(Math.max(0,j-1))+ triangle.get(i).get(j);
                    int right;
                    if(j>=triangle.get(i-1).size()){
                        right = triangle.get(i-1).get(j-1) + triangle.get(i).get(j);
                    }else{
                        right = triangle.get(i-1).get(j) + triangle.get(i).get(j);
                    }

                    triangle.get(i).set(j,Math.min(left,right));
                }
            }
          int min = Integer.MAX_VALUE;  
         for(int nums: triangle.get(triangle.size()-1)){
           if(nums < min){
               min = nums;
           }  
         }
         return min;   
        }
     */
        
   
}