package AZStriverPlaylist.Strings;

public class LargestOddNumberInString {

    /*
     * Time Complexity : O(n)
     */
    public static String largestOddNumber(String num) {
        int i=num.length()-1;
        for(;i>=0;i--){
            if(Character.getNumericValue(num.charAt(i))%2!=0) break;
        }
        return num.substring(0,i+1);
    }

    public static void main(String[] args) {
        String input1 = "52";
        System.out.println("Input : "+input1+" Output : "+LargestOddNumberInString.largestOddNumber(input1) );
        String input2 = "4206";
        System.out.println("Input : "+input2+" Output : "+LargestOddNumberInString.largestOddNumber(input2) );
        String input3 = "35427";
        System.out.println("Input : "+input3+" Output : "+LargestOddNumberInString.largestOddNumber(input3) );
    }
}
