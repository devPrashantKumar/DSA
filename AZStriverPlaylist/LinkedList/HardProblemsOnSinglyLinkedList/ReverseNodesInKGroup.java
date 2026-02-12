package AZStriverPlaylist.LinkedList.HardProblemsOnSinglyLinkedList;

import AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList.SingleLinkedListNode;
import AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList.SingleLinkedListUtility;

public class ReverseNodesInKGroup {
    public static <T> SingleLinkedListNode<T> reverseKGroup(SingleLinkedListNode<T> head, int k) {
        if (head == null || head.next == null || k == 0 || k == 1)
            return head;
        SingleLinkedListNode<T> finalHead = new SingleLinkedListNode<T>(null);
        SingleLinkedListNode<T> finalTail = finalHead;
        SingleLinkedListNode<T> curr = head;
        SingleLinkedListNode<T> prev = null;
        SingleLinkedListNode<T> groupHead = head;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == 1) {
                groupHead = curr;
            }
            SingleLinkedListNode<T> temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            if (count == k) {
                finalTail.next = prev;
                finalTail = groupHead;
                count = 0;
                prev = null;
            }
        }
        if (count != 0) {
            groupHead = prev;
            prev = null;
            while (groupHead != null) {
                SingleLinkedListNode<T> temp = groupHead;
                groupHead = groupHead.next;
                temp.next = prev;
                prev = temp;
            }
            finalTail.next = prev;
        }
        return finalHead.next;
    }

    public static <T> SingleLinkedListNode<T> reverseKGroup2(SingleLinkedListNode<T> head, int k) {
        if (head == null || head.next == null || k == 0 || k == 1)
            return head;
        SingleLinkedListNode<T> finalHead = new SingleLinkedListNode<T>(null);
        SingleLinkedListNode<T> finalTail = finalHead;
        SingleLinkedListNode<T> curr = head;
        SingleLinkedListNode<T> groupHead = null;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == 1) {
                groupHead = curr;
                curr = curr.next;
            } else if (count == k) {
                SingleLinkedListNode<T> temp = curr;
                curr = curr.next;
                temp.next = null;
                SingleLinkedListNode<T> reversedHead = reverse(groupHead);
                finalTail.next = reversedHead;
                finalTail = groupHead;
                count = 0;
            } else {
                curr = curr.next;
            }
        }
        if (count != 0) {
            finalTail.next = groupHead;
        }
        return finalHead.next;
    }

    public static <T> SingleLinkedListNode<T> reverse(SingleLinkedListNode<T> head) {
        SingleLinkedListNode<T> prev = null;
        while (head != null) {
            SingleLinkedListNode<T> temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }

    public static <T> SingleLinkedListNode<T> reverseKGroup3(SingleLinkedListNode<T> head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;

        SingleLinkedListNode<T> dummy = new SingleLinkedListNode<>(null);
        SingleLinkedListNode<T> finalTail = dummy;

        SingleLinkedListNode<T> curr = head;
        SingleLinkedListNode<T> groupHead = null;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == 1) {
                groupHead = curr;
            }
            if (count == k) {
                SingleLinkedListNode<T> nextGroupHead = curr.next;
                curr.next = null;
                SingleLinkedListNode<T> reversedHead = reverse(groupHead);
                finalTail.next = reversedHead;
                finalTail = groupHead;
                finalTail.next = nextGroupHead;
                curr = nextGroupHead;
                count = 0;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 4, 5 };
        int k1 = 2;
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        head = ReverseNodesInKGroup.reverseKGroup(head, k1);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        Integer[] arr2 = { 1, 2, 3, 4, 5 };
        int k2 = 2;
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        SingleLinkedListUtility.printLinkedList(head2);
        head2 = ReverseNodesInKGroup.reverseKGroup2(head2, k2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
        Integer[] arr3 = { 1, 2, 3, 4, 5 };
        int k3 = 2;
        SingleLinkedListNode<Integer> head3 = SingleLinkedListUtility.convertArrayToList(arr3);
        SingleLinkedListUtility.printLinkedList(head3);
        head3 = ReverseNodesInKGroup.reverseKGroup3(head3, k3);
        SingleLinkedListUtility.printLinkedList(head3);
        System.out.println("----------------------------------------------------------");
        Integer[] arr4 = { 1, 2, 3, 4, 5 };
        int k4 = 3;
        SingleLinkedListNode<Integer> head4 = SingleLinkedListUtility.convertArrayToList(arr4);
        SingleLinkedListUtility.printLinkedList(head4);
        head4 = ReverseNodesInKGroup.reverseKGroup(head4, k4);
        SingleLinkedListUtility.printLinkedList(head4);
        System.out.println("----------------------------------------------------------");
        Integer[] arr5 = { 1, 2, 3, 4, 5 };
        int k5 = 3;
        SingleLinkedListNode<Integer> head5 = SingleLinkedListUtility.convertArrayToList(arr5);
        SingleLinkedListUtility.printLinkedList(head5);
        head5 = ReverseNodesInKGroup.reverseKGroup2(head5, k5);
        SingleLinkedListUtility.printLinkedList(head5);
        System.out.println("----------------------------------------------------------");
        Integer[] arr6 = { 1, 2, 3, 4, 5 };
        int k6 = 3;
        SingleLinkedListNode<Integer> head6 = SingleLinkedListUtility.convertArrayToList(arr6);
        SingleLinkedListUtility.printLinkedList(head6);
        head6 = ReverseNodesInKGroup.reverseKGroup3(head6, k6);
        SingleLinkedListUtility.printLinkedList(head6);
        System.out.println("----------------------------------------------------------");

    }
}
