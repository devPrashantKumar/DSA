package AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList;

public class DoubleLinkedListUtility {
    public static <T> DoubleLinkedListNode<T> convertArrayToList(T[] arr) {
        DoubleLinkedListNode<T> head = null;
        DoubleLinkedListNode<T> current = null;

        for (int i = 0; i < arr.length; i++) {
            DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(arr[i]);
            if (i == 0) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                newNode.prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public static <T> void printDoubleLinkedList(DoubleLinkedListNode<T> head) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        DoubleLinkedListNode<T> curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
