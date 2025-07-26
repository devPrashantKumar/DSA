package AZStriverPlaylist.LinkedList.ProblemsOnLinkedList;

public class ReverseLinkedList {

    public static <T> SingleLinkedListNode<T> reverseList(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> curr = head;
        SingleLinkedListNode<T> prev = null;
        while(curr!=null){
            SingleLinkedListNode<T> newNode = curr;
            curr = curr.next;
            newNode.next=prev;
            prev=newNode;
        }
        return prev;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        
        head = ReverseLinkedList.reverseList(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
