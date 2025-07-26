package AZStriverPlaylist.LinkedList.ProblemsOnLinkedList;

public class SingleLinkedListUtility {
    public static <T> SingleLinkedListNode<T> convertArrayToList(T[] arr) {
        SingleLinkedListNode<T> head = null;
        SingleLinkedListNode<T> current = null;

        for (int i = 0; i < arr.length; i++) {
            SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(arr[i]);
            if (i == 0) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }
        return head;
    }

    public static <T> void printLinkedList(SingleLinkedListNode<T> head) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        SingleLinkedListNode<T> curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
