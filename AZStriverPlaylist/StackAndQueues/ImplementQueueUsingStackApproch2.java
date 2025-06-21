package AZStriverPlaylist.StackAndQueues;

import java.util.Stack;

public class ImplementQueueUsingStackApproch2 {

    Stack<Integer> stack;
    Stack<Integer> tempStack;

    public ImplementQueueUsingStackApproch2() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (tempStack.isEmpty()) {
            if (stack.isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
        }
        return tempStack.pop();
    }

    public int peek() {
        if (tempStack.isEmpty()) {
            if (stack.isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
        }
        return tempStack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public void printQueue() {
        Stack<Integer> tempStack2 = new Stack<>();
        while (!tempStack.isEmpty()) {
            Integer temp = tempStack.pop();
            System.out.print(temp + " ");
            tempStack2.push(temp);
        }
        while (!tempStack2.isEmpty()) {
            tempStack.push(tempStack2.pop());
        }
        while (!stack.isEmpty()) {
            tempStack2.push(stack.pop());
        }
        while (!tempStack2.isEmpty()) {
            Integer temp = tempStack2.pop();
            System.out.print(temp + " ");
            stack.push(temp);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStackApproch2 implementQueueUsingStackApproch2 = new ImplementQueueUsingStackApproch2();
        implementQueueUsingStackApproch2.push(10);
        implementQueueUsingStackApproch2.printQueue();

        System.out.println("Popped Element : " + implementQueueUsingStackApproch2.pop());
        implementQueueUsingStackApproch2.printQueue();

        implementQueueUsingStackApproch2.push(13);
        implementQueueUsingStackApproch2.printQueue();

        implementQueueUsingStackApproch2.push(14);
        System.out.println("Peeked Element : " + implementQueueUsingStackApproch2.peek());

        implementQueueUsingStackApproch2.printQueue();

        implementQueueUsingStackApproch2.push(15);
        implementQueueUsingStackApproch2.printQueue();

        System.out.println("Popped Element : " + implementQueueUsingStackApproch2.pop());
        implementQueueUsingStackApproch2.printQueue();

        System.out.println("Is Empty : " + implementQueueUsingStackApproch2.empty());
        System.out.println("Popped Element : " + implementQueueUsingStackApproch2.pop());
        System.out.println("Peeked Element : " + implementQueueUsingStackApproch2.peek());
        implementQueueUsingStackApproch2.printQueue();

        System.out.println("Popped Element : " + implementQueueUsingStackApproch2.pop());
        implementQueueUsingStackApproch2.printQueue();

        System.out.println("Is Empty : " + implementQueueUsingStackApproch2.empty());

        System.out.println("Popped Element : " + implementQueueUsingStackApproch2.pop());
        implementQueueUsingStackApproch2.printQueue();
    }
}
