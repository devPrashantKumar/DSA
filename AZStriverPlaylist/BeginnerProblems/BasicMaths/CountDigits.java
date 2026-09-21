package AZStriverPlaylist.BeginnerProblems.BasicMaths;

public class CountDigits{
    /*
     * Time Complexity: O(log10N + 1) 
     */
    public static int countNumberOfDigits(int num){
        if(num==0) return 1;
        int counter=0;
        while(num>0){
            num /= 10;
            counter++;
        }
        return counter;
    }

    /*
     * Time Complexity: O(log10(N))
     * Space Complexity: O(log10(N)) - Recursion Stack
     */
    public static int countNumberOfDigitsUsingRecursion(int num){
        if(num==0) return 1;
        return countNumberOfDigitsUsingRecursionUtil(num);
    }

    public static int countNumberOfDigitsUsingRecursionUtil(int num){
        if(num<=0) return 0;
        return 1+countNumberOfDigitsUsingRecursionUtil(num/10);
    }

    /*
     * Time Complexity: O(1) 
     */
    public static int countNumberOfDigitsUsingMaths(int num){
        if(num==0) return 1;
        return (int)(Math.log10(num)+1);
    }

    /*
     * Time Complexity: O(log10N + 1) 
     */
    public static int countNumberOfDigitsUsingString(int num) {
        return String.valueOf(num).length();
    }

    public static void main(String[] args) {
        int input1 = 8721648;
        System.out.println("Input : "+ input1+" Output : "+countNumberOfDigits(input1));
        System.out.println("Input : "+ input1+" Output : "+countNumberOfDigitsUsingRecursion(input1));
        System.out.println("Input : "+ input1+" Output : "+countNumberOfDigitsUsingMaths(input1));
        System.out.println("Input : "+ input1+" Output : "+countNumberOfDigitsUsingString(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+countNumberOfDigits(input2));
        System.out.println("Input : "+ input2+" Output : "+countNumberOfDigitsUsingRecursion(input2));
        System.out.println("Input : "+ input2+" Output : "+countNumberOfDigitsUsingMaths(input2));
        System.out.println("Input : "+ input2+" Output : "+countNumberOfDigitsUsingString(input2));

    }
}