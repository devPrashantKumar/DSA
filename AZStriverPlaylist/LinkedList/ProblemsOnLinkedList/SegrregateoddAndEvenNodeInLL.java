package AZStriverPlaylist.LinkedList.ProblemsOnLinkedList;

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
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        
        head = SegrregateoddAndEvenNodeInLL.segregate(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
