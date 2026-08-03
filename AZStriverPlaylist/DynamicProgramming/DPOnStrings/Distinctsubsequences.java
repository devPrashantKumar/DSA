package AZStriverPlaylist.DynamicProgramming.DPOnStrings;

public class Distinctsubsequences {
    
    public static int numDistinct(String s, String t) {
        return numDistinctUtil(s,t,s.length()-1,t.length()-1);
    }

    public static int numDistinctUtil(String s, String t, int sIndex, int tIndex) {
        if(tIndex<0) return 1;
        if(sIndex<0) return 0;
        if(s.charAt(sIndex)==t.charAt(tIndex)){
            return numDistinctUtil(s, t, sIndex-1, tIndex-1) + numDistinctUtil(s, t, sIndex-1, tIndex);
        }
        return numDistinctUtil(s, t, sIndex-1, tIndex);
    }


    public static int numDistinctMemoization(String s, String t) {
        Integer[][] dp =  new Integer[s.length()][t.length()];
        return numDistinctUtilMemoization(s,t,s.length()-1,t.length()-1,dp);
    }

    public static Integer numDistinctUtilMemoization(String s, String t, int sIndex, int tIndex, Integer[][] dp) {
        if(tIndex<0) return 1;
        if(sIndex<0) return 0;
        if(dp[sIndex][tIndex]!=null) return dp[sIndex][tIndex];

        if(s.charAt(sIndex)==t.charAt(tIndex)){
            dp[sIndex][tIndex] = numDistinctUtilMemoization(s, t, sIndex-1, tIndex-1,dp) + numDistinctUtilMemoization(s, t, sIndex-1, tIndex,dp);
        }
        else{
            dp[sIndex][tIndex] = numDistinctUtilMemoization(s, t, sIndex-1, tIndex,dp);
        }
        return dp[sIndex][tIndex] ;
    }

    public static int numDistinctTabulation(String s, String t) {
        Integer[][] dp =  new Integer[s.length()+1][t.length()+1];
        for(int i=0;i<=t.length();i++) dp[0][i]=0;
        for(int i=0;i<=s.length();i++) dp[i][0]=1;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static int numDistinctSpaceOptimized(String s, String t) {
        int[] dp = new int[t.length()+1];
        dp[0] = 1;
        for(int i=1;i<=s.length();i++){
            for(int j=t.length();j>=1;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[t.length()];
    }

    public static void main(String[] args) {
        String str1 = "rabbbit";
        String target1 = "rabbit";

        System.out.println(numDistinct(str1, target1));
        System.out.println(numDistinctMemoization(str1, target1));
        System.out.println(numDistinctTabulation(str1, target1));
        System.out.println(numDistinctSpaceOptimized(str1, target1));

        System.out.println("--------------------------------------------------");
        String str11 = "babgbag";
        String target12 = "bag";

        System.out.println(numDistinct(str11, target12));
        System.out.println(numDistinctMemoization(str11, target12));
        System.out.println(numDistinctTabulation(str11, target12));
        System.out.println(numDistinctSpaceOptimized(str11, target12));

        System.out.println("--------------------------------------------------");
    }
}
