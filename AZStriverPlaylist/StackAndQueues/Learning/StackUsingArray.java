package AZStriverPlaylist.StackAndQueues.Learning;

public class StackUsingArray {
    private int[] arr;
    private int topOfStack;

    public StackUsingArray(int size) {
        this.arr = new int[size];
        topOfStack = -1;
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

    public boolean isFull() {
        return topOfStack == arr.length - 1;
    }

    public void push(int value) throws RuntimeException {
        if (isFull()) {
            throw new RuntimeException("Stack is Full");
        }
        this.arr[++topOfStack] = value;
    }

    public int pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return this.arr[topOfStack--];
    }

    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return this.arr[topOfStack];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= topOfStack; i++) {
            sb.append(arr[i]);
            if (i < topOfStack) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        StackUsingArray stackUsingArray = new StackUsingArray(3);
        System.out.println("Stack is Empty : " + stackUsingArray.isEmpty());
        System.out.println("Stack is Full : " + stackUsingArray.isFull());

        stackUsingArray.push(0);
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        try {
            stackUsingArray.push(3);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Stack is Empty : " + stackUsingArray.isEmpty());
        System.out.println("Stack is Full : " + stackUsingArray.isFull());

        System.out.println("Element Peeked : "+stackUsingArray.peek());
        System.out.println("Element Poped : "+stackUsingArray.pop());
        System.out.println("Element Peeked : "+stackUsingArray.peek());
        System.out.println("Element Poped : "+stackUsingArray.pop());
        System.out.println("Element Peeked : "+stackUsingArray.peek());
        System.out.println("Element Poped : "+stackUsingArray.pop());

        try {
            System.out.println("Element Poped : "+stackUsingArray.pop());

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println("Element Peeked : "+stackUsingArray.peek());

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Stack is Empty : " + stackUsingArray.isEmpty());
        System.out.println("Stack is Full : " + stackUsingArray.isFull());
    }
}
