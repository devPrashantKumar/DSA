package AZStriverPlaylist.Recursion.HardProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        Deque<String> stk = new ArrayDeque<>();
        stk.push(""+num.charAt(0));
        StringBuilder str = new StringBuilder();
        str.append(num.charAt(0));
        addOperatorsUtil(num, target, 1, stk, str, result);
        return result; 
    }

    public static void addOperatorsUtil(String num, int target, int index, Deque<String> stk,  StringBuilder str, List<String> result) {
        int n = num.length();
        if(index==n){
            Deque<String> stk2 = new ArrayDeque<>(stk);
            if(calculateStackExpression(stk2)==target){
                result.add(str.toString());
            }
            return;
        }

        str.append('*'); str.append(num.charAt(index));
        Integer top  = Integer.valueOf(stk.pop());
        stk.push(String.valueOf(top*(num.charAt(index)-'0')));
        addOperatorsUtil(num, target, index+1, stk, str, result);
        top  = Integer.valueOf(stk.pop());
        stk.push(String.valueOf(top/(num.charAt(index)-'0')));
        str.delete(str.length()-2, str.length());

        str.append('+'); str.append(num.charAt(index));
        stk.push("+"); stk.push(""+num.charAt(index));
        addOperatorsUtil(num, target, index+1, stk, str, result);
        stk.pop(); stk.pop();
        str.delete(str.length()-2, str.length());

        str.append('-'); str.append(num.charAt(index));
        stk.push("-"); stk.push(""+num.charAt(index));
        addOperatorsUtil(num, target, index+1, stk, str, result);
        stk.pop(); stk.pop();
        str.delete(str.length()-2, str.length());
    }

    public static Long calculateStackExpression(Deque<String> stk){
        Long num = Long.valueOf(stk.pollLast());
        while(!stk.isEmpty()){
            String sign = stk.pollLast();
            Long num2 = Long.valueOf(stk.pollLast());
            if(sign.equals("-")) num  -= num2;
            else num += num2;
        }
        return num;
    }

//     public static Long calculateStackExpression(Deque<String> stk) {

//     Long num = Long.valueOf(stk.pollLast());

//     while (!stk.isEmpty()) {

//         String sign = stk.pollLast();
//         Long num2 = Long.valueOf(stk.pollLast());

//         if (sign.equals("-")) {
//             num -= num2;
//         } else {
//             num += num2;
//         }
//     }

//     return num;
// }

    public static void main(String[] args) {
        String str1 = "123";
        int target1 = 6;
        System.out.println("Input : str -> "+str1+" target -> "+target1);
        System.out.println("Output : "+addOperators(str1, target1));
        System.out.println("----------------------------------------------");
        String str2 = "232";
        int target2 = 8;
        System.out.println("Input : str -> "+str2+" target -> "+target2);
        System.out.println("Output : "+addOperators(str2, target2));
        System.out.println("----------------------------------------------");
        String str3 = "3456237491";
        int target3 = 9191;
        System.out.println("Input : str -> "+str3+" target -> "+target3);
        System.out.println("Output : "+addOperators(str3, target3));
        System.out.println("----------------------------------------------");
        String str4 = "115";
        int target4 = 5;
        System.out.println("Input : str -> "+str4+" target -> "+target4);
        System.out.println("Output : "+addOperators(str4, target4));
        System.out.println("----------------------------------------------");
    }
}
