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

    public static <T> DoubleLinkedListNode<T> removeDuplicatesApproach2(DoubleLinkedListNode<T> head){
        if(head==null || head.next==null) return head;
        DoubleLinkedListNode<T> curr1 = head;
        DoubleLinkedListNode<T> curr2 = head.next;

        while(curr2!=null){
            if(curr1.data.equals(curr2.data)){
                curr2 = curr2.next;
                continue;
            }else{
                curr1.next = curr2;
                curr2.prev = curr1;
            }
            curr1 = curr1.next;
            curr2 =curr2.next;
        }
        curr1.next=null;
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
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");

        Integer[] arr3 = {1,1,3,3,4,5};
        DoubleLinkedListNode<Integer> head3 = DoubleLinkedListUtility.convertArrayToList(arr3);
        DoubleLinkedListUtility.printDoubleLinkedList(head3);
        System.out.println("----------------------------------------------------------");

        head3 = RemoveDuplicateFromSortedDLL.removeDuplicatesApproach2(head3);
        DoubleLinkedListUtility.printDoubleLinkedList(head3);
        System.out.println("----------------------------------------------------------");


        Integer[] arr4 = {1,1,1,1,2};
        DoubleLinkedListNode<Integer> head4 = DoubleLinkedListUtility.convertArrayToList(arr4);
        DoubleLinkedListUtility.printDoubleLinkedList(head4);
        System.out.println("----------------------------------------------------------");

        head4 = RemoveDuplicateFromSortedDLL.removeDuplicatesApproach2(head4);
        DoubleLinkedListUtility.printDoubleLinkedList(head4);
        System.out.println("----------------------------------------------------------");
    }
}
