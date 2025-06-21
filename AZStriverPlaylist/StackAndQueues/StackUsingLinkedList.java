package AZStriverPlaylist.StackAndQueues;

public class StackUsingLinkedList {
    class StackNode {
        int value;
        StackNode next;

        public StackNode(int value) {
            this.value = value;
        }

        public StackNode(int value, StackNode next) {
            this.value = value;
            this.next = next;
        }
    }

    StackNode head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int value) {
        head = new StackNode(value, head);
    }

    public int pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        StackNode popedStackNode = head;
        head = head.next;
        return popedStackNode.value;
    }

    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return head.value;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        StackNode current = head;
        sb.append("[");
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        System.out.println("Stack is Empty : "+stackUsingLinkedList.isEmpty());
        stackUsingLinkedList.push(0);
        stackUsingLinkedList.push(1);
        stackUsingLinkedList.push(2);

        System.out.println("Element Peeked : "+stackUsingLinkedList.peek());
        System.out.println("Element Poped : "+stackUsingLinkedList.pop());
        System.out.println("Element Peeked : "+stackUsingLinkedList.peek());
        System.out.println("Element Poped : "+stackUsingLinkedList.pop());
        System.out.println("Element Peeked : "+stackUsingLinkedList.peek());
        System.out.println("Element Poped : "+stackUsingLinkedList.pop());

        try {
            System.out.println("Element Poped : "+stackUsingLinkedList.pop());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("Element Peeked : "+stackUsingLinkedList.peek()); 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
