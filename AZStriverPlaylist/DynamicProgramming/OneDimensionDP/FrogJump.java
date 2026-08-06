package AZStriverPlaylist.DynamicProgramming.OneDimensionDP;

public class FrogJump {
    /*
     * Time Complexity : O(2^n)
     * Space Complexity : O(n), recursive stack
     */
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


    /*
     * Time Complexity : O(2^n)
     * Space Complexity : O(n), recursive stack
     */
    public static int frogJump2(int[] heights) {
        return frogJumpUtil2(heights,heights.length-1);
    }

    public static int frogJumpUtil2(int[] heights, int end) {
        if(0==end) return 0;
        int oneJump = Math.abs(heights[end-1]-heights[end])+frogJumpUtil2(heights, end-1);
        if(end-2<0) return oneJump;
        int twoJump = Math.abs(heights[end-2]-heights[end])+frogJumpUtil2(heights, end-2);
        return Math.min(oneJump, twoJump);
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)+O(n), (dp array + recursive stack)
     */
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

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static int frogJumpDPTabulation(int[] heights) {
        Integer[] dp = new Integer[heights.length];
        dp[heights.length-1]=0;
        for(int i=heights.length-2;i>=0;i--){
            int oneJump = Math.abs(heights[i]-heights[i+1])+dp[i+1];
            int  twoJump = Integer.MAX_VALUE;
            if(i+2<heights.length)
                twoJump = Math.abs(heights[i]-heights[i+2])+dp[i+2];
            dp[i] = Math.min(oneJump, twoJump);
            
        }
        return dp[0];
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static int frogJumpDPTabulation2(int[] heights) {
        Integer[] dp = new Integer[heights.length];
        dp[0]=0;
        for(int i=1;i<heights.length;i++){
            int oneJump = Math.abs(heights[i]-heights[i-1])+dp[i-1];
            int  twoJump = Integer.MAX_VALUE;
            if(i-2>=0)
                twoJump = Math.abs(heights[i]-heights[i-2])+dp[i-2];
            dp[i] = Math.min(oneJump, twoJump);
            
        }
        return dp[heights.length-1];
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int frogJumpDPTabulationSpaceOptimised(int[] heights) {
        int farlast=-1;
        int last=0;
        for(int i=heights.length-2;i>=0;i--){
            int oneJump = Math.abs(heights[i]-heights[i+1])+last;
            int  twoJump = Integer.MAX_VALUE;
            if(i+2<heights.length)
                twoJump = Math.abs(heights[i]-heights[i+2])+farlast;

            farlast = last;
            last = Math.min(oneJump, twoJump);
        }
        return last;
    }

    public static int frogJumpDPTabulationSpaceOptimised2(int[] heights) {
        int farlast=-1;
        int last=0;
        for(int i=1;i<heights.length;i++){
            int oneJump = Math.abs(heights[i]-heights[i-1])+last;
            int  twoJump = Integer.MAX_VALUE;
            if(i-2>=0)
                twoJump = Math.abs(heights[i]-heights[i-2])+farlast;

            farlast = last;
            last = Math.min(oneJump, twoJump);
        }
        return last;
    }


    public static void main(String[] args) {
        System.out.println(frogJump(new int[]{2, 1, 3, 5, 4}));
        System.out.println(frogJump2(new int[]{2, 1, 3, 5, 4}));

        System.out.println(frogJumpDP(new int[]{2, 1, 3, 5, 4}));
        System.out.println(frogJumpDPTabulation(new int[]{2, 1, 3, 5, 4}));
        System.out.println(frogJumpDPTabulation(new int[]{2, 1, 3, 5, 4}));
        System.out.println(frogJumpDPTabulationSpaceOptimised(new int[]{2, 1, 3, 5, 4}));
        System.out.println(frogJumpDPTabulationSpaceOptimised2(new int[]{2, 1, 3, 5, 4}));

        System.out.println("----------------------------------------------------");

        System.out.println(frogJump(new int[]{7, 5, 1, 2, 6}));
        System.out.println(frogJump2(new int[]{7, 5, 1, 2, 6}));
        System.out.println(frogJumpDP(new int[]{7, 5, 1, 2, 6}));
        System.out.println(frogJumpDPTabulation(new int[]{7, 5, 1, 2, 6}));
        System.out.println(frogJumpDPTabulation(new int[]{7, 5, 1, 2, 6}));
        System.out.println(frogJumpDPTabulationSpaceOptimised(new int[]{7, 5, 1, 2, 6}));
        System.out.println(frogJumpDPTabulationSpaceOptimised2(new int[]{7, 5, 1, 2, 6}));

        System.out.println("----------------------------------------------------");
    }
}
