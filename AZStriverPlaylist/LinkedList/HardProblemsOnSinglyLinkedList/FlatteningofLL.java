package AZStriverPlaylist.LinkedList.HardProblemsOnSinglyLinkedList;

public class FlatteningofLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode() {
            val = 0;
            next = null;
            child = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
            child = null;
        }

        ListNode(int data1, ListNode next1, ListNode next2) {
            val = data1;
            next = next1;
            child = next2;
        }
    }

    /*
    * Time Complexity : O(n^2)
    */
    public static ListNode flattenLinkedListBruteForce(ListNode head) {
        ListNode finalHead = new ListNode();
        ListNode tail = finalHead;
        while (head != null) {
            ListNode prev = null;
            ListNode minPrev = null;
            ListNode minCurr = null;
            int min = Integer.MAX_VALUE;
            ListNode curr = head;
            while (curr != null) {
                if (curr.val < min) {
                    min = curr.val;
                    minPrev = prev;
                    minCurr = curr;
                }
                prev = curr;
                curr = curr.next;
            }
            tail.child = minCurr;
            tail = tail.child;
            if (minPrev != null) {
                if (minCurr.child != null) {
                    minPrev.next = minCurr.child;
                    minCurr.child.next = minCurr.next;
                } else {
                    minPrev.next = minCurr.next;
                }
            } else {
                if (minCurr.child != null) {
                    head = minCurr.child;
                    minCurr.child.next = minCurr.next;
                } else {
                    head = minCurr.next;
                }
            }
        }
        return finalHead.child;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.child;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(3,
                new ListNode(2,
                        new ListNode(1,
                                new ListNode(4, new ListNode(5, null, new ListNode(6, null, new ListNode(8))),
                                        new ListNode(9)),
                                new ListNode(7, null, new ListNode(11, null, new ListNode(12)))),
                        new ListNode(10)),
                null);

        ListNode result1 = flattenLinkedListBruteForce(head1);
        printLinkedList(result1);
    }
}
