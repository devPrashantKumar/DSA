package AZStriverPlaylist.StackAndQueues;

public class QueueUsingLinkedList {
    class QueueNode{
        int value;
        QueueNode next;

        public QueueNode(int value){
            this.value = value;
        }
    }

    QueueNode head;
    QueueNode tail;

    public boolean isEmpty(){
        return head==null;
    }

    public void enqueue(int value){
        QueueNode newQueueNode = new QueueNode(value);
        if(isEmpty()){
            head = tail = newQueueNode;
        }
        else{
            tail.next = newQueueNode;
            tail = tail.next;
        } 
    }

    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        QueueNode queueNode = head;
        head = head.next;
        if(isEmpty()) tail = null;
        return queueNode.value;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return head.value;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        QueueNode current = head;
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
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        System.out.println("Queue is Empty : " + queueUsingLinkedList.isEmpty());
        queueUsingLinkedList.enqueue(0);
        System.out.println("Queue is Empty : " + queueUsingLinkedList.isEmpty());
        queueUsingLinkedList.enqueue(1);
        queueUsingLinkedList.enqueue(2);

        System.out.println("element peeked : " + queueUsingLinkedList.peek());
        System.out.println("element dequeued : " + queueUsingLinkedList.dequeue());
        System.out.println("element peeked : " + queueUsingLinkedList.peek());
        System.out.println("element dequeued : " + queueUsingLinkedList.dequeue());
        System.out.println("element peeked : " + queueUsingLinkedList.peek());
        System.out.println("element dequeued : " + queueUsingLinkedList.dequeue());

        try {
            System.out.println("element peeked : " + queueUsingLinkedList.peek());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("element dequeued : " + queueUsingLinkedList.dequeue());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
