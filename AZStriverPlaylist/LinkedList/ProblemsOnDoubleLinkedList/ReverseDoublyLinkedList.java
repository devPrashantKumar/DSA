package AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList;

import java.util.Stack;

public class ReverseDoublyLinkedList {

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(n)
    */
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

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(n)
    */
    public static <T> DoubleLinkedListNode<T> reverseListBruteForce2(DoubleLinkedListNode<T> head){
        Stack<DoubleLinkedListNode<T>> stack = new Stack<>();
        DoubleLinkedListNode<T> curr = head;
        while(curr!=null){
            stack.push(curr);
            curr = curr.next;
        }
        DoubleLinkedListNode<T> prev = null;
        while(!stack.isEmpty()){
            DoubleLinkedListNode<T> node = stack.pop();
            if(prev==null){
                head = node;
                node.prev = null;
            }else{
                prev.next = node;
                node.prev = prev;
            }
            prev = node;
        }
        if(prev!=null) prev.next = null;
        return head;
    }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1)
    */
    public static <T> DoubleLinkedListNode<T> reverseList(DoubleLinkedListNode<T> head){
        DoubleLinkedListNode<T> curr = head;
        DoubleLinkedListNode<T> prev=null;
        while(curr!=null){
            prev = curr;
            DoubleLinkedListNode<T> temp =curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        return prev;
    }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1)
    */
    public static <T> DoubleLinkedListNode<T> reverseList2(DoubleLinkedListNode<T> head){
        DoubleLinkedListNode<T> curr = head;
        while(curr!=null){
            DoubleLinkedListNode<T> temp =curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            if(curr.prev==null) return curr;
            curr = curr.prev;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        DoubleLinkedListNode<Integer> head1 = DoubleLinkedListUtility.convertArrayToList(arr1);
        DoubleLinkedListUtility.printDoubleLinkedList(head1);
        System.out.println("----------------------------------------------------------");

        head1 = ReverseDoublyLinkedList.reverseListBruteForce(head1);
        DoubleLinkedListUtility.printDoubleLinkedList(head1);
        System.out.println("----------------------------------------------------------");
        
        DoubleLinkedListNode<Integer> head2 = DoubleLinkedListUtility.convertArrayToList(arr1);
        head2 = ReverseDoublyLinkedList.reverseListBruteForce2(head2);
        DoubleLinkedListUtility.printDoubleLinkedList(head2);
        System.out.println("----------------------------------------------------------");

        DoubleLinkedListNode<Integer> head3 = DoubleLinkedListUtility.convertArrayToList(arr1);
        head3 = ReverseDoublyLinkedList.reverseList(head3);
        DoubleLinkedListUtility.printDoubleLinkedList(head3);
        System.out.println("----------------------------------------------------------");

        DoubleLinkedListNode<Integer> head4 = DoubleLinkedListUtility.convertArrayToList(arr1);
        head4 = ReverseDoublyLinkedList.reverseList2(head4);
        DoubleLinkedListUtility.printDoubleLinkedList(head4);
        System.out.println("----------------------------------------------------------");
    }
}
