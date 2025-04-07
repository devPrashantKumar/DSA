package AZStriverPlaylist.BasicMaths;

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
     * Time Complexity: O(1) 
     */
    public static int countNumberOfDigitsUsingMaths(int num){
        if(num==0) return 1;
        return (int)(Math.log10(num)+1);
    }

    public static void main(String[] args) {
        int input1 = 8721648;
        System.out.println("Input : "+ input1+" Output : "+CountDigits.countNumberOfDigits(input1));
        System.out.println("Input : "+ input1+" Output : "+CountDigits.countNumberOfDigitsUsingMaths(input1));

        System.out.println("-------------------------------------------------------------------------------");
        int input2 = 0;
        System.out.println("Input : "+ input2+" Output : "+CountDigits.countNumberOfDigits(input2));
        System.out.println("Input : "+ input2+" Output : "+CountDigits.countNumberOfDigitsUsingMaths(input2));

    }
}