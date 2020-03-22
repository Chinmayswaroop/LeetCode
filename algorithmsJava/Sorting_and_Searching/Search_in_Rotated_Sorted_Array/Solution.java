/* 
Problem :: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*/

/*
Analysis ::
Time Complexity :: O(logn)
Space Complexity :: O(1)
*/

class Solution {
   
    private int normalBS(int [] nums, int left, int right,int target){
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    
    private int modifiedBS(int [] nums){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid= left+(right-left)/2;
            if(nums[mid]>nums[right])
                left=mid+1;
            else
                right=mid;
        }
        return left;
    
    }
    
    public int search(int[] nums, int target) {
       if(nums.length==0){
           return -1;
       }
        
       int pivot = modifiedBS(nums);
       // System.out.println("Check"+pivot);
       int result=0;
       if(nums[pivot] <= target && target <= nums[nums.length-1]){
           result = normalBS(nums, pivot, nums.length-1, target);
       }else{
           result = normalBS(nums,0,pivot-1,target);
       }
        return result;   
    }
}