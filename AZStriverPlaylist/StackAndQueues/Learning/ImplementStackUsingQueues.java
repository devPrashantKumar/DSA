package AZStriverPlaylist.StackAndQueues.Learning;

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

    // printing in wrong order here
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
        System.out.println("Top Element : " + implementStackUsingQueues.top());

        implementStackUsingQueues.printStack();

        implementStackUsingQueues.push(15);
        implementStackUsingQueues.printStack();

        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        implementStackUsingQueues.printStack();

        System.out.println("Is Empty : " + implementStackUsingQueues.empty());
        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        System.out.println("Top Element : " + implementStackUsingQueues.top());

        implementStackUsingQueues.printStack();

        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        implementStackUsingQueues.printStack();

        System.out.println("Is Empty : " + implementStackUsingQueues.empty());

        System.out.println("Popped Element : " + implementStackUsingQueues.pop());
        implementStackUsingQueues.printStack();

    }
}
