package AZStriverPlaylist.StackAndQueues.CollectionLiberaries;
import java.util.*;

public class StackUsingArrayDequeClassInJava {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        System.out.println(deque.isEmpty());
        System.out.println(deque.peek());
        deque.push(10);
        deque.push(12);
        deque.push(15);
        System.out.println(deque);
        System.out.println(deque.peek());
        deque.pop();
        deque.pop();
        deque.pop();
        System.out.println(deque);
        deque.pop();

    }
}
