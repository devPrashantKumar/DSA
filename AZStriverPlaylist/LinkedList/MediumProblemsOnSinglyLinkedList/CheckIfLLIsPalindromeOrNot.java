package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class CheckIfLLIsPalindromeOrNot {
    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static <T> boolean isPalindromBruteForce(SingleLinkedListNode<T> head) {
        List<T> list = new ArrayList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - i - 1)))
                return false;
        }
        return true;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexty : O(1)
     */
    public static <T> boolean isPalindromOptimized(SingleLinkedListNode<T> head) {
        SingleLinkedListNode<T> hare = head;
        SingleLinkedListNode<T> tortoise = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        hare = head;
        tortoise = ReverseLinkedList.reverseListIterative(tortoise);
        while (hare != null && tortoise != null) {
            if (hare.data != tortoise.data)
                return false;
            hare = hare.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 4, 3, 2, 1 };
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        // SingleLinkedListUtility.printLinkedList(head);
        System.out.println("output : " + CheckIfLLIsPalindromeOrNot.isPalindromBruteForce(head));
        System.out.println("output : " + CheckIfLLIsPalindromeOrNot.isPalindromOptimized(head));

        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        Integer[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        // SingleLinkedListUtility.printLinkedList(head);
        System.out.println("output : " + CheckIfLLIsPalindromeOrNot.isPalindromBruteForce(head2));
        System.out.println("output : " + CheckIfLLIsPalindromeOrNot.isPalindromOptimized(head2));

        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
