package AZStriverPlaylist.StackAndQueues.Learning;

import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> stack;
    Stack<Integer> tempStack;

    public ImplementQueueUsingStack() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(x);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public void printQueue() {
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            System.out.print(temp + " ");
            tempStack.push(temp);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack implementQueueUsingStack = new ImplementQueueUsingStack();
        implementQueueUsingStack.push(10);
        implementQueueUsingStack.printQueue();

        System.out.println("Popped Element : " + implementQueueUsingStack.pop());
        implementQueueUsingStack.printQueue();

        implementQueueUsingStack.push(13);
        implementQueueUsingStack.printQueue();

        implementQueueUsingStack.push(14);
        System.out.println("Peeked Element : " + implementQueueUsingStack.peek());

        implementQueueUsingStack.printQueue();

        implementQueueUsingStack.push(15);
        implementQueueUsingStack.printQueue();

        System.out.println("Popped Element : " + implementQueueUsingStack.pop());
        implementQueueUsingStack.printQueue();

        System.out.println("Is Empty : " + implementQueueUsingStack.empty());
        System.out.println("Popped Element : " + implementQueueUsingStack.pop());
        System.out.println("Peeked Element : " + implementQueueUsingStack.peek());
        implementQueueUsingStack.printQueue();

        System.out.println("Popped Element : " + implementQueueUsingStack.pop());
        implementQueueUsingStack.printQueue();

        System.out.println("Is Empty : " + implementQueueUsingStack.empty());

        System.out.println("Popped Element : " + implementQueueUsingStack.pop());
        implementQueueUsingStack.printQueue();
    }
}
