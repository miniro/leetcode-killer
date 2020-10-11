import java.util.Stack;

class T155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public T155() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        if(this.stack.empty()) {
            this.minStack.push(x);
        } else {
            if(this.minStack.peek() >= x) {
                this.minStack.push(x);
            } else {
                this.minStack.push(this.minStack.peek());
            }
        }
        this.stack.push(x);
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        this.minStack.pop();
        return this.stack.pop();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}