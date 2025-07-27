package AZStriverPlaylist.LinkedList.ProblemsOnLinkedList;

public class DetectALoopInLL {
    public static <T> boolean detectLoop(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> tortoise = head;
        SingleLinkedListNode<T> hare = head;

        while(hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise==hare){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        head.next.next.next=head;
        //SingleLinkedListUtility.printLinkedList(head);
        System.out.println("output : "+DetectALoopInLL.detectLoop(head));
        //SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        Integer[] arr2 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        //SingleLinkedListUtility.printLinkedList(head);
        System.out.println("output : "+DetectALoopInLL.detectLoop(head2));
        //SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
