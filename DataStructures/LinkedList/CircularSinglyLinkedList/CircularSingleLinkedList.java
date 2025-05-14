package DataStructures.LinkedList.CircularSinglyLinkedList;

public class CircularSingleLinkedList {
    Node head;
    Node tail;
    int size;

    public void insertElement(int value, int location){
        Node newNode = new Node(value,null);
        if(head==null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else if(location==0){
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        else if(location>=size){
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        else{
            Node current = head;
            for(int i=0;i<location-1;i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void traveseCircularSingleLinkedList(){
        if(head==null){
            return;
        }
        Node current = head;
        do{
            System.out.print(current.value+" ");
            current = current.next;
        }while(current!=head);
        System.out.println();
    }

    public void traveseUsingTailCircularSingleLinkedList(){
        if(tail==null){
            return;
        }
        Node current = tail.next;
        do{
            System.out.print(current.value+" ");
            current = current.next;
        }while(current!=tail.next);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
        circularSingleLinkedList.insertElement(10, 0);
        circularSingleLinkedList.traveseCircularSingleLinkedList();
        circularSingleLinkedList.insertElement(11,1);
        circularSingleLinkedList.traveseCircularSingleLinkedList();
        circularSingleLinkedList.insertElement(12,0);
        circularSingleLinkedList.traveseCircularSingleLinkedList();
        circularSingleLinkedList.insertElement(13,3);
        circularSingleLinkedList.traveseCircularSingleLinkedList();
        circularSingleLinkedList.insertElement(14,2);
        circularSingleLinkedList.traveseCircularSingleLinkedList();
        circularSingleLinkedList.traveseUsingTailCircularSingleLinkedList();
    }
}
