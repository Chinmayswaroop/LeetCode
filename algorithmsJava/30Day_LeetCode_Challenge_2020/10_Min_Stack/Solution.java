/* 
Problem :: 

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

*/

/*
Analysis ::
Time Complexity :: O(1)
Space Complexity :: O(n)
*/

class MinStack {
    Stack<Node> stack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
    }
    class Node{
        int val;
        int min;
        Node(int val, int min){
            this.val=val;
            this.min=min;
        }
    }
    
    
    public void push(int x) {
        Node entry;
        if(stack.empty()){
            entry = new Node(x,x);
        }else{
            Node top = stack.peek();
            int min = top.min < x ? top.min : x;
            entry = new Node(x,min);
        }
        stack.push(entry);
    }
    
    public void pop() {
        if(!stack.empty())
            stack.pop();
    }
    
    public int top() {
        if(!stack.empty())
            return stack.peek().val;
        return -1;
    }
    
    public int getMin() {
        if(!stack.empty())
            return stack.peek().min;
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

