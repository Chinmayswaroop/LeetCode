/* 
Problem :: Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
 together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

For better descripton of problem visit link ::  https://leetcode.com/problems/container-with-most-water/

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

/* Say start and end are two points now seeing at the graph that is presented to us. We need to think about two things.

This formula should hit you up that any area between two points should be
(b-a)Math.min(height[b],height[a]).
Now we need to think how to traverse the array. So when i see an array problem and i think about sliding window, two pointer approach first. These approaches come to you by experience, also since there are starting point and ending point two pointer will strike you easily.
P.S this problem is easy to solve if you have some experience of solving array problems.

*/
class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int area = 0;
        
        while(end > start){
            area = Math.max(area, (end-start)*Math.min(height[end],height[start]));
            if(height[start]>=height[end]){
                end--;
            }else{
                start++;
            }
        }
        return area;
        
    }
}