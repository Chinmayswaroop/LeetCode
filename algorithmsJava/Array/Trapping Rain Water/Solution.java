/* 
Problem :: Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

For better descripton of problem visit link ::  https://leetcode.com/problems/trapping-rain-water/

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public int trap(int[] height) {
        if(height.length==0 || height==null)
            return 0;
        int left =0;
        int right = height.length-1;
        
        int tempL = height[0];
        int tempR = height[right];
        int water =0;
        while(left<right){
            tempL = Math.max(tempL,height[left]);
            tempR = Math.max(tempR,height[right]);
            if(tempL >= tempR){
                water+= tempR-height[right];
                right--;
            }else{
                water+= tempL-height[left];
                left++;
            }
        }
        return water;
    }
}