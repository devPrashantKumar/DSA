package AZStriverPlaylist.DynamicProgramming;

public class FrogJump {
    public static int frogJump(int[] heights) {
        return frogJumpUtil(heights,0,heights.length-1);
    }

    public static int frogJumpUtil(int[] heights, int start, int end) {
        if(start==end) return 0;
        int oneJump = Math.abs(heights[start+1]-heights[start])+frogJumpUtil(heights, start+1, end);
        if(start+2>end) return oneJump;
        int twoJump = Math.abs(heights[start+2]-heights[start])+frogJumpUtil(heights, start+2, end);
        return Math.min(oneJump, twoJump);
    }

    public static int frogJumpDP(int[] heights) {
        Integer[] dp = new Integer[heights.length];
        dp[heights.length-1]=0;
        return frogJumpDPUtil(heights,0,heights.length-1,dp);
    }

    public static int frogJumpDPUtil(int[] heights, int start, int end, Integer[] dp) {
        if(dp[start]!=null) return dp[start];

        int oneJump = Math.abs(heights[start+1]-heights[start])+frogJumpDPUtil(heights, start+1, end,dp);
        if(start+2>end) return oneJump;
        int twoJump = Math.abs(heights[start+2]-heights[start])+frogJumpDPUtil(heights, start+2, end,dp);
        
        dp[start] = Math.min(oneJump, twoJump);
        return dp[start];
    }



    public static void main(String[] args) {
        System.out.println(frogJump(new int[]{2, 1, 3, 5, 4}));
        System.out.println(frogJumpDP(new int[]{2, 1, 3, 5, 4}));

        System.out.println("----------------------------------------------------");

        System.out.println(frogJump(new int[]{7, 5, 1, 2, 6}));
        System.out.println(frogJumpDP(new int[]{7, 5, 1, 2, 6}));

        System.out.println("----------------------------------------------------");
    }
}
