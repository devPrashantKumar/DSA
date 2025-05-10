package AZStriverPlaylist.Strings;

public class StringToInteger {
    public static int myAtoiMyApproach(String s) {
        long result = 0;
        int n= s.length();
        boolean  isPositive=true;
        boolean leadingZero=true;
        int i=0;
        for(;i<n;i++){
            if(s.charAt(i)=='-'){
                isPositive=false;
                i++;
                break;
            } 
            else if(s.charAt(i)=='+'){
                isPositive=true;
                i++;
                break;
            } 
            else if(s.charAt(i)==' ') continue;
            else if(Character.isDigit(s.charAt(i))) break;
            else return (int)result;
        }

        for(;i<n;i++){
            if(!Character.isDigit(s.charAt(i))) return (int)((isPositive) ? result : result*-1);
            if(s.charAt(i)=='0' && leadingZero){
                continue;
            } 
            else{
                result = (result*10)+Character.getNumericValue(s.charAt(i));
                long tempResult = (isPositive) ? result : result*-1;
                if(tempResult>Integer.MAX_VALUE) return Integer.MAX_VALUE;
                else if(tempResult<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        return (int)((isPositive) ? result : result*-1);
    }
    public static void main(String[] args) {
        String input1 = "42";
        System.out.println("Input : "+input1+" Output : "+StringToInteger.myAtoiMyApproach(input1) );
        String input2 = "-042";
        System.out.println("Input : "+input2+" Output : "+StringToInteger.myAtoiMyApproach(input2) );
        String input3 = "0-1";
        System.out.println("Input : "+input3+" Output : "+StringToInteger.myAtoiMyApproach(input3) );
    }
}
