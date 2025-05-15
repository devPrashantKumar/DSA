public class TestBinaryNotationUtility {
    public static void main(String[] args) {
        System.out.println(BinaryNotationUtility.decimalToBinaryString(0));
        System.out.println(BinaryNotationUtility.decimalToBinaryString(10));
        System.out.println(BinaryNotationUtility.decimalToBinaryString(8));
        System.out.println(BinaryNotationUtility.decimalToBinaryString(7));

        System.out.println("---------------------------------------------------------");

        System.out.println(BinaryNotationUtility.binaryStringToDecimal("0"));
        System.out.println(BinaryNotationUtility.binaryStringToDecimal("1010"));
        System.out.println(BinaryNotationUtility.binaryStringToDecimal("1000"));
        System.out.println(BinaryNotationUtility.binaryStringToDecimal("111"));
        try {
            System.out.println(BinaryNotationUtility.binaryStringToDecimal("11221"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------------------");

        System.out.println(BinaryNotationUtility.onesComplimentOfBinaryString("0"));
        System.out.println(BinaryNotationUtility.onesComplimentOfBinaryString("1010"));
        System.out.println(BinaryNotationUtility.onesComplimentOfBinaryString("1000"));
        System.out.println(BinaryNotationUtility.onesComplimentOfBinaryString("111"));

        System.out.println("---------------------------------------------------------");

        System.out.println(BinaryNotationUtility.twosComplimentOfBinaryString("0"));
        System.out.println(BinaryNotationUtility.twosComplimentOfBinaryString("1010"));
        System.out.println(BinaryNotationUtility.twosComplimentOfBinaryString("1000"));
        System.out.println(BinaryNotationUtility.twosComplimentOfBinaryString("111"));

    }
}
