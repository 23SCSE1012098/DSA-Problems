// import java.util.*;
// class MyQueue {
//     Stack<Integer> s1=new Stack<>();
//     Stack<Integer> s2=new Stack<>();

//     public MyQueue() {
        
        
//     }
    
//     public void push(int x) {
//         s1.push(x);
        
//     }
    
//     public int pop() {
//         if (isEmpty()) {
//             System.out.println("Queue is empty!");
//             return -1;
//         }
//         if (s2.isEmpty()) {
//             while (!s1.isEmpty()) {
//                 s2.push(s1.pop());
//             }
//         }
//         return s2.pop();
//     }
    
//     public int peek() {
//         if (isEmpty()) {
//             System.out.println("Queue is empty!");
//             return -1;
//         }
//         if (s2.isEmpty()) {
//             while (!s1.isEmpty()) {
//                 s2.push(s1.pop());
//             }
//         }

//         return s2.peek();
        
//     }
    
//     public boolean empty() {
//         return s1.isEmpty() && s2.isEmpty();
        
//     }
// }
import java.util.Stack;

class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }
    
    // Removes the element from in front of queue and returns it.
    public int pop() {
        peek(); // Ensure 'out' stack has the current front
        return out.pop();
    }
    
    // Get the front element.
    public int peek() {
        if (out.isEmpty()) {
            // Move everything from 'in' to 'out' to reverse order
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    // Returns whether the queue is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */