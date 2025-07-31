package AZStriverPlaylist.BitManipulation;
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

    public static void main(String[] args) {
        System.out.println(BinaryOperator.andOperator(0, 0));
        System.out.println(BinaryOperator.andOperator(0, 5));
        System.out.println(BinaryOperator.andOperator(4, 4));
        System.out.println(BinaryOperator.andOperator(10, 7));
        

        System.out.println("------------------------------------------------------------");

        System.out.println(BinaryOperator.orOperator(0, 0));
        System.out.println(BinaryOperator.orOperator(0, 5));
        System.out.println(BinaryOperator.orOperator(4, 4));
        System.out.println(BinaryOperator.orOperator(10, 7));

        System.out.println("------------------------------------------------------------");

        System.out.println(BinaryOperator.xorOperator(0, 0));
        System.out.println(BinaryOperator.xorOperator(0, 5));
        System.out.println(BinaryOperator.xorOperator(4, 4));
        System.out.println(BinaryOperator.xorOperator(10, 7));

        System.out.println("------------------------------------------------------------");

        System.out.println(BinaryOperator.leftShiftOperator(0, 0));
        System.out.println(BinaryOperator.leftShiftOperator(0, 5));
        System.out.println(BinaryOperator.leftShiftOperator(1, 4));
        System.out.println(BinaryOperator.leftShiftOperator(1, 0));

        System.out.println("------------------------------------------------------------");

        System.out.println(BinaryOperator.rightShiftOperator(0, 0));
        System.out.println(BinaryOperator.rightShiftOperator(0, 5));
        System.out.println(BinaryOperator.rightShiftOperator(32, 4));
        System.out.println(BinaryOperator.rightShiftOperator(1, 0));

        System.out.println("------------------------------------------------------------");

        System.out.println(BinaryOperator.notOperator(0));
        System.out.println(BinaryOperator.notOperator(1));
        System.out.println(BinaryOperator.notOperator(32));
        System.out.println(BinaryOperator.notOperator(-1));

        System.out.println("------------------------------------------------------------");
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(-10));

        System.out.println("------------------------------------------------------------");
        System.out.println(BinaryOperator.orOperator(-10, 1));

    }
}
