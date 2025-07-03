package AZStriverPlaylist.StackAndQueues;

import java.util.Stack;

public class OnlineStockSpan {

    Stack<Integer> stk1;
    Stack<Integer> stk2;
    int index;
    public OnlineStockSpan() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
        index=-1;
    }
    
    // this approch is also correct ....
    // public int next(int price) {
    //     int count=1;
    //     while(!stk1.isEmpty() && stk1.peek()<=price){
    //         stk1.pop();
    //         count += stk2.pop();
    //     }
    //     stk1.push(price);
    //     stk2.push(count);
    //     return count; 
    // }

    public int next(int price) {
        index++;
        while(!stk1.isEmpty() && stk1.peek()<=price){
            stk1.pop();
            stk2.pop();
        }
        int ans  = index - (stk2.isEmpty() ? -1 : stk2.peek());
        stk1.push(price);
        stk2.push(index);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
