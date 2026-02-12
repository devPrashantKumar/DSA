package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class SortList {
    /*
     * Time Complexity : O(N^2)
     */
    public static SingleLinkedListNode<Integer> sortList(SingleLinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        SingleLinkedListNode<Integer> finalHead = new SingleLinkedListNode<Integer>(null);
        SingleLinkedListNode<Integer> finalTail = finalHead;
        while (head != null) {
            SingleLinkedListNode<Integer> minPrev = null, minCurr = head, prev = null;
            SingleLinkedListNode<Integer> curr = head;
            while (curr != null) {
                if (curr.data < minCurr.data) {
                    minPrev = prev;
                    minCurr = curr;
                }
                prev = curr;
                curr = curr.next;
            }
            if (minPrev == null) {
                head = minCurr.next;
            } else {
                minPrev.next = minCurr.next;
            }
            minCurr.next = null;
            finalTail.next = minCurr;
            finalTail = finalTail.next;
        }
        return finalHead.next;
    }

    /*
     * Time Complexity : O(n log n)
     */
    public static SingleLinkedListNode<Integer> sortListUsingMerge(SingleLinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        SingleLinkedListNode<Integer> middle = findMiddle(head);
        SingleLinkedListNode<Integer> firstHead = head;
        SingleLinkedListNode<Integer> secondHead = middle.next;
        middle.next=null;
        firstHead = sortList(firstHead);
        secondHead = sortList(secondHead);
        return merge(firstHead,secondHead);
    }

    public static SingleLinkedListNode<Integer> findMiddle(SingleLinkedListNode<Integer> head) {
        if(head==null || head.next==null) return head;
        SingleLinkedListNode<Integer> tortoise = head;
        SingleLinkedListNode<Integer> hare = head;
        hare = hare.next;
        while(hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return tortoise;
    }

    public static SingleLinkedListNode<Integer> merge(SingleLinkedListNode<Integer> head1, SingleLinkedListNode<Integer> head2) {
        SingleLinkedListNode<Integer> head = new SingleLinkedListNode<Integer>(-1);
        SingleLinkedListNode<Integer> tail = head;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            tail.next = head1;
            tail = tail.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            tail.next = head2;
            tail = tail.next;
            head2 = head2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 5, 6, 7, 2, 3, 4 };
        
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);

        head = SortList.sortList(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head2);
        head2 = SortList.sortListUsingMerge(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
    }
}
