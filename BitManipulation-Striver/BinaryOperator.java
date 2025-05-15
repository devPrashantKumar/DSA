public class BinaryOperator {
    
    public static int andOperator(int operand1, int operand2){
        return operand1&operand2;
    } 
    
    public static int orOperator(int operand1, int operand2){
        System.out.println(Integer.toBinaryString(operand1));
        System.out.println(Integer.toBinaryString(operand2));
        System.out.println(Integer.toBinaryString(operand1|operand2));
        return operand1|operand2;
    }

    public static int xorOperator(int operand1, int operand2){
        return operand1^operand2;
    }

    public static int leftShiftOperator(int operand1, int operand2){
        return operand1<<operand2;
    }

    public static int rightShiftOperator(int operand1, int operand2){
        return operand1>>operand2;
    }

    public static int notOperator(int operand){
        return ~operand;
    }
}
