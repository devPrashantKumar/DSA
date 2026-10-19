package AZStriverPlaylist.StackAndQueues;

import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> myStack;
    ArrayList<Integer> minStack;
    int top = -1;

    public MinStack() {
        myStack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        myStack.add(val);
        if (top == -1) {
            minStack.add(val);
        } else {
            minStack.add(Math.min(val, this.getMin()));
        }
        top++;
    }

    public void pop() {
        myStack.remove(top);
        minStack.remove(top);
        top--;
    }

    public int top() {
        return myStack.get(top);
    }

    public int getMin() {
        return minStack.get(top);
    }
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int param1 = obj.getMin();
        obj.pop();
        int param2 = obj.top();
        int param3 = obj.getMin();

        System.out.println("param1 : "+param1);
        System.out.println("param2 : "+param2);
        System.out.println("param3 : "+param3);
    }
}
