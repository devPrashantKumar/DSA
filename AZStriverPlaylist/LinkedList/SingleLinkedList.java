package AZStriverPlaylist.LinkedList;

/*
 * 5 Type of Insertion in Linked List
 *      1) Insert at Head
 *      2) Insert at Last
 *      3) Insert at Location
 *      4) Insert after Element
 *      5) Insert before Element
 * Traversal of Linked List
 * Length of Linked List
 * Search Linked List
 * (n) Types of Deletion in Linked List
 * Clear Linked List
 */
class SingleLinkedList<T> {
    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void insertNodeAtHeadInLinkedList(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertNodeAtLastInLinkedList(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void insertNodeAfterElementInLinkedList(T element, T value) {
        Node newNode = new Node(value);
        Node curr = head;
        while (curr != null) {
            if (curr.value.equals(element)) {
                if (curr == tail) {
                    tail = newNode;
                }
                newNode.next = curr.next;
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }
    }

    public void insertNodeBeforeElementInLinkedList(T element, T value) {
        Node newNode = new Node(value);
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.value.equals(element)) {
                if (curr == head) {
                    head = newNode;
                } else {
                    prev.next = newNode;
                }
                newNode.next = curr;
                break;
            }
            prev = curr;
            curr = curr.next;
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
                head = newNode;
            } else {
                Node current = head;
                for (int i = 0; i < location - 1; i++) {
                    current = current.next;
                    if (current == null) {
                        throw new RuntimeException("Location is Invalid, Location greater then size of list");
                    }
                }
                newNode.next = current.next;
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
            }
        }
    }

    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
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

    public void deleteNodeInLinkedList(int location) {
        if (head == null) {
            throw new RuntimeException("location is wrong, Linked List is Empty");
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else if (location == 0) {
                head = head.next;
            } else {
                Node curNode = head;
                for (int i = 0; i < location - 1; i++) {
                    curNode = curNode.next;
                }
                curNode.next = curNode.next.next;
            }
        }
    }

    public void clearLinkedList() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();

        System.out.println("Length of Linked List : " + singleLinkedList.lengthOfLinkedList());
        try {
            singleLinkedList.insertNodeAtLocationInLinkedList(1, 1);
        } catch (Exception e) {
            System.out.println(e);
        }
        singleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        singleLinkedList.insertNodeAtLocationInLinkedList(1, 0);
        singleLinkedList.insertNodeAtLocationInLinkedList(2, 2);
        singleLinkedList.insertNodeAtLocationInLinkedList(3, 2);
        singleLinkedList.insertNodeAtLocationInLinkedList(2, 5);
        singleLinkedList.traverseLinkedList();
        try {
            singleLinkedList.insertNodeAtLocationInLinkedList(6, 1);
        } catch (Exception e) {
            System.out.println(e);
        }
        singleLinkedList.insertNodeAtLocationInLinkedList(5, 1);
        singleLinkedList.traverseLinkedList();
        System.out.println("Length of Linked List : " + singleLinkedList.lengthOfLinkedList());
        singleLinkedList.clearLinkedList();
        singleLinkedList.traverseLinkedList();
        System.out.println("------------------------------------------------------");

        singleLinkedList.insertNodeAtHeadInLinkedList(1);
        singleLinkedList.insertNodeAtHeadInLinkedList(2);
        singleLinkedList.insertNodeAtHeadInLinkedList(3);
        singleLinkedList.insertNodeAtHeadInLinkedList(4);
        singleLinkedList.traverseLinkedList();
        singleLinkedList.clearLinkedList();
        singleLinkedList.traverseLinkedList();
        System.out.println("------------------------------------------------------");

        singleLinkedList.insertNodeAtLastInLinkedList(1);
        singleLinkedList.insertNodeAtLastInLinkedList(2);
        singleLinkedList.insertNodeAtLastInLinkedList(3);
        singleLinkedList.insertNodeAtLastInLinkedList(4);
        singleLinkedList.traverseLinkedList();
        singleLinkedList.clearLinkedList();
        singleLinkedList.traverseLinkedList();
        System.out.println("------------------------------------------------------");

        singleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        singleLinkedList.insertNodeAfterElementInLinkedList(0, 1);
        singleLinkedList.insertNodeAfterElementInLinkedList(0, 2);
        singleLinkedList.insertNodeAfterElementInLinkedList(2, 3);
        singleLinkedList.insertNodeAfterElementInLinkedList(3, 4);
        singleLinkedList.insertNodeAfterElementInLinkedList(2, 5);
        singleLinkedList.traverseLinkedList();
        singleLinkedList.clearLinkedList();
        singleLinkedList.traverseLinkedList();
        System.out.println("------------------------------------------------------");

        singleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        singleLinkedList.insertNodeBeforeElementInLinkedList(0, 1);
        singleLinkedList.insertNodeBeforeElementInLinkedList(0, 2);
        singleLinkedList.insertNodeBeforeElementInLinkedList(2, 3);
        singleLinkedList.insertNodeBeforeElementInLinkedList(3, 4);
        singleLinkedList.insertNodeBeforeElementInLinkedList(2, 5);
        singleLinkedList.traverseLinkedList();
        singleLinkedList.clearLinkedList();
        singleLinkedList.traverseLinkedList();
        System.out.println("------------------------------------------------------");

        singleLinkedList.insertNodeAtLocationInLinkedList(0, 0);
        singleLinkedList.insertNodeBeforeElementInLinkedList(0, 1);
        singleLinkedList.insertNodeBeforeElementInLinkedList(0, 2);
        singleLinkedList.insertNodeBeforeElementInLinkedList(2, 3);
        singleLinkedList.insertNodeBeforeElementInLinkedList(3, 4);
        singleLinkedList.insertNodeBeforeElementInLinkedList(2, 5);
        singleLinkedList.traverseLinkedList();
        System.out.println("Element Found in Linked List : "+singleLinkedList.searchInLinkedList(12));
        System.out.println("Element Found in Linked List : "+singleLinkedList.searchInLinkedList(0));
        System.out.println("Element Found in Linked List : "+singleLinkedList.searchInLinkedList(1));
        System.out.println("Element Found in Linked List : "+singleLinkedList.searchInLinkedList(3));
        singleLinkedList.clearLinkedList();
        singleLinkedList.traverseLinkedList();
        System.out.println("------------------------------------------------------");

        // singleLinkedList.deleteNodeInLinkedList(2);
        // singleLinkedList.traverseLinkedList();
        // singleLinkedList.deleteNodeInLinkedList(0);
        // singleLinkedList.traverseLinkedList();
        // singleLinkedList.deleteNodeInLinkedList(1);
        // singleLinkedList.traverseLinkedList();
        // singleLinkedList.deleteNodeInLinkedList(0);
        // singleLinkedList.traverseLinkedList();
    }

}