package AZStriverPlaylist.StackAndQueues;

public class LinearQueueUsingArray {
    private int[] arr;
    private int beginningOfQueue;
    private int endOfQueue;

    public LinearQueueUsingArray(int size) {
        this.arr = new int[size];
        this.beginningOfQueue = -1;
        this.endOfQueue = -1;
    }

    public boolean isEmpty() {
        return beginningOfQueue == -1;
    }

    public boolean isFull() {
        return endOfQueue == this.arr.length - 1;
    }

    public void enqueue(int value) throws RuntimeException {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if(isEmpty()){
            beginningOfQueue=0;
        }
        this.arr[++endOfQueue] = value;
    }

    public int dequeue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        int value = this.arr[beginningOfQueue++];
        if (beginningOfQueue > endOfQueue) {
            beginningOfQueue = endOfQueue = -1;
        }
        return value;
    }

    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return this.arr[beginningOfQueue];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = beginningOfQueue; i <= endOfQueue; i++) {
            sb.append(arr[i]);
            if (i < endOfQueue) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinearQueueUsingArray linearQueueUsingArray = new LinearQueueUsingArray(3);
        System.out.println("Queue is Empty : "+linearQueueUsingArray.isEmpty());
        System.out.println("Queue is Full : "+linearQueueUsingArray.isFull());

        linearQueueUsingArray.enqueue(0);
        linearQueueUsingArray.enqueue(1);
        linearQueueUsingArray.enqueue(2);

        System.out.println("Queue is Empty : "+linearQueueUsingArray.isEmpty());
        System.out.println("Queue is Full : "+linearQueueUsingArray.isFull());

        try {
            linearQueueUsingArray.enqueue(3);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.err.println("element peeked : "+linearQueueUsingArray.peek());
        System.err.println("element dequeued : "+linearQueueUsingArray.dequeue());
        System.err.println("element peeked : "+linearQueueUsingArray.peek());
        System.err.println("element dequeued : "+linearQueueUsingArray.dequeue());
        System.err.println("element peeked : "+linearQueueUsingArray.peek());
        System.err.println("element dequeued : "+linearQueueUsingArray.dequeue());

        try {
            System.err.println("element dequeued : "+linearQueueUsingArray.dequeue());
        } catch (Exception e) {
            System.out.println(e);
        }try {
            System.err.println("element peeked : "+linearQueueUsingArray.peek());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Queue is Empty : "+linearQueueUsingArray.isEmpty());
        System.out.println("Queue is Full : "+linearQueueUsingArray.isFull());
        linearQueueUsingArray.enqueue(0);
        System.err.println("element peeked : "+linearQueueUsingArray.peek());
        System.err.println("element dequeued : "+linearQueueUsingArray.dequeue());
        System.out.println("Queue is Empty : "+linearQueueUsingArray.isEmpty());
        System.out.println("Queue is Full : "+linearQueueUsingArray.isFull());
    }

}
