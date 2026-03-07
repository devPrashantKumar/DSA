package AZStriverPlaylist.StackAndQueues.CollectionLiberaries;
import java.util.*;

public class StackClassInJava {

    public static void main(String[] args){
        Stack<Integer> stk = new Stack<>();
        stk.isEmpty();
        //System.out.println(stk.peek());
        stk.push(10);
        stk.push(12);
        stk.push(15);
        System.out.println(stk.peek());
        System.out.println(stk);
        stk.pop();
        System.out.println(stk);
        System.out.println(stk.pop());
        stk.pop();
        System.out.println(stk);
        stk.pop();        
    }
}