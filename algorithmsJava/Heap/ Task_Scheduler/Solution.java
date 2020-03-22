/* 
Problem :: Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. 
For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Constraints:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
Accepted


*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

/*
If you are reading this I would first personally suggest you to go through below points to understand the solution better. Understanding below points would make you code/understand by yourself.

The tasks with the currently maximum frequency will contribute to a large number of idle cycles in the future, if not executed with appropriate interleavings with the other tasks. Thus, we need to re-execute such a task as soon as its cooling time is finished.
The Characters hold no importance in our question only frequency does.
So that is why we do sorting or make a Heap of frequencies.
Run the loop n+1(cooling period +1) times as it is inclusive.
Consider a case 10A, 2B, 2C. Now there will be a time when only A will remain so beacuse of cooling time we will need to wait n+1 time for each A. However when last A remains we need not wait n+1 times and exit as soon as we add time cycle for that A itself.
I personally prefer Priority Queue approach understanding that will make you understand array implementaion quickly.
*/

Heap implmentation

class Solution {
    public int leastInterval(char[] tasks, int n) {
        /* create a Map of the fequency of each task */
        Map<Character,Integer> store = new HashMap<>();
        for(char ch : tasks)
            store.put(ch,store.getOrDefault(ch,0)+1);
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((obj1,obj2)->(obj2-obj1));
        heap.addAll(store.values());
        
        int cycles=0;
        while(!heap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<n+1;i++){
                if(!heap.isEmpty())
                    temp.add(heap.remove());
            }
            
            for(int each : temp){
                if(each-1>0)
                    heap.add(--each);
            }
            
            cycles += heap.isEmpty() ? temp.size() : n+1;
        }
    return cycles;
    }
}
Array Implementation

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        
        while (map[25] > 0) { /* compare this with heap being empty */
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) /* if heap empty we are done  so say if only A is left as 3 and at last A we donot need to wait for again n times as we are not left with anymore A so we need to return time and avoid incrementing it.*/
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}