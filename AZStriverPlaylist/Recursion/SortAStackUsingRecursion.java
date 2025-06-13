package AZStriverPlaylist.Recursion;

import java.util.Stack;

public class SortAStackUsingRecursion {
    /*
     * Time Complexity O(n^2)
     */
    public static void sortStack(Stack<Integer> stk){
        if(stk.empty()) return;
        Integer element = stk.pop();
        sortStack(stk);
        SortAStackUsingRecursion.insertAtSortedPosition(stk,element);
    }

    public static void insertAtSortedPosition(Stack<Integer> stk, Integer element){
        if(stk.empty()){
            stk.push(element);
            return;
        }
        Integer topElement = stk.peek();
        if(topElement>element){
            Integer element2 = stk.pop();
            insertAtSortedPosition(stk,element);
            stk.push(element2);
        }else{
           stk.push(element); 
        }
        
    }

    public static void main(String[] args) {
        Stack<Integer> stk1 = new Stack<>();
        stk1.push(1);
        stk1.push(3);
        stk1.push(2);
        stk1.push(4);

        System.out.println("Input 1 " + stk1.toString());
        SortAStackUsingRecursion.sortStack(stk1);
        System.out.println("Output 1 " + stk1.toString());
    }
}
