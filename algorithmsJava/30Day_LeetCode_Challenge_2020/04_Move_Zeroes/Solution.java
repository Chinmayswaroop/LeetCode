/* 
Problem ::Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations. 

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {
     
        int firstZero=0;
        boolean flag = true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                firstZero=i;
                flag=false;
                break;
            }
        }
        if(flag)
            return;
        
        
        int index=firstZero;
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                nums[i]=0;
                index++;
            }
        }
    }
}

/*
class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index=0;
        for(int i=0;i<length;i++){
            if(nums[i]!= 0){
                nums[index++]=nums[i];   
            }
        }
        
        while(index<length){
            nums[index]=0;
            index++;
        }
    }
}

*/