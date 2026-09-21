package AZStriverPlaylist.BeginnerProblems.BasicStrings;

public class LargestOddNumberInString {

    /*
     * Time Complexity : O(n)
     */
    public static String largestOddNumber(String num) {
        int start = 0;
        while(num.charAt(start)=='0') start++;
        int i=num.length()-1;

        for(;i>=start;i--){
            if(Character.getNumericValue(num.charAt(i))%2!=0) break;
        }
        
        return num.substring(start,i+1);
    }

    public static void main(String[] args) {
        String input1 = "00052";
        System.out.println("Input : "+input1+" Output : "+largestOddNumber(input1) );
        String input2 = "4206";
        System.out.println("Input : "+input2+" Output : "+largestOddNumber(input2) );
        String input3 = "35427";
        System.out.println("Input : "+input3+" Output : "+largestOddNumber(input3) );
    }
}
