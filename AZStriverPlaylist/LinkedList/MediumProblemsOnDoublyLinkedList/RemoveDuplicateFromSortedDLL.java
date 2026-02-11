package AZStriverPlaylist.LinkedList.MediumProblemsOnDoublyLinkedList;

import AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList.DoubleLinkedListNode;
import AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList.DoubleLinkedListUtility;

public class RemoveDuplicateFromSortedDLL {
    public static <T> DoubleLinkedListNode<T> removeDuplicates(DoubleLinkedListNode<T> head){
        if(head==null || head.next==null) return head;

        DoubleLinkedListNode<T> curr = head;
        T lastUsed = null;
        while(curr!=null){
            if(curr.data.equals(lastUsed)){
                if(curr.prev!=null){
                    curr.prev.next = curr.next;
                }
                if(curr.next!=null){
                    curr.next.prev = curr.prev;
                }
            }
            lastUsed = curr.data;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,1,3,3,4,5};
        DoubleLinkedListNode<Integer> head1 = DoubleLinkedListUtility.convertArrayToList(arr1);
        DoubleLinkedListUtility.printDoubleLinkedList(head1);
        System.out.println("----------------------------------------------------------");

        head1 = RemoveDuplicateFromSortedDLL.removeDuplicates(head1);
        DoubleLinkedListUtility.printDoubleLinkedList(head1);
        System.out.println("----------------------------------------------------------");

        
        Integer[] arr2 = {1,1,1,1,2};
        DoubleLinkedListNode<Integer> head2 = DoubleLinkedListUtility.convertArrayToList(arr2);
        DoubleLinkedListUtility.printDoubleLinkedList(head2);
        System.out.println("----------------------------------------------------------");

        head2 = RemoveDuplicateFromSortedDLL.removeDuplicates(head2);
        DoubleLinkedListUtility.printDoubleLinkedList(head2);
        System.out.println("----------------------------------------------------------");
    }
}
