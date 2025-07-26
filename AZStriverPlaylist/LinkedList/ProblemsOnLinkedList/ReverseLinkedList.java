package AZStriverPlaylist.LinkedList.ProblemsOnLinkedList;

public class ReverseLinkedList {

    public static <T> SingleLinkedListNode<T> reverseListIterative(SingleLinkedListNode<T> head){
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

    public static <T> SingleLinkedListNode<T> reverseListTailRecursive(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> curr = head;
        SingleLinkedListNode<T> prev = null;
        return reverseListTailRecursiveUtil(curr,prev);
    }

    // V.V. Important
    public static <T> SingleLinkedListNode<T> reverseListClassicRecursive(SingleLinkedListNode<T> head){
        if(head==null || head.next==null) return head;
        SingleLinkedListNode<T> newHead = reverseListClassicRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static <T> SingleLinkedListNode<T> reverseListTailRecursiveUtil(SingleLinkedListNode<T> head, SingleLinkedListNode<T> prev){
        if(head==null){
            return prev;
        }
        SingleLinkedListNode<T> curr = head;
        SingleLinkedListNode<T> newNode = curr;
        curr = curr.next;
        newNode.next=prev;
        prev=newNode;
        return reverseListTailRecursiveUtil(curr,prev);
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        
        head = ReverseLinkedList.reverseListIterative(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        head = ReverseLinkedList.reverseListTailRecursive(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        head = ReverseLinkedList.reverseListClassicRecursive(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
