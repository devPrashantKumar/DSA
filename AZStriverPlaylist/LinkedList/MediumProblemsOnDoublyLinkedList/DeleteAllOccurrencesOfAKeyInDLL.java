package AZStriverPlaylist.LinkedList.MediumProblemsOnDoublyLinkedList;

import AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList.DoubleLinkedListNode;
import AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList.DoubleLinkedListUtility;

public class DeleteAllOccurrencesOfAKeyInDLL {
    /*
    * Time Complexity : O(n)
    */
    public static <T> DoubleLinkedListNode<T> deleteAllOccurrences(DoubleLinkedListNode<T> head, T target){
        while(head!=null && head.data.equals(target)){
            head = head.next;
            head.prev = null;
        }
        DoubleLinkedListNode<T> curr = head;
        while(curr!=null){
            if(curr.data.equals(target)){
                if(curr.prev!=null){
                    curr.prev.next = curr.next;
                }
                if(curr.next!=null){
                    curr.next.prev = curr.prev;
                }
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,1,4};
        Integer target1 = 1;
        DoubleLinkedListNode<Integer> head1 = DoubleLinkedListUtility.convertArrayToList(arr1);
        DoubleLinkedListUtility.printDoubleLinkedList(head1);
        System.out.println("----------------------------------------------------------");

        head1 = DeleteAllOccurrencesOfAKeyInDLL.deleteAllOccurrences(head1,target1);
        DoubleLinkedListUtility.printDoubleLinkedList(head1);
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        
        Integer[] arr2 = {2,3,1,4,2};
        Integer target2 = 2;
        DoubleLinkedListNode<Integer> head2 = DoubleLinkedListUtility.convertArrayToList(arr2);
        DoubleLinkedListUtility.printDoubleLinkedList(head2);
        System.out.println("----------------------------------------------------------");

        head2 = DeleteAllOccurrencesOfAKeyInDLL.deleteAllOccurrences(head2,target2);
        DoubleLinkedListUtility.printDoubleLinkedList(head2);
        System.out.println("----------------------------------------------------------");

    }
}
