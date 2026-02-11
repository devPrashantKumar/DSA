package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class FindTheStartingPointInLL {
    /*
    * Time Complexity : O(n)
    */
    public static <T> SingleLinkedListNode<T> startingPointInLL(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> tortoise = head;
        SingleLinkedListNode<T> hare = head;

        while(hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise==hare){
                hare = head;
                while(hare!=tortoise){
                    hare = hare.next;
                    tortoise = tortoise.next;
                }
                return hare;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        head.next.next.next.next=head.next;
        //SingleLinkedListUtility.printLinkedList(head);
        System.out.println("output : ");
        SingleLinkedListUtility.printLinkedListNode(FindTheStartingPointInLL.startingPointInLL(head));
        //SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        Integer[] arr2 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        //SingleLinkedListUtility.printLinkedList(head);
        System.out.println("output : "+FindTheStartingPointInLL.startingPointInLL(head2));
        //SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
