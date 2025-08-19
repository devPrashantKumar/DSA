package AZStriverPlaylist.Greedy;

import java.util.*;


public class LRUCache {
    static class Node {
        Node prev;
        int key;
        int data;
        Node next;

        Node(int key,int data) {
            this.key=key;
            this.data = data;
        }
    };

    Map<Integer, Node> map;
    Node head, tail;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    /*
    * Time Complexity : O(1)
    */
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            removeNode(node);
            insertAtHead(node);
            return node.data;
        }
        return -1;
    }

    /*
    * Time Complexity : O(1) avg, beacuse insert in map is O(1) in avg case
    */
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.data = value;
            removeNode(node);
            insertAtHead(node);
        } else if (capacity > 0) {
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            insertAtHead(newNode);
            capacity--;
        } else {
            removeLastNode();
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    public void insertAtHead(Node node) {
        node.prev = head;
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void removeLastNode(){
        map.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    public static void main(String[] args) {

    }
}
