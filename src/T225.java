import java.util.LinkedList;
import java.util.Queue;

public class T225 {
    class MyStack {

        private Queue<Integer> queue;
        private Queue<Integer> tmpQueue;
        /** Initialize your data structure here. */
        public MyStack() {
            this.queue = new LinkedList<>();
            this.tmpQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(this.queue.size() > 1) {
                int x = this.queue.poll();
                this.tmpQueue.offer(x);
            }
            int result = this.queue.poll();
            while(!this.tmpQueue.isEmpty()) {
                int x = this.tmpQueue.poll();
                this.queue.offer(x);
            }
            return result;
        }

        /** Get the top element. */
        public int top() {
            int result = -1;
            while(!this.queue.isEmpty()) {
                int x = this.queue.poll();
                this.tmpQueue.offer(x);
                result = x;
            }
            while(!this.tmpQueue.isEmpty()) {
                int x = this.tmpQueue.poll();
                this.queue.offer(x);
            }
            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
