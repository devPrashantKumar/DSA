package AZStriverPlaylist.LinkedList.ProblemsOnLinkedList;

public class DeleteMiddleNodeOfLL {
    /*
     * Time Cmplexity : O(n)
     * Space Complexity : O(1)
     */
    public static <T> SingleLinkedListNode<T> deleteMiddleNode(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> tortoise = head;
        SingleLinkedListNode<T> hare = head;
        SingleLinkedListNode<T> prev = null;
        while(hare!=null && hare.next!=null){
            prev = tortoise;
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        if(prev==null) return head.next;
        prev.next = tortoise.next;
        return head;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        head = DeleteMiddleNodeOfLL.deleteMiddleNode(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head);
        head = DeleteMiddleNodeOfLL.deleteMiddleNode(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head);
        head = DeleteMiddleNodeOfLL.deleteMiddleNode(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head);
        head = DeleteMiddleNodeOfLL.deleteMiddleNode(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
