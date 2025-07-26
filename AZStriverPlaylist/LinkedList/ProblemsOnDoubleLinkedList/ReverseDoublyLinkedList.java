package AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList;

import java.util.Stack;

public class ReverseDoublyLinkedList {

    public static <T> DoubleLinkedListNode<T> reverseListBruteForce(DoubleLinkedListNode<T> head){
        Stack<T> stack = new Stack<>();
        DoubleLinkedListNode<T> curr = head;
        while(curr!=null){
            stack.push(curr.data);
            curr = curr.next;
        }
        curr = head;
        while(curr!=null){
            curr.data = stack.pop();
            curr = curr.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        DoubleLinkedListNode<Integer> head = DoubleLinkedListUtility.convertArrayToList(arr1);
        DoubleLinkedListUtility.printDoubleLinkedList(head);
        
        head = ReverseDoublyLinkedList.reverseListBruteForce(head);
        DoubleLinkedListUtility.printDoubleLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
