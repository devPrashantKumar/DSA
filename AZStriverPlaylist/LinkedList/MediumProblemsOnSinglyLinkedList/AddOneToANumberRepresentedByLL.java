package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class AddOneToANumberRepresentedByLL {
    /* 
    * Time Complexity : O(n) 
    * Space Complexity : O(n), recursion stack space
    */
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

    /* 
    * Time Complexity : O(n) 
    * Space Complexity : O(1)
    */
    public static SingleLinkedListNode<Integer> addOneToLL2(SingleLinkedListNode<Integer> head){
        int carry = 1;
        if(head==null) return  new SingleLinkedListNode<Integer>(carry);

        head = reverseLL(head);

        SingleLinkedListNode<Integer> prev = null;
        SingleLinkedListNode<Integer> curr = head;
        while(curr!=null && carry != 0){
            int data = carry+curr.data;
            curr.data = data%10;
            carry = data/10;
            prev = curr;
            curr = curr.next;
        }
        if(carry!=0){
            prev.next = new SingleLinkedListNode<Integer>(carry);
        }
        return reverseLL(head);
    }

    public static SingleLinkedListNode<Integer> reverseLL(SingleLinkedListNode<Integer> head){
        SingleLinkedListNode<Integer> prev = null;
        SingleLinkedListNode<Integer> curr =head;
        while(curr!=null){
            SingleLinkedListNode<Integer> currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        return prev;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,8};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        
        System.out.println("----------------------------------------------------------");
        head = AddOneToANumberRepresentedByLL.addOneToLL(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        head = AddOneToANumberRepresentedByLL.addOneToLL2(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");

        System.out.println("----------------------------------------------------------");

        Integer[] arr2 = {9,9,9,9};
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
        head2 = AddOneToANumberRepresentedByLL.addOneToLL2(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
        head2 = AddOneToANumberRepresentedByLL.addOneToLL(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
    }
}
