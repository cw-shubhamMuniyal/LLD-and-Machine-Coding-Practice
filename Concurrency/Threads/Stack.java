public class Stack {
    int top;
    int[] arr;
    int capacity;

    Stack(int capacity) {
        top = -1;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    synchronized void push(int value) {
        // above synchronized keyword locks complete method of function using
        // instance of this class(this)
        if (isFull()) {
            return;
        }
        top++;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        arr[top] = value;
    }

    int pop() {
        // below synchronized keyword can be implemented like done above if whole block of function
        // is wrapped within shnchronized keyword
        synchronized (this) {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int val = arr[top];
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            top--;
            return val;
        }
    }

    boolean isEmpty() {
        if (top <= 0) {
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (top >= this.capacity) {
            return true;
        }
        return false;
    }
}
