package stack;

import java.util.LinkedList;
import java.util.List;

public class MinStack {
    private List<Integer> elementData;
    private List<Integer> minStack;

    public MinStack() {
        elementData = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        if (!minStack.isEmpty()) {
            minStack.addFirst(Math.min(val, minStack.getFirst()));
        } else {
            minStack.addFirst(val);
        }
        elementData.addFirst(val);
    }

    public void pop() {
        elementData.removeFirst();
        minStack.removeFirst();
    }

    public int top() {
        return elementData.getFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }
}