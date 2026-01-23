import java.util.Queue;
import java.util.LinkedList;

public class LeetCode225 {
    public static void main(String[] args) {
        // Implement Stack using Queues
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }

    // Implement Stack using Queues (Linked List)
    static class MyStack {
        private Queue<Integer> mainQueue;
        private Queue<Integer> helperQueue;

        public MyStack() {
            mainQueue = new LinkedList<>();
            helperQueue = new LinkedList<>();
        }

        public void push(int x) {
            mainQueue.add(x);
            while (!helperQueue.isEmpty()) {
                mainQueue.add(helperQueue.remove());
            }
            Queue<Integer> temp = mainQueue;
            mainQueue = helperQueue;
            helperQueue = temp;
        }

        public int pop() {
            return helperQueue.remove();
        }

        public int top() {
            return helperQueue.peek();
        }

        public boolean empty() {
            return helperQueue.isEmpty();
        }
    }
}