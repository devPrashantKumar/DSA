package AZStriverPlaylist.Strings.Easy;

import java.util.Arrays;

public class LongestCommonPrefix {


    /*
     * Time complexity : O(m*n)
     */
    public static String commanPrefix(String[] strings) {
        int i=0;
        l1 : for(;i<strings[0].length();i++){
            char c = strings[0].charAt(i);
            for(int j=1;j<strings.length;j++){
                if(i==strings[j].length() || strings[j].charAt(i)!=c ) break l1;
            }
        }
        return strings[0].substring(0,i);
    }

    public static String commanPrefixUsingBS(String[] strings) {
        int minLength = Integer.MAX_VALUE;
        for(String s : strings) minLength = Math.min(minLength,s.length());
        if(minLength==0) return "";

        int left = 0;
        int right = minLength-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(checkPrifixMatch(strings,mid)) left = mid+1;
            else right = mid-1;
        }
        return strings[0].substring(0,right+1);
    }

    private static boolean checkPrifixMatch(String[] strings, int index){
        char c = strings[0].charAt(index);
        for(int j=1;j<strings.length;j++){
            if(strings[j].charAt(index)!=c ) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input1 = {"flower","flow","flight"};
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestCommonPrefix.commanPrefix(input1) );
        System.out.println("Input : "+Arrays.toString(input1)+" Output : "+LongestCommonPrefix.commanPrefixUsingBS(input1) );

        String[] input2 = {"dog","racecar","car"};
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestCommonPrefix.commanPrefix(input2) );
        System.out.println("Input : "+Arrays.toString(input2)+" Output : "+LongestCommonPrefix.commanPrefixUsingBS(input2) );

    }
}
