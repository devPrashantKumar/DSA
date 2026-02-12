package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class SingleLinkedListNode<T> {
    public T data;
    public SingleLinkedListNode<T> next;

    public SingleLinkedListNode(T data){
        this.data = data;
    }

    public SingleLinkedListNode(T data, SingleLinkedListNode<T> next){
        this.data = data;
        this.next = next;
    }
}
