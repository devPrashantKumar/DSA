package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class LengthOfLoopInLinkedList {
    public static <T> int lengthOfLoopInLL(SingleLinkedListNode<T> head) {
        SingleLinkedListNode<T> tortoise = head;
        SingleLinkedListNode<T> hare = head;
        int len = 0;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                hare = head;
                do {
                    hare = hare.next;
                    len++;
                } while (hare != tortoise);
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        head.next.next.next.next = head.next;
        // SingleLinkedListUtility.printLinkedList(head);
        System.out.println("output : " + LengthOfLoopInLinkedList.lengthOfLoopInLL(head));
        // SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        Integer[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        // SingleLinkedListUtility.printLinkedList(head);
        System.out.println("output : " + LengthOfLoopInLinkedList.lengthOfLoopInLL(head2));
        // SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
