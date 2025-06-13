package AZStriverPlaylist.Recursion;

import java.util.Stack;

public class ReverseAStackUsingRecursion {
    /*
     * Time Complexity O(n^2)
     */
    public static void reverseStack(Stack<Integer> stk){
        if(stk.empty()) return;
        Integer element = stk.pop();
        reverseStack(stk);
        ReverseAStackUsingRecursion.insertAtEnd(stk,element);
    }

    public static void insertAtEnd(Stack<Integer> stk, Integer element){
        if(stk.empty()){
            stk.push(element);
            return;
        }
        Integer element2 = stk.pop();
        insertAtEnd(stk,element);
        stk.push(element2);
    }

    public static void main(String[] args) {
        Stack<Integer> stk1 = new Stack<>();
        stk1.push(1);
        stk1.push(2);
        stk1.push(3);
        stk1.push(4);

        System.out.println("Input 1 " + stk1.toString());
        ReverseAStackUsingRecursion.reverseStack(stk1);
        System.out.println("Output 1 " + stk1.toString());
    }
}
