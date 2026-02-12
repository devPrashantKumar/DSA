package AZStriverPlaylist.LinkedList.HardProblemsOnSinglyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(2*n)
    */
    public static Node copyRandomListBruteForce(Node head) {
        if(head==null) return head;
        Map<Node,Integer> map = new HashMap<>();
        Map<Integer,Node> map2 = new HashMap<>();
        Node curr = head;
        Node newHead = null, newTail=null;
        int i=0;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            if(newHead==null){
                newHead = newTail = newNode;
            }else{
                newTail.next = newNode;
                newTail = newTail.next;
            }
            map.put(curr, i);
            map2.put(i, newNode);
            curr = curr.next;
        }
        curr = head;
        Node newHeadCurr = newHead;
        while(curr!=null){
            if(curr.random!=null){
                newHeadCurr.random = map2.get(map.get(curr.random));
            }
            curr = curr.next;
            newHeadCurr = newHeadCurr.next;
        }
        return newHead;
    }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(n)
    */
    public static Node copyRandomListBruteForce2(Node head) {
        if(head==null) return head;
        Map<Node,Node> map = new HashMap<>();
        Node curr = head;
        Node newHead = null, newTail=null;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            if(newHead==null){
                newHead = newTail = newNode;
            }else{
                newTail.next = newNode;
                newTail = newTail.next;
            }
            map.put(curr,newNode);
            curr = curr.next;
        }
        curr = head;
        Node newHeadCurr = newHead;
        while(curr!=null){
            if(curr.random!=null){
                newHeadCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            newHeadCurr = newHeadCurr.next;
        }
        return newHead;
    }

    /*
    * Time Complexity : O(n)
    * Space Complexity : O(1)
    */
    public static Node copyRandomListOptimised(Node head) {
        if(head==null) return head;
        Node curr = head;
        Node newHead = new Node(-1);
        Node newTail=newHead;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        while(curr!=null){
            newTail.next = curr.next;
            newTail = newTail.next;
            curr.next = curr.next.next;
            curr = curr.next;

        }
        return newHead.next;
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3; node2.random = node1;
        node3.next = node4; node3.random = node5;
        node4.next = node5; node4.random = node3;
        node5.random = node1;

        Node result1 = copyRandomListBruteForce(node1);
        printLinkedList(result1);
        System.out.println("----------------------------------------------------------------");
        Node node21 = new Node(7);
        Node node22 = new Node(13);
        Node node23 = new Node(11);
        Node node24 = new Node(10);
        Node node25 = new Node(1);
        node21.next = node22;
        node22.next = node23; node22.random = node21;
        node23.next = node24; node23.random = node25;
        node24.next = node25; node24.random = node23;
        node25.random = node21;

        Node result21 = copyRandomListBruteForce(node21);
        printLinkedList(result21);
        System.out.println("----------------------------------------------------------------");
        Node node31 = new Node(7);
        Node node32 = new Node(13);
        Node node33 = new Node(11);
        Node node34 = new Node(10);
        Node node35 = new Node(1);
        node31.next = node32;
        node32.next = node33; node32.random = node31;
        node33.next = node34; node33.random = node35;
        node34.next = node35; node34.random = node33;
        node35.random = node31;

        Node result31 = copyRandomListBruteForce(node31);
        printLinkedList(result31);
        System.out.println("----------------------------------------------------------------");
    }
    

}
