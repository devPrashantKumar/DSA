package AZStriverPlaylist.LinkedList;

public class SingleLinkedList<T> {
    class Node {
        public T value;
        public Node next;
    
        public Node() {
        }
    
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node head;
    Node tail;
    int size;

    public void insertElement(int location, T value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (location == 0) {
            newNode.next = head;
            head = newNode;
        } else if (location >= size) {
            tail.next = newNode;
            tail = tail.next;
        } else {
            Node current = head;
            for (int i = 1; i < location; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void traverseLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int lengthOfLinkedList() {
        Node current = head;
        int len=0;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
    }

    public T searchLinkedList(T value) {
        Node current = head;
        while (current != null) {
            if(value.equals(current.value)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteLinkedList(){
        head=null;
        tail=null;
    }

    public void deleteNodeInLinkedList(int location){
        if(head==null){
            return;
        }
        else if(head==tail){
            head=null;
            tail=null;
        }
        else if(location==0){
            head = head.next;
        }
        else{
            Node prev = head;
            for(int i=0;i<location-1;i++){
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> sLL = new SingleLinkedList<>();
        sLL.insertElement(0,10); 
        sLL.traverseLinkedList();
        sLL.insertElement(1,11); 
        sLL.insertElement(2,12); 
        sLL.traverseLinkedList();
        System.out.println("Length of Linked List : "+sLL.lengthOfLinkedList());
        sLL.insertElement(1,13); 
        sLL.traverseLinkedList();
        Integer nodeValue =sLL.searchLinkedList(10);
        if(nodeValue!=null){
            System.out.println("Node Found : "+nodeValue);
        }
        Integer nodeValue2 = sLL.searchLinkedList(15);
        if(nodeValue2==null){
            System.out.println("Node Not Found : "+nodeValue2);
        }
        sLL.traverseLinkedList();
        sLL.deleteLinkedList();
        sLL.traverseLinkedList();
        System.out.println("Length of Linked List : "+sLL.lengthOfLinkedList());

    }
}
