package AZStriverPlaylist.LinkedList.ProblemsOnDoubleLinkedList;

public class DoubleLinkedListNode<T> {
    public T data;
    public DoubleLinkedListNode<T> next;
    public DoubleLinkedListNode<T> prev;

    public DoubleLinkedListNode(T data){
        this.data = data;
    }
}
