package AZStriverPlaylist.StackAndQueues.Learning;

import java.util.Stack;

public class ImplementQueueUsingStackApproch2 {

    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public ImplementQueueUsingStackApproch2() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if (outputStack.isEmpty()) {
            if (inputStack.isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            if (inputStack.isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty();
    }

    public void printQueue() {
        Stack<Integer> outputStack2 = new Stack<>();
        while (!outputStack.isEmpty()) {
            Integer temp = outputStack.pop();
            System.out.print(temp + " ");
            outputStack2.push(temp);
        }
        while (!outputStack2.isEmpty()) {
            outputStack.push(outputStack2.pop());
        }
        while (!inputStack.isEmpty()) {
            outputStack2.push(inputStack.pop());
        }
        while (!outputStack2.isEmpty()) {
            Integer temp = outputStack2.pop();
            System.out.print(temp + " ");
            inputStack.push(temp);
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
