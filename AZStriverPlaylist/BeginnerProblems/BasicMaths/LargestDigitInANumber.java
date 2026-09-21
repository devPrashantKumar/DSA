package AZStriverPlaylist.BeginnerProblems.BasicMaths;

public class LargestDigitInANumber {

    /*
     * Time Complexity: O(log10(N))
     * Space Complexity: O(1)
     */
    public static int largestDigit(int num) {
        if(num==0) return num;
        int maxNum = Integer.MIN_VALUE;
        while(num>0){
            int digit = num%10;
            if(digit>maxNum) maxNum = digit;
            num /= 10;
        }
        return maxNum;
    }

    /*
     * Time Complexity: O(log10(N))
     * Space Complexity: O(log10(N)) - Recursion Stack
     */
    public static int largestDigitUsingRecursion(int num){
        if(num==0) return num;
        return Math.max(num%10,largestDigitUsingRecursion(num/10));
    }

    /*
     * Time Complexity: O(log10(N))
     * Space Complexity: O(1)
     */
    public static int largestDigitUsingStringConversion(int num) {
        String str = String.valueOf(num);
        int max = 0;
        for (char ch : str.toCharArray()) {
            max = Math.max(max, ch - '0');
        }
        return max;
    }

    public static void main(String[] args) {
        int input1 = 8721648;
        System.out.println("Input : "+ input1+" Output : "+largestDigit(input1));
        System.out.println("Input : "+ input1+" Output : "+largestDigitUsingRecursion(input1));
        System.out.println("Input : "+ input1+" Output : "+largestDigitUsingStringConversion(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+largestDigit(input2));
        System.out.println("Input : "+ input2+" Output : "+largestDigitUsingRecursion(input2));
        System.out.println("Input : "+ input2+" Output : "+largestDigitUsingStringConversion(input2));

    }
}
