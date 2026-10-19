package AZStriverPlaylist.StackAndQueues;

import java.util.ArrayList;

public class MinStack2 {
    ArrayList<Integer> myStack;
    ArrayList<Integer> minStack;
    int top = -1;
    int minTop = -1;

    public MinStack2() {
        myStack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        if (top == -1 || minStack.get(minTop)>=val) {
            minStack.add(val);
            minTop++;
        } 
        myStack.add(val);
        top++;
    }

    public void pop() {
        if (minStack.get(minTop).equals(myStack.get(top))) {
            minStack.remove(minTop);
            minTop--;
        } 
        myStack.remove(top);
        top--;
    }

    public int top() {
        return myStack.get(top);
    }

    public int getMin() {
        return minStack.get(minTop);
    }
    public static void main(String[] args) {
        MinStack2 obj = new MinStack2();
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
