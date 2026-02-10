package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class AddOneToANumberRepresentedByLL {
    public static SingleLinkedListNode<Integer> addOneToLL(SingleLinkedListNode<Integer> head){
        int carry = addOneToLLUtil(head);
        if(carry!=0){
            head = new SingleLinkedListNode<Integer>(carry,head);
        }
        return head;
    }

    public static int addOneToLLUtil(SingleLinkedListNode<Integer> head){
        if(head==null) return 1;
        int carry = addOneToLLUtil(head.next);
        if(carry!=0){
            int data = head.data+carry;
            carry = data/10;
            head.data = data%10;
        }
        return carry;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        
        head = AddOneToANumberRepresentedByLL.addOneToLL(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");

        Integer[] arr2 = {9,9,9,9};
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        SingleLinkedListUtility.printLinkedList(head2);
        
        head2 = AddOneToANumberRepresentedByLL.addOneToLL(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
    }
}
