/* 
Problem :: 
Given a list of daily temperatures T, return a list such that, for each day in the input, 
tells you how many days you would have to wait until a warmer temperature. If there is no 
future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output 
should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n) /* Depends upon
*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T.length==0 || T==null)
            return new int[]{0};
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[T.length];        
        for(int i=T.length-1;i>=0;i--){
            while(!stack.isEmpty() && T[stack.peek()]<=T[i])
                stack.pop();
            if(stack.isEmpty()){
                stack.push(i);
                result[i]=0;
            }else{
                result[i] =stack.peek()-i;
                stack.add(i);
            }
        }
        return result ;
        
    }
}