package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class MiddleOfLinkedList {

    public static <T> SingleLinkedListNode<T> findMiddleofList(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> hare = head;
        SingleLinkedListNode<T> tortoise = head;
        while(hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return tortoise;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        
        head = MiddleOfLinkedList.findMiddleofList(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
