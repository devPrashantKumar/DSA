package AZStriverPlaylist.LinkedList.DoubleLinkedList;

/*
 * 5 Type of Insertion in Linked List
 *      1) Insert at Head
 *      2) Insert at Last
 *      3) Insert at Location
 *      4) Insert after Element
 *      5) Insert before Element
 * Forward Traversal of Linked List
 * Backward Traversal of Linked List
 * Length of Linked List
 * Search Linked List
 * 4 Types of Deletion in Linked List
 *      1) Deletion at Head
 *      2) Deletion at Last
 *      3) Deletion at Location
 *      4) Deletion of Element
 * Clear Linked List
 */
public class DoubleLinkedList<T> {
    class Node {
        T value;
        Node prev;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;

    public void insertNodeAtHeadInLinkedList(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertNodeAtLastInLinkedList(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertNodeAfterElementInLinkedList(T element, T value) {
        Node newNode = new Node(value);
        Node curr = head;
        while (curr != null) {
            if (curr.value.equals(element)) {
                newNode.next = curr.next;
                newNode.prev = curr;
                if (curr.next != null) {
                    curr.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }
        if (curr == null) {
            throw new RuntimeException("Element Not Found in Linked List");
        }
    }

    public void insertNodeBeforeElementInLinkedList(T element, T value) {
        Node newNode = new Node(value);
        Node curr = head;
        while (curr != null) {
            if (curr.value.equals(element)) {
                newNode.next = curr;
                newNode.prev = curr.prev;
                if (curr.prev != null) {
                    curr.prev.next = newNode;
                } else {
                    head = newNode;
                }
                curr.prev = newNode;
                break;
            }
            curr = curr.next;
        }
        if (curr == null) {
            throw new RuntimeException("Element Not Found in Linked List");
        }
    }

    public void insertNodeAtLocationInLinkedList(int location, T value) {
        Node newNode = new Node(value);
        if (head == null) {
            if (location != 0) {
                throw new RuntimeException("Head is null, valid location is 0 only");
            }
            head = tail = newNode;
        } else {
            if (location == 0) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                Node curr = head;
                for (int i = 1; i < location; i++) {
                    curr = curr.next;
                    if (curr == null) {
                        throw new RuntimeException("Location is Invalid, Location greater than size of list");
                    }
                }
                newNode.next = curr.next;
                newNode.prev = curr;
                if (curr.next != null) {
                    curr.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                curr.next = newNode;
            }
        }
    }

    public int lengthOfLinkedList() {
        Node current = head;
        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
    }

    public void forwardTraverseLinkedList() {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void backwardTraverseLinkedList() {
        if (tail == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    public boolean searchInLinkedList(T value) {
        Node current = head;
        while (current != null) {
            if (value.equals(current.value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void deleteHeadNodeInLinkedList() {
        if (head == null) {
            throw new RuntimeException("Linked List is Empty");
        }
        head = head.next;
        if(head!=null){
            head.prev=null;
        }else{
            tail=null;
        }
    }

    public void deleteLastNodeInLinkedList() {
        if (head == null) {
            throw new RuntimeException("Linked List is Empty");
        }
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            Node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
        }
    }

    public void deleteNodeAtLocationInLinkedList(int location) {
        if (head == null) {
            throw new RuntimeException("Linked List is Empty");
        }
        Node curr = head;
        for (int i = 0; i < location; i++) {
            curr = curr.next;
            if (curr == null) {
                throw new RuntimeException("Invalid Locatiion");
            }
        }
        if (curr == head) {
            head = head.next;
            if (head == null) {
                tail = null;
            }else{
                head.prev = null;
            }
        } else {
            curr.prev.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = curr.prev;
            }else{
                tail = curr.prev;
            }
        }
    }

    public void deleteElementInLinkedList(T element) {
        if (head == null) {
            throw new RuntimeException("Linked List is Empty");
        }
        Node curr = head;
        while (curr != null) {
            if (curr.value.equals(element)) {
                if (curr == head) {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    }else{
                        head.prev=null;
                    }
                } else {
                    curr.prev.next = curr.next;
                    if (curr.next == null) {
                        tail = curr.prev;
                    }
                    else{
                        curr.next.prev = curr.prev;
                    }
                }
                break;
            }
            curr = curr.next;
        }

        if (curr == null) {
            throw new RuntimeException("Element Not Found in Linked List");
        }
    }

    public void clearLinkedList() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.insertNodeAtHeadInLinkedList(1);
        doubleLinkedList.insertNodeAtHeadInLinkedList(2);
        doubleLinkedList.insertNodeAtHeadInLinkedList(3);
        doubleLinkedList.insertNodeAtHeadInLinkedList(4);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("----------------------------------------------------------");

        doubleLinkedList.insertNodeAtLastInLinkedList(1);
        doubleLinkedList.insertNodeAtLastInLinkedList(2);
        doubleLinkedList.insertNodeAtLastInLinkedList(3);
        doubleLinkedList.insertNodeAtLastInLinkedList(4);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("----------------------------------------------------------");

        System.out.println("Length of Linked List : " + doubleLinkedList.lengthOfLinkedList());
        try {
            doubleLinkedList.insertNodeAtLocationInLinkedList(1, 1);
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        doubleLinkedList.insertNodeAtLocationInLinkedList(1, 0);
        doubleLinkedList.insertNodeAtLocationInLinkedList(2, 2);
        doubleLinkedList.insertNodeAtLocationInLinkedList(3, 2);
        doubleLinkedList.insertNodeAtLocationInLinkedList(2, 5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.insertNodeAtLocationInLinkedList(6, 1);
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.insertNodeAtLocationInLinkedList(5, 1);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("Length of Linked List : " + doubleLinkedList.lengthOfLinkedList());
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("------------------------------------------------------");

        doubleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        doubleLinkedList.insertNodeAfterElementInLinkedList(0, 1);
        doubleLinkedList.insertNodeAfterElementInLinkedList(0, 2);
        doubleLinkedList.insertNodeAfterElementInLinkedList(2, 3);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.insertNodeAfterElementInLinkedList(7, 8);
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.insertNodeAfterElementInLinkedList(3, 4);
        doubleLinkedList.insertNodeAfterElementInLinkedList(2, 5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("------------------------------------------------------");

        doubleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 1);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 2);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.insertNodeAfterElementInLinkedList(7, 8);
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 3);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(3, 4);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("------------------------------------------------------");

        doubleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 1);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 2);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 3);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(3, 4);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("Element Found in Linked List : " + doubleLinkedList.searchInLinkedList(12));
        System.out.println("Element Found in Linked List : " + doubleLinkedList.searchInLinkedList(0));
        System.out.println("Element Found in Linked List : " + doubleLinkedList.searchInLinkedList(1));
        System.out.println("Element Found in Linked List : " + doubleLinkedList.searchInLinkedList(3));
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("------------------------------------------------------");
        
        doubleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 1);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 2);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 3);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(3, 4);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteHeadNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteHeadNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteHeadNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteHeadNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteHeadNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteHeadNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.deleteHeadNodeInLinkedList();
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("------------------------------------------------------");

        doubleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 1);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 2);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 3);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(3, 4);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteLastNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteLastNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteLastNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteLastNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteLastNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteLastNodeInLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.deleteLastNodeInLinkedList();
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("------------------------------------------------------");

        doubleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 1);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 2);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 3);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(3, 4);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteNodeAtLocationInLinkedList(0);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteNodeAtLocationInLinkedList(4);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteNodeAtLocationInLinkedList(1);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteNodeAtLocationInLinkedList(2);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.deleteNodeAtLocationInLinkedList(3);
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteNodeAtLocationInLinkedList(1);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteNodeAtLocationInLinkedList(0);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.deleteNodeAtLocationInLinkedList(0);
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("------------------------------------------------------");

        doubleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 1);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(0, 2);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 3);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(3, 4);
        doubleLinkedList.insertNodeBeforeElementInLinkedList(2, 5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteElementInLinkedList(0);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteElementInLinkedList(4);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteElementInLinkedList(1);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteElementInLinkedList(2);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.deleteElementInLinkedList(10);
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteElementInLinkedList(3);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        doubleLinkedList.deleteElementInLinkedList(5);
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        try {
            doubleLinkedList.deleteElementInLinkedList(10);
        } catch (Exception e) {
            System.out.println(e);
        }
        doubleLinkedList.clearLinkedList();
        doubleLinkedList.forwardTraverseLinkedList();
        doubleLinkedList.backwardTraverseLinkedList();
        System.out.println("------------------------------------------------------");
    }

}
