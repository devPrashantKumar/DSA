package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class SegrregateoddAndEvenNodeInLL {
    public static <T> SingleLinkedListNode<T> segregate(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> finalHead = head;
        SingleLinkedListNode<T> prev = null;
        SingleLinkedListNode<T> evenHead = null;
        SingleLinkedListNode<T> evenTail = null;
        int i=1;
        while(head!=null){
            if(i%2!=0){
                prev = head;
            }
            else{
                if(evenHead==null){
                    evenHead=head;
                    evenTail=head;
                }else{
                    evenTail.next=head; 
                    evenTail = evenTail.next;
                }
                prev.next = head.next;
                
            }
            head = head.next;
            i++;
        }
        prev.next = evenHead;
        evenTail.next=null;
        return finalHead;
    }

    // Short Code
    public static <T> SingleLinkedListNode<T> segregate2(SingleLinkedListNode<T> head){
        if(head==null || head.next==null) return head;
        SingleLinkedListNode<T> odd = head;
        SingleLinkedListNode<T> evenHead = head.next;
        SingleLinkedListNode<T> even = head.next;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");

        head = SegrregateoddAndEvenNodeInLL.segregate(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr1);
        head2 = SegrregateoddAndEvenNodeInLL.segregate2(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
    }
}
