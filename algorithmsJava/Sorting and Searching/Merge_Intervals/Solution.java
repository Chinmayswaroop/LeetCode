/* 
Problem :: 
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/


class Solution {
    public int[][] merge(int[][] intervals) {
        
        /* sort the array on the basis of there 0th index values so that we have sync in merging the values in the intervals */
        
        if(intervals.length<=1 || intervals == null){
            return intervals;
        }
        
        Arrays.sort(intervals,(int [] newArr, int []  alreadyPresent)->(newArr[0] - alreadyPresent[0]));
        
        List<int []> result = new ArrayList<>();
        result.add(intervals[0]);
        int [] top = result.get(0);
        
        for(int [] interval : intervals){
            if(interval[0]<=top[1]){
                /*merge here*/
                top[1] = Math.max(top[1],interval[1]);
            }else{
                /* cannot merge with top */
                /* (1,6) (8,10) earlier top was (1,6) now we push (8.10 ) in list and top becomes (8,10) */
                top = interval;
                result.add(top);
            }
        }
        
     return result.toArray(new int [result.size()][]);
    }
} 