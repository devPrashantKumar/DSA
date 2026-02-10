package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class AddTwoNumbersInLL {
    public static SingleLinkedListNode<Integer> addTwoNumbersInLL(SingleLinkedListNode<Integer> head1, SingleLinkedListNode<Integer> head2){
        SingleLinkedListNode<Integer> finalHead = null;
        SingleLinkedListNode<Integer> finalTail = null;
        int carry=0;
        while(head1!=null && head2!=null){
            int data = head1.data+head2.data+carry;
            carry = data/10;
            if(finalHead==null){
                finalHead = new SingleLinkedListNode<Integer>(data%10);
                finalTail = finalHead;
            }else{
                finalTail.next = new SingleLinkedListNode<Integer>(data%10);
                finalTail = finalTail.next;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1!=null){
            int data = head1.data+carry;
            carry = data/10;
            if(finalHead==null){
                finalHead = new SingleLinkedListNode<Integer>(data%10);
                finalTail = finalHead;
            }else{
                finalTail.next = new SingleLinkedListNode<Integer>(data%10);
                finalTail = finalTail.next;
            }
            head1 = head1.next;
        }
        while(head2!=null){
            int data = head2.data+carry;
            carry = data/10;
            if(finalHead==null){
                finalHead = new SingleLinkedListNode<Integer>(data%10);
                finalTail = finalHead;
            }else{
                finalTail.next = new SingleLinkedListNode<Integer>(data%10);
                finalTail = finalTail.next;
            }
            head2 = head2.next;
        }
        if(carry!=0){
            finalTail.next = new SingleLinkedListNode<Integer>(carry);
        }
        return finalHead;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head1 = SingleLinkedListUtility.convertArrayToList(arr1);
        Integer[] arr2 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        SingleLinkedListUtility.printLinkedList(head1);
        SingleLinkedListUtility.printLinkedList(head2);

        SingleLinkedListNode<Integer> head3 = AddTwoNumbersInLL.addTwoNumbersInLL(head1,head2);
        SingleLinkedListUtility.printLinkedList(head3);
        System.out.println("----------------------------------------------------------");
    }
}
