/* 
Problem :: 
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
Output: [1,2,2,3,5,6]

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(1)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index1=m-1;
        int index2=n-1;
        int i = nums1.length-1;
        
        while(index1>=0 && index2 >=0){
            int n1 = nums1[index1];
            int n2 =nums2[index2];
            if( n2>n1){
                nums1[i]=n2;
                i--;index2--;
            }else{
                nums1[i]=n1;
                i--;index1--;
            }
        }
        
        while(index1>=0){
            nums1[i]=nums1[index1];
            index1--;
            i--;
        }
        
        while(index2>=0){
            nums1[i]=nums2[index2];
            index2--;
            i--; 
        }
    }
}