package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class SortList {
    /*
    * Time Complexity : O(N^2)
    */
    public static SingleLinkedListNode<Integer> sortList(SingleLinkedListNode<Integer> head){
        if(head==null || head.next==null) return head;
        SingleLinkedListNode<Integer> finalHead = new SingleLinkedListNode<Integer>(null);
        SingleLinkedListNode<Integer> finalTail = finalHead;
        while(head!=null){
            SingleLinkedListNode<Integer> minPrev = null, minCurr=head, prev=null;
            SingleLinkedListNode<Integer> curr = head;
            while(curr!=null){
                if(curr.data<minCurr.data){
                    minPrev=  prev;
                    minCurr = curr;
                }
                prev = curr;
                curr = curr.next;
            }
            if(minPrev==null){
                head = minCurr.next;
            }else{
                minPrev.next = minCurr.next;
            }
            minCurr.next  = null;
            finalTail.next = minCurr;
            finalTail = finalTail.next;
        }
        return finalHead.next;
    }
    public static void main(String[] args) {
        Integer[] arr1 = {1,5,6,7,2,3,4};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        
        head = SortList.sortList(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        head = ReverseLinkedList.reverseListTailRecursive(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        head = ReverseLinkedList.reverseListClassicRecursive(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
    }
}
