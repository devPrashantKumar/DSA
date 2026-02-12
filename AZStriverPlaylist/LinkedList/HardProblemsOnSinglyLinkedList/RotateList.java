package AZStriverPlaylist.LinkedList.HardProblemsOnSinglyLinkedList;

import AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList.SingleLinkedListNode;
import AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList.SingleLinkedListUtility;

public class RotateList {
    public static <T> SingleLinkedListNode<T> rotateRight(SingleLinkedListNode<T> head, int k){
        if(head==null || head.next==null || k==0) return head;
        SingleLinkedListNode<T> tortoise = head;
        SingleLinkedListNode<T> hare = head;
        for(int i=0;i<k;i++){
            hare = hare.next;
            if(hare==null){
                hare = head;
            }
        }
        while(tortoise.next!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next;
        }
        hare.next = head;
        head = tortoise.next;
        tortoise.next = null;
        return head;
    }

    public static <T> SingleLinkedListNode<T> rotateRight2(SingleLinkedListNode<T> head, int k){
        if(head==null || head.next==null || k==0) return head;
        k = k%length(head);
        if(k==0) return head;
        SingleLinkedListNode<T> tortoise = head;
        SingleLinkedListNode<T> hare = head;
        for(int i=0;i<k;i++){
            hare = hare.next;
        }
        while(tortoise.next!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next;
        }
        hare.next = head;
        head = tortoise.next;
        tortoise.next = null;
        return head;
    }

    public static <T> int length(SingleLinkedListNode<T> head) {
        int count=0;
        SingleLinkedListNode<T> curr = head;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static <T> SingleLinkedListNode<T> rotateRightCircularListApproach(SingleLinkedListNode<T> head, int k){
        if(head==null || head.next==null || k==0) return head;
        int lengthOfList = length(head);
        k = k%lengthOfList;
        if(k==0) return head;
        SingleLinkedListNode<T> tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = head;
        int skipNode = lengthOfList-k;
        SingleLinkedListNode<T> curr = head;
        for(int i=1;i<skipNode;i++){
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5};
        int k1 = 2;
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        head = RotateList.rotateRight(head, k1);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        Integer[] arr2 = {1,2,3,4,5};
        int k2 = 2;
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr2);
        SingleLinkedListUtility.printLinkedList(head2);
        head2 = RotateList.rotateRight2(head2, k2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
        Integer[] arr5 = {1,2,3,4,5};
        int k5 = 2;
        SingleLinkedListNode<Integer> head5 = SingleLinkedListUtility.convertArrayToList(arr5);
        SingleLinkedListUtility.printLinkedList(head5);
        head5 = RotateList.rotateRightCircularListApproach(head5, k5);
        SingleLinkedListUtility.printLinkedList(head5);
        System.out.println("----------------------------------------------------------");
        Integer[] arr3 = {0,1,2};
        int k3 = 4;
        SingleLinkedListNode<Integer> head3 = SingleLinkedListUtility.convertArrayToList(arr3);
        SingleLinkedListUtility.printLinkedList(head3);
        head3 = RotateList.rotateRight(head3, k3);
        SingleLinkedListUtility.printLinkedList(head3);
        System.out.println("----------------------------------------------------------");
        Integer[] arr4 = {0,1,2};
        int k4 = 4;
        SingleLinkedListNode<Integer> head4 = SingleLinkedListUtility.convertArrayToList(arr4);
        SingleLinkedListUtility.printLinkedList(head4);
        head4 = RotateList.rotateRight2(head4, k4);
        SingleLinkedListUtility.printLinkedList(head4);
        System.out.println("----------------------------------------------------------");
        Integer[] arr6 = {0,1,2};
        int k6 = 4;
        SingleLinkedListNode<Integer> head6 = SingleLinkedListUtility.convertArrayToList(arr6);
        SingleLinkedListUtility.printLinkedList(head6);
        head6 = RotateList.rotateRightCircularListApproach(head6, k6);
        SingleLinkedListUtility.printLinkedList(head6);
        System.out.println("----------------------------------------------------------");
    }
}
