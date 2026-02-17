package AZStriverPlaylist.Recursion;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperatorsUtil(num, target, 0, '_',true, new ArrayList<>(), result);
        return result; 
    }

    public static void addOperatorsUtil(String num, int target, int index, char lastChar, boolean nextAlllowed,  List<Character> list, List<String> result) {
        int n = num.length();
        if(index==n){
            if(calculateStackExpression(new ArrayList<>(list))==target){
                StringBuilder str = new StringBuilder();
                for(Character item : list) str.append(item);
                result.add(str.toString());
            }
            return;
        }
        if(!nextAlllowed) return;

        list.add(num.charAt(index));

        if(num.charAt(index)=='0' && (lastChar=='_' || lastChar=='+' || lastChar=='*' || lastChar=='-')){
            nextAlllowed=false;
        }

        if(num.charAt(index)!='0'){
            lastChar = num.charAt(index);
        }

        if(index!=n-1){
            list.add('*');
            addOperatorsUtil(num, target, index+1, '*', true, list, result);
            list.remove(list.size()-1); 

            list.add('+');
            addOperatorsUtil(num, target, index+1, '+', true,list, result);
            list.remove(list.size()-1);

            list.add('-');
            addOperatorsUtil(num, target, index+1, '-', true,list, result);
            list.remove(list.size()-1);
        }
        addOperatorsUtil(num, target, index+1, lastChar,nextAlllowed, list, result);

        list.remove(list.size()-1);
    }

    public static Long calculateStackExpression(List<Character> list){
        List<Long> tempList = new ArrayList<>();
        int i=0;
        while(i<list.size()){
            if(list.get(i)=='+'){
                tempList.add(1L); i++;
            } 
            else if(list.get(i)=='-'){
                tempList.add(-1L); i++;
            } 
            else if(list.get(i)=='*'){
                i++;
                Long operand1 = tempList.get(tempList.size()-1);
                Long operand2 =0L;
                while(i<list.size() && Character.isDigit(list.get(i))){
                    operand2 = (operand2*10)+Character.getNumericValue(list.get(i));
                    i++;
                }
                tempList.remove(tempList.size()-1);
                tempList.add(operand1*operand2);
            }else{
                Long num=0L;
                while(i<list.size() && Character.isDigit(list.get(i))){
                    num = (num*10)+Character.getNumericValue(list.get(i));
                    i++;
                }
                tempList.add(num);
            }
        }
        Long result = tempList.get(0);
        for(i=1;i<tempList.size();i=i+2){
            result += (tempList.get(i)*tempList.get(i+1));
        }
        return result;
    }

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
        String str3 = "3456237490";
        int target3 = 9191;
        System.out.println("Input : str -> "+str3+" target -> "+target3);
        System.out.println("Output : "+addOperators(str3, target3));
        System.out.println("----------------------------------------------");
        String str4 = "105";
        int target4 = 5;
        System.out.println("Input : str -> "+str4+" target -> "+target4);
        System.out.println("Output : "+addOperators(str4, target4));
        System.out.println("----------------------------------------------");
    }
}
