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

    public static Node copyRandomList(Node head) {
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

        Node result1 = copyRandomList(node1);
        printLinkedList(result1);
        System.out.println("----------------------------------------------------------------");
    }
    

}
