package AZStriverPlaylist.Heap;

import java.util.*;

public class MergekSortedLists {
    static class ListNode  implements Comparable<ListNode>{
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public int compareTo(ListNode listNode) {
            return Integer.compare(this.val,listNode.val);
        }
    }

    /*
     * Time Complexity : O(n * m) -> m = total number of nodes
     * Space Complexity : O(1)
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (true) {
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < smallest) {
                    smallest = lists[i].val;
                    smallestIndex = i;
                }
            }
            if(smallestIndex==-1) break;
            tail.next = lists[smallestIndex];
            tail = tail.next;
            lists[smallestIndex] = lists[smallestIndex].next;
        }
        return head.next;
    }

    /*
     * Time Complexity : O(m * log n) -> m = total number of nodes
     * Space Complexity : O(n)
     */
    public static ListNode mergeKListsUsingHeap(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode tail = head;

        Queue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next!=null) pq.add(node.next);
            tail.next = node;
            node.next=null;
            tail = tail.next;
        }
        return head.next;
    }

    public static void printList(ListNode list) {
        if (list == null) {
            System.out.println("list is empty");
            return;

        }
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode[] lists1 = { new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)) };
        printList(mergeKLists(lists1));
        ListNode[] lists11 = { new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)) };
        printList(mergeKListsUsingHeap(lists11));
        System.out.println("======================================================================");
        ListNode[] lists2 = {};
        printList(mergeKLists(lists2));
        printList(mergeKListsUsingHeap(lists2));
        System.out.println("======================================================================");
    }
}
