package AZStriverPlaylist.LinkedList.MediumProblemsOnSinglyLinkedList;

public class SortALinkedListOfZerosAndOnesndTwos {

    /*
    * Time Complexity : O(n)
    */
    public static <T> SingleLinkedListNode<T> sortList(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> zerosListHead = null;
        SingleLinkedListNode<T> onesListHead = null;
        SingleLinkedListNode<T> twosListHead = null;
        SingleLinkedListNode<T> zerosListTail = null;
        SingleLinkedListNode<T> onesListTail= null;
        SingleLinkedListNode<T> twosListTail = null;
        SingleLinkedListNode<T> curr = head;
        while(curr!=null){
            if(curr.data.equals(Integer.valueOf(0))){
                if(zerosListTail==null){
                    zerosListHead = zerosListTail = curr;
                }else{
                    zerosListTail.next = curr;
                    zerosListTail = zerosListTail.next;
                }
            }else if(curr.data.equals(Integer.valueOf(1))){
                if(onesListTail==null){
                    onesListHead = onesListTail = curr;
                }else{
                    onesListTail.next = curr;
                    onesListTail = onesListTail.next;
                }
            }else{
                if(twosListTail==null){
                    twosListHead = twosListTail = curr;
                }else{
                    twosListTail.next = curr;
                    twosListTail = twosListTail.next;
                }
            }
            SingleLinkedListNode<T> temp = curr;
            curr = curr.next;
            temp.next=null;
        }

        if(zerosListHead!=null){
            if(onesListHead!=null){
                zerosListTail.next = onesListHead;
            }else{
                zerosListTail.next = twosListHead;
            }   
        }
        if(onesListHead!=null && twosListHead!=null){
            onesListTail.next = twosListHead;
        }

        return (zerosListHead!=null) ? zerosListHead : ((onesListHead!=null) ? onesListHead : twosListHead);
    }


    /*
    * Time Complexity : O(n)
    */
    public static <T> SingleLinkedListNode<T> sortListUsingdummyHead(SingleLinkedListNode<T> head){
        SingleLinkedListNode<T> zerosListHead = new SingleLinkedListNode<T>(null);
        SingleLinkedListNode<T> onesListHead = new SingleLinkedListNode<T>(null);
        SingleLinkedListNode<T> twosListHead = new SingleLinkedListNode<T>(null);
        SingleLinkedListNode<T> zerosListTail = zerosListHead;
        SingleLinkedListNode<T> onesListTail= onesListHead;
        SingleLinkedListNode<T> twosListTail = twosListHead;
        SingleLinkedListNode<T> curr = head;
        while(curr!=null){
            if(curr.data.equals(Integer.valueOf(0))){
                zerosListTail.next = curr;
                zerosListTail = zerosListTail.next;
            }else if(curr.data.equals(Integer.valueOf(1))){
                onesListTail.next = curr;
                onesListTail = onesListTail.next;
            }else{
                twosListTail.next = curr;
                twosListTail = twosListTail.next;
            }
            SingleLinkedListNode<T> temp = curr;
            curr = curr.next;
            temp.next=null;
        }

        onesListTail.next = twosListHead.next;
        zerosListTail.next = onesListHead.next;

        return zerosListHead.next;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,0,0,1,2,1,2,1,0,0};
        SingleLinkedListNode<Integer> head = SingleLinkedListUtility.convertArrayToList(arr1);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        head = SortALinkedListOfZerosAndOnesndTwos.sortList(head);
        SingleLinkedListUtility.printLinkedList(head);
        System.out.println("----------------------------------------------------------");
        SingleLinkedListNode<Integer> head2 = SingleLinkedListUtility.convertArrayToList(arr1);
        head2 = SortALinkedListOfZerosAndOnesndTwos.sortListUsingdummyHead(head2);
        SingleLinkedListUtility.printLinkedList(head2);
        System.out.println("----------------------------------------------------------");
    }
}
