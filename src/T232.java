import java.util.Stack;

public class T232 {
    class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(this.stack1.empty() && !this.stack2.empty()) {
                while(!this.stack2.empty()) {
                    int y = this.stack2.pop();
                    this.stack1.push(y);
                }
            }
            this.stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(this.stack2.empty() && !this.stack1.empty()) {
                while(!this.stack1.empty()) {
                    int y = this.stack1.pop();
                    this.stack2.push(y);
                }
            }
            return this.stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(this.stack2.empty() && !this.stack1.empty()) {
                while(!this.stack1.empty()) {
                    int y = this.stack1.pop();
                    this.stack2.push(y);
                }
            }
            return this.stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return this.stack1.empty() && this.stack2.empty();
        }
    }
}
