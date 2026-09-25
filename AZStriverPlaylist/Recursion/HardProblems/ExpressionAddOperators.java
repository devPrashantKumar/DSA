package AZStriverPlaylist.Recursion.HardProblems;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return result;
        }
        StringBuilder expression = new StringBuilder();
        addOperatorsUtil(num,target,0,0,0,expression,result);
        return result;
    }

    private static void addOperatorsUtil(String num,int target,int index,long value,long previous,StringBuilder expression,List<String> result) {
        if (index == num.length()) {
            if (value == target) {
                result.add(expression.toString());
            }
            return;
        }

        int expressionLength = expression.length();
        long currentNumber = 0;

        for (int i = index; i < num.length(); i++) {
            // Leading zero is not allowed
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            currentNumber = currentNumber * 10 + (num.charAt(i) - '0');
            String currentNumberString = num.substring(index, i + 1);

            if (index == 0) {
                expression.append(currentNumberString);
                addOperatorsUtil(num,target,i + 1,currentNumber,currentNumber,expression,result);
                expression.setLength(expressionLength);
            } else {
                expression.append('+');
                expression.append(currentNumberString);
                addOperatorsUtil(num,target,i + 1,value + currentNumber,currentNumber,expression,result);
                expression.setLength(expressionLength);

                expression.append('-');
                expression.append(currentNumberString);
                addOperatorsUtil(num,target,i + 1,value - currentNumber,-currentNumber,expression,result);
                expression.setLength(expressionLength);

                expression.append('*');
                expression.append(currentNumberString);
                // this logic is important
                addOperatorsUtil(num,target,i + 1,((value - previous) + (previous * currentNumber)),previous * currentNumber,expression,result);
                expression.setLength(expressionLength);
            }
        }
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