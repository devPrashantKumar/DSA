package AZStriverPlaylist.LinkedList.ProblemsOnLinkedList;

public class FindTheIntersectionPointOfYLL {

    public static <T> SingleLinkedListNode<T> findIntersectionPoint(SingleLinkedListNode<T> head1, SingleLinkedListNode<T> head2){
        SingleLinkedListNode<T> curr1 = head1;
        SingleLinkedListNode<T> curr2 = head2;
        while(curr1!=curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
            if(curr1==null && curr2!=null) curr1=head2;
            if(curr2==null && curr1!=null) curr2=head1;
        }
        return curr1;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head1 = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head1);
        Integer[] arr2 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        SingleLinkedListUtility.printLinkedList(head2);
        head1.next.next.next = head2.next.next.next;
        
        head1 = FindTheIntersectionPointOfYLL.findIntersectionPoint(head1,head2);
        SingleLinkedListUtility.printLinkedList(head1);
        System.out.println("----------------------------------------------------------");
    }
}