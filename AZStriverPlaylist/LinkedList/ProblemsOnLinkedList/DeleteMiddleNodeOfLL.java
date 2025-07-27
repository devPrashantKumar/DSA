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

    public static <T> SingleLinkedListNode<T> deleteMiddleNodeApproach2(SingleLinkedListNode<T> head){
        if(head==null || head.next==null) return null;
        SingleLinkedListNode<T> tortoise = head;
        SingleLinkedListNode<T> hare = head;
        hare = hare.next.next;
        while(hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        tortoise.next = tortoise.next.next;
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

        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");

        Integer[] arr2 = {1,2,3,4};
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        SingleLinkedListUtility.printLinkedList(head2);
        head = DeleteMiddleNodeOfLL.deleteMiddleNodeApproach2(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head2);
        head2 = DeleteMiddleNodeOfLL.deleteMiddleNodeApproach2(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head2);
        head2 = DeleteMiddleNodeOfLL.deleteMiddleNodeApproach2(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListUtility.printLinkedList(head2);
        head2 = DeleteMiddleNodeOfLL.deleteMiddleNodeApproach2(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
    }
}
