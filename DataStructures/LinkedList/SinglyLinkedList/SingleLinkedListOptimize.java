package DataStructures.LinkedList.SinglyLinkedList;

class SingleLinkedListOptimize {
    class Node{
        int value;
        Node next;

        public Node(){

        }

        public Node(int value){
            this.value = value;
        }
    }

    Node head;
    Node tail;

    
    public void insertNodeInLinkedList(int value, int location){
        Node newNode = new Node(value);
        if(head==null){
            if(location!=0){
                throw new NodeInsertionException("location is wrong");
            }
            head = tail = newNode;
        }
        else{
            if(location==0){
                newNode.next = head;
                head = newNode;
            }
            else{
                Node current = head;
                for(int i=0;i<location-1;i++){
                    current = current.next;
                    if(current==null){
                        throw new NodeInsertionException("location is wrong");
                    }
                }
                if(current==tail){
                    tail.next = newNode;
                    tail = newNode;
                }else{
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }
        }
    }

    public void traverseLinkedList(){
        if(head==null){
            System.out.println("Linked List is Empty");
            return;
        }
        Node current = head;
        while (current!=null) {
            System.out.print(current.value+" ");
            current = current.next;
        }
        System.out.println();
    }

    public void deleteNodeInLinkedList(int location){
        if(head==null){
            throw new NodeDeletionException("location is wrong, Linked List is Empty");
        }
        else{
            if(head==tail){
                head=null;
                tail=null;
            }
            else if(location==0){
                head = head.next;
            }
            else{
                Node curNode = head;
                for(int i=0;i<location-1;i++){
                    curNode = curNode.next;
                }
                curNode.next = curNode.next.next;
            }
        }
    }
    
}