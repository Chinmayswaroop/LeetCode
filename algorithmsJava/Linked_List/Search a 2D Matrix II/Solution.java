/* 
Problem :: 
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0 || matrix==null)
            return false;
        int col= matrix[0].length-1;
        for(int i=0;i<matrix.length;i++){
            if(target<=matrix[i][col]){
                int left=0;
                int right = matrix[0].length;
                while(left<right){
                    int mid = left+(right-left)/2;
                    if(target == matrix[i][mid])
                        return true;
                    else if(target>matrix[i][mid])
                        left=mid+1;
                    else
                        right=mid;
                }
            }
        }
     return false;
    }
}

