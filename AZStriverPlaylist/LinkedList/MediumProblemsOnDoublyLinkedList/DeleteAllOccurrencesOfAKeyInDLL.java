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
            if (head != null) {
                head.prev = null;
            }
        }
        DoubleLinkedListNode<T> curr = head;
        while(curr!=null){
            if(curr.data.equals(target)){
                curr.prev.next = curr.next;
                if(curr.next!=null){
                    curr.next.prev = curr.prev;
                }
            }
            curr = curr.next;
        }
        return head;
    }

    public static <T> DoubleLinkedListNode<T> deleteAllOccurrences2(DoubleLinkedListNode<T> head, T target){
        DoubleLinkedListNode<T> curr = head;
        while(curr!=null){
            if(curr.data.equals(target)){
                if(curr.prev==null){
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }
                else{
                    curr.prev.next = curr.next;
                    if(curr.next!=null){
                        curr.next.prev = curr.prev;
                    }
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

        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");

        Integer[] arr3 = {1,2,3,1,4};
        Integer target3 = 1;
        DoubleLinkedListNode<Integer> head3 = DoubleLinkedListUtility.convertArrayToList(arr3);
        DoubleLinkedListUtility.printDoubleLinkedList(head3);
        System.out.println("----------------------------------------------------------");

        head3 = DeleteAllOccurrencesOfAKeyInDLL.deleteAllOccurrences2(head3,target3);
        DoubleLinkedListUtility.printDoubleLinkedList(head3);
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        
        Integer[] arr4 = {2,3,1,4,2};
        Integer target4 = 2;
        DoubleLinkedListNode<Integer> head4 = DoubleLinkedListUtility.convertArrayToList(arr4);
        DoubleLinkedListUtility.printDoubleLinkedList(head4);
        System.out.println("----------------------------------------------------------");

        head4 = DeleteAllOccurrencesOfAKeyInDLL.deleteAllOccurrences2(head4,target4);
        DoubleLinkedListUtility.printDoubleLinkedList(head4);
        System.out.println("----------------------------------------------------------");


    }
}
