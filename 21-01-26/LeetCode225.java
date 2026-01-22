import java.util.Queue;

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

    static class MyStack {
        private final Queue<Integer> queue1;
        private final Queue<Integer> queue2;

        public MyStack() {
            queue1 = new Queue<>();
            queue2 = new Queue<>();
        }

        public void push(int x) {
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            return queue1.remove();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}