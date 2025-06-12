package AZStriverPlaylist.LinkedList;

public class DoubleLinkedListNode<T> {
    T data;
    DoubleLinkedListNode<T> next;
    DoubleLinkedListNode<T> prev;

    public DoubleLinkedListNode(T data){
        this.data = data;
    }
}
