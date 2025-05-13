package myCollection.stack;

public class MyMonotonicStack {

    int[] monotonicArray;
    int arraySize = 5;

    int head = 0;

    public MyMonotonicStack(int arraySize) {
        this.arraySize = arraySize;
        this.monotonicArray = new int[arraySize];
    }

    public MyMonotonicStack() {
        this.monotonicArray = new int[arraySize];
    }

    public void increasing(int param) {
        if (head == 0 || param > peak()) {
            push(param);
            return;
        }

        while (head > 0 && param <= peak()) {
            pop();
        }

        push(param);
    }

    public void decreasing(int param) {
        if (head == 0 || param < peak()) {
            push(param);
            return;
        }

        while (head > 0 && param >= peak()) {
            pop();
        }

        push(param);
    }

    private void push(int param) {
        if (head == arraySize) {
            throw new IllegalArgumentException("stack is full");
        }

        monotonicArray[head++] = param;
    }

    private int pop() {
        if (head == 0) {
            throw new IllegalArgumentException("stack is empty");
        }

        return monotonicArray[--head];
    }

    public int peak() {
        if (head == 0) {
            throw new IllegalArgumentException("stack is empty");
        }

        return monotonicArray[head - 1];
    }

    public void printStack() {
        if (head == 0) {
            System.out.println("empty");
            return;
        }

        for (int i = 0; i < head; i++) {
            System.out.print(monotonicArray[i] + " ");
        }
    }

    public int nextGreatestElement() {
        if (head == 1) {
            throw new IllegalArgumentException("none");
        } else if (head == 0) {
            throw new IllegalArgumentException("empty");
        }

        return monotonicArray[head - 2];
    }
}
