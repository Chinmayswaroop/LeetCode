/* 
Problem :: Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

*/

/*
Analysis ::
Assuming n*m (row*column)
Time Complexity :: O(n+logm)
Space Complexity :: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 || matrix[0].length == 0){
            return false;
        }
        
        /* search in the last column */
        int selectedRow = -1;
        int col = matrix[0].length-1; /* assuming same columns in each row*/
        /* O(n) */
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]>=target){
                selectedRow = i;
                break;
            }
        }
        // System.out.println("Check"+selectedRow);
        if(selectedRow == -1){
            return false;
        }
        
        int left=0;
        int right = col;
        
        /* O(logm) */
        while(left<=right){
            int mid = left + (right-left)/2;
            if(matrix[selectedRow][mid]==target)
                return true;
                
            if(matrix[selectedRow][mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
                
        }
        
      return false;
    }
}