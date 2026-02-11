package AZStriverPlaylist.LinkedList.MediumProblemsOnDoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

import AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList.DoubleLinkedListNode;
import AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList.DoubleLinkedListUtility;

public class FindPairsWithGivenSumInDoublyLinkedList {
    public static List<List<Integer>> findPairsWithGivenSum(DoubleLinkedListNode<Integer> head, Integer target){
        List<List<Integer>> result = new ArrayList<>();
        if(head==null || head.next==null) return result;

        DoubleLinkedListNode<Integer> tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }

        while(head!=tail){
            if(head.data+tail.data==target){
                result.add(List.of(head.data,tail.data));
                head = head.next;
            }
            else if(head.data+tail.data<target){
                head = head.next;
            }else{
                tail = tail.prev;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 4, 5, 6, 8, 9};
        Integer target1 = 7;
        DoubleLinkedListNode<Integer> head1 = DoubleLinkedListUtility.convertArrayToList(arr1);
        DoubleLinkedListUtility.printDoubleLinkedList(head1);
        System.out.println("----------------------------------------------------------");

        System.out.println(FindPairsWithGivenSumInDoublyLinkedList.findPairsWithGivenSum(head1,target1));
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        
        Integer[] arr2 = {1, 5, 6};
        Integer target2 = 6;
        DoubleLinkedListNode<Integer> head2 = DoubleLinkedListUtility.convertArrayToList(arr2);
        DoubleLinkedListUtility.printDoubleLinkedList(head2);
        System.out.println("----------------------------------------------------------");

        System.out.println(FindPairsWithGivenSumInDoublyLinkedList.findPairsWithGivenSum(head2,target2));
        System.out.println("----------------------------------------------------------");

    }
}
