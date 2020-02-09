/* 
Problem :: 
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of 
all the elements of nums except nums[i].

Note: Please solve it without division and in O(n).


Example 1:
Input:  [1,2,3,4]
Output: [24,12,8,6]

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int [] result = new int[size];
        
        result[size-1]=1;
        int prev=nums[size-1];
        for(int j=size-2;j>=0;j--){
            result[j]= result[j+1]*prev;
            prev=nums[j];
        }

        prev=1;
        for(int j=1;j<size;j++){
            int temp = prev*nums[j-1];
            result[j] = result[j]*temp;
            prev = temp;
        }
        
     
        return result;
        
        
    }
}