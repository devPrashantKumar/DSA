package AZStriverPlaylist.BeginnerProblems.BasicMaths;

public class CountOddDigits{
     /*
     * Time Complexity: O(log10(N) + 1)
     * Space Complexity: O(1)
     */
    public static int countNumberOfOddDigits(int num){
        if(num==0) return 0;
        int counter=0;
        while(num>0){
            int digit = num%10;
            num /= 10;
            if(digit%2==1) counter++;
        }
        return counter;
    }

    /*
     * Time Complexity: O(log10(N) + 1)
     * Space Complexity: O(log10(N) + 1) - Recursion Stack
     */
    public static int countNumberOfOddDigitsUsingRecursion(int num){
        if(num<=0) return 0;
        int digit = num%10;
        if(digit%2==1) return 1+countNumberOfOddDigitsUsingRecursion(num/10);
        else return countNumberOfOddDigitsUsingRecursion(num/10);
    }

    public static void main(String[] args) {
        int input1 = 8721648;
        System.out.println("Input : "+ input1+" Output : "+countNumberOfOddDigits(input1));
        System.out.println("Input : "+ input1+" Output : "+countNumberOfOddDigitsUsingRecursion(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+countNumberOfOddDigits(input2));
        System.out.println("Input : "+ input2+" Output : "+countNumberOfOddDigitsUsingRecursion(input2));
    }
}