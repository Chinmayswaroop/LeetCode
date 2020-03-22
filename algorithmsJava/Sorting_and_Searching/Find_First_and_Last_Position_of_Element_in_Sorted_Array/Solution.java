/* 
Problem :: Given an array of integers nums sorted in ascending order, find the starting and ending position 
of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1] 

For better descripton of problem visit link ::  

*/

/*
Analysis ::
Time Complexity :: O(logn)
Space Complexity :: O(1)
*/

// class Solution {
    
//     private int modifiedBS(int [] nums,int target, boolean side){
        
//         int left = 0;
//         int right = nums.length;
//         while(left<right){
            
//             int mid = left + (right-left)/2;
//               if(nums[mid]>target || (side && nums[mid]==target))
//                   right = mid;                                                
//                 else
//                     left=mid+1;
//             }
//         return left;
//         }
    
    
//     public int[] searchRange(int[] nums, int target) {
//         int [] result = {-1,-1};
//         int leftIndex = modifiedBS(nums,target,true);
        
//         if(leftIndex == nums.length || nums[leftIndex]!=target){
//             return result;
//         }
        
//         result[0]=leftIndex;
//         result[1]= modifiedBS(nums,target,false)-1;
        
//         return result;
//     }
// }

class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
        result[0]= leftIndexBS(nums,target);
        result[1]= rightIndexBS(nums,target);
        return result;
    }
    
    private int leftIndexBS(int [] nums, int target){
        int left = 0;
        int right = nums.length-1;
        
        int index = -1;
        
        while(left<right){
            int mid= left + (right-left)/2;

            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
            
            if(nums[mid]==target) {index = mid;}
        }
        return index;
        
    }
    
    private int  rightIndexBS(int [] nums, int target){
        int left =0;
        int right = nums.length-1;
        int index = -1;
        
        while(left<right){
            int mid= left + (right-left)/2;

            
            if(nums[mid]<=target){
                left=mid;
            }else{
                right = mid-1;   
            }
            
            if(nums[mid]==target) {index = mid;}
            
        }
    return index;
    }
    
}







