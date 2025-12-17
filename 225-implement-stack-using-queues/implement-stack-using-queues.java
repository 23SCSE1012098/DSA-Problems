// class MyStack {

//     public MyStack() {
        
//     }
    
//     public void push(int x) {
        
//     }
    
//     public int pop() {
        
//     }
    
//     public int top() {
        
//     }
    
//     public boolean empty() {
        
//     }
// }
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        
        // Rotate the queue so the new element is at the front
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }
    
    // Removes the element on top of the stack and returns that element.
    public int pop() {
        return queue.remove();
    }
    
    // Get the top element.
    public int top() {
        return queue.peek();
    }
    
    // Returns whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */