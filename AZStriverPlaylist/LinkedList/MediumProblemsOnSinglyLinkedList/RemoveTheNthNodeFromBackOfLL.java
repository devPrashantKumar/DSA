package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class RemoveTheNthNodeFromBackOfLL {
    /*
     * Time Cmplexity : O(n)
     * Space Complexity : O(1)
     */
    public static <T> SingleLinkedListNode<T> removeNthNodeFromBack(SingleLinkedListNode<T> head, int n){
        SingleLinkedListNode<T> tortoise = head;
        SingleLinkedListNode<T> hare = head;
        SingleLinkedListNode<T> prev = null;
        for(int i=0;i<n;i++){
            if(hare==null) return null;
            hare = hare.next;
        }
        while(hare!=null){
            prev = tortoise;
            tortoise = tortoise.next;
            hare = hare.next;
        }
        if(prev==null) return head.next;
        prev.next = tortoise.next;
        return head;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        head = RemoveTheNthNodeFromBackOfLL.removeNthNodeFromBack(head,1);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head);
        head = RemoveTheNthNodeFromBackOfLL.removeNthNodeFromBack(head,3);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head);
        head = RemoveTheNthNodeFromBackOfLL.removeNthNodeFromBack(head,2);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head);
        head = RemoveTheNthNodeFromBackOfLL.removeNthNodeFromBack(head,4);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
