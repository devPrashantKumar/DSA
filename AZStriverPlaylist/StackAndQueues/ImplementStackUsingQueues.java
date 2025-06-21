package AZStriverPlaylist.StackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingQueues {

    Deque<Integer> deque;

    public ImplementStackUsingQueues() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.offerLast(x);
        int n = deque.size();
        while (--n > 0) {
            Integer temp = deque.pollFirst();
            deque.offerLast(temp);
        }
    }

    public int pop() {
        if (deque.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return deque.pollFirst();
    }

    public int top() {
        if (deque.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return deque.peekFirst();
    }

    public boolean empty() {
        return deque.isEmpty();
    }

    public void printStack() {
        int n = deque.size();
        while (n-- > 0) {
            Integer temp = deque.pollFirst();
            System.out.print(temp + " ");
            deque.offerLast(temp);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues implementStackUsingQueues = new ImplementStackUsingQueues();
        implementStackUsingQueues.push(10);
        implementStackUsingQueues.printStack();

        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        implementStackUsingQueues.printStack();

        implementStackUsingQueues.push(13);
        implementStackUsingQueues.printStack();

        implementStackUsingQueues.push(14);
        implementStackUsingQueues.printStack();

        implementStackUsingQueues.push(15);
        implementStackUsingQueues.printStack();

        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        implementStackUsingQueues.printStack();

        System.out.println("Is Empty : " + implementStackUsingQueues.empty());
        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        implementStackUsingQueues.printStack();

        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        implementStackUsingQueues.printStack();

        System.out.println("Is Empty : " + implementStackUsingQueues.empty());

        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        implementStackUsingQueues.printStack();

    }
}
