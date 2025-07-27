package AZStriverPlaylist.LinkedList.ProblemsOnLinkedList;

public class SingleLinkedListNode<T> {
    T data;
    SingleLinkedListNode<T> next;

    public SingleLinkedListNode(T data){
        this.data = data;
    }

    public SingleLinkedListNode(T data, SingleLinkedListNode<T> next){
        this.data = data;
        this.next = next;
    }
}
